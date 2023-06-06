package com.example.projetofaculdademobile2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofaculdademobile2.Model.LoginResponse
import com.example.projetofaculdademobile2.Model.UserModel
import com.example.projetofaculdademobile2.Service.UserService
import com.example.projetofaculdademobile2.databinding.ActivityEditProfileBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditProfile : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateUserProfile.setOnClickListener {
            val userData = getFormData()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.116:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
            val id = sharedPreferences.getString("id", "")

            val userService = retrofit.create(UserService::class.java)
            val call = userService.updateUser(id, userData)

            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>,
                ) {
                    if (response.code() == 200) {
                        Toast.makeText(
                            this@EditProfile,
                            "Dados atualizados com sucesso",
                            Toast.LENGTH_SHORT
                        ).show()
                        val loginResponse = response.body()
                        val editor = sharedPreferences.edit()
                        editor.putString("id", loginResponse?.id.toString())
                        editor.putString("email", loginResponse?.email)
                        editor.putString("name", loginResponse?.name)
                        editor.putString("description", loginResponse?.description)
                        editor.apply()
                    }

                    if (response.code() == 404) {
                        Toast.makeText(
                            this@EditProfile,
                            "Usuário não encontrado para atualizar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    if (response.code() == 500){
                        Toast.makeText(
                            this@EditProfile,
                            "Falha ao atualizar dados",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@EditProfile, "Falha na chamada", Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
        }
    }

    private fun getFormData(): UserModel {
        val nameInput = binding.editNome.getText().toString()
        val emailInput = binding.editEmail.getText().toString()
        val passwordInput = binding.editPassword.getText().toString()
        val descriptionInput = binding.editDescricao.getText().toString()
        // preciso ajeitar isso, ao inves de retonar todos esses texto que tá aí em baixo eu tenho que pegar os dados que veio do usuário e passar ele aí em baixo
        return UserModel(name = nameInput, email = emailInput, password =  passwordInput, description = descriptionInput , isCompany = "Nao");
    }
}