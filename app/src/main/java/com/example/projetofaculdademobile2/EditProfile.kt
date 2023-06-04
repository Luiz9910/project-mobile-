package com.example.projetofaculdademobile2

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofaculdademobile2.Model.UserProfile
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

                val name = binding.editNome.text.toString()
                val description = binding.editDescricao.text.toString()
                val email = binding.editEmail.text.toString()

                var hasError = false

                if (name.isEmpty()) {
                    binding.editNome.error = "Campo obrigatório"
                    hasError = true
                }

                if (description.isEmpty()) {
                    binding.editDescricao.error = "Campo obrigatório"
                    hasError = true
                }

                if (email.isEmpty()) {
                    binding.editEmail.error = "Campo obrigatório"
                    hasError = true
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.editEmail.error = "Formato de e-mail inválido"
                    hasError = true
                }

                if (hasError) {
                    return@setOnClickListener
                }


            }
            val userData = getFormData()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.116:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val userService = retrofit.create(UserService::class.java)
            val call = userService.updateUser(2, userData)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>,
                ) {
                    if (response.code() == 200) {
                        Toast.makeText(
                            this@EditProfile,
                            "Dados atualizados com sucesso",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@EditProfile,
                            "Falha ao atualizar dados",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@EditProfile, "Falha na chamada", Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
      }
    private fun getFormData(): UserProfile {
        val name = binding.editNome.text.toString()
        val email = binding.editEmail.text.toString()
        val description = binding.editDescricao.text.toString()
        println(UserProfile(name, email, description))
        // preciso ajeitar isso, ao inves de retonar todos esses texto que tá aí em baixo eu tenho que pegar os dados que veio do usuário e passar ele aí em baixo
        return UserProfile("scooby", "mfmsdf@gmail.com", "fsdfsdfsd");
    }
    }


