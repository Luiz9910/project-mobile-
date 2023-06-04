package com.example.projetofaculdademobile2

<<<<<<< HEAD
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetofaculdademobile2.Model.UserModel
import com.example.projetofaculdademobile2.Service.UserService
import com.example.projetofaculdademobile2.databinding.ActivityEditProfileBinding
import com.example.projetofaculdademobile2.databinding.ActivityRegisterBinding
=======
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofaculdademobile2.Model.UserModel
import com.example.projetofaculdademobile2.Service.UserService
import com.example.projetofaculdademobile2.databinding.ActivityEditProfileBinding
>>>>>>> 4607ab477cb769b73242cd9facefc5fc36c27bfb
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditProfile : AppCompatActivity() {
<<<<<<< HEAD

    private lateinit var binding
            : ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userData = getFormData()
    val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.3.237:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userService = retrofit.create(UserService::class.java)
    val call = userService.createUser(userData)

    call.enqueue(object : Callback<ResponseBody> {
        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            Toast.makeText(this@EditProfile, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            val toLogin = Intent(this@EditProfile, MainActivity::class.java)
            startActivity(toLogin)
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(this@EditProfile, "Falha na chamada", Toast.LENGTH_SHORT).show()
            t.printStackTrace()
        }
    })
}
    private fun getFormData(): UserModel {
        val name = binding.editNome.text.toString()
        val email = binding.editEmail.text.toString()
        val description = "sei lá"
        val isCompany = "Sim"

        return UserModel(name, email, description, isCompany)
    }

    private fun UserModel(name: String, email: String, password: String?, description: String): UserModel {

        return TODO("Provide the return value")
=======
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
    }

    private fun getFormData(): UserModel {
        val name = binding.editNome.text.toString()
        val email = binding.editEmail.text.toString()
        val password = "123"
        val description = binding.editDescriO.text.toString()
        println(UserModel(name, email, password, description, isCompany = "Nao"))
        // preciso ajeitar isso, ao inves de retonar todos esses texto que tá aí em baixo eu tenho que pegar os dados que veio do usuário e passar ele aí em baixo
        return UserModel("scooby", "mfmsdf@gmail.com", "fsdfsdfsd", "fsdfsdf", isCompany = "Nao");
>>>>>>> 4607ab477cb769b73242cd9facefc5fc36c27bfb
    }
}