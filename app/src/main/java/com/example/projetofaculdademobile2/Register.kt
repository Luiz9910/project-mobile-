package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetofaculdademobile2.Model.UserModel
import com.example.projetofaculdademobile2.Service.UserService
import com.example.projetofaculdademobile2.databinding.ActivityMainBinding
import com.example.projetofaculdademobile2.databinding.ActivityRegisterBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Register : AppCompatActivity() {

    private lateinit var binding
            : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {
            val name = binding.editNome.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()


            if (name.isEmpty() || name.isEmpty() || password.isEmpty()) {
                if (name.isEmpty()) {
                    binding.editNome.error = "Campo obrigatório"
                }

                if (email.isEmpty()) {
                    binding.editEmail.error = "Campo obrigatório"
                }

                if (!email.contains("@gmail.com", ignoreCase = true)) {
                    binding.editEmail.error = "Obrigatório @gmail.com"
                }

                if (password.isEmpty()) {
                    binding.editSenha.error = "Campo obrigatório"
                }

                if (password.length < 6) {
                    binding.editSenha.error = "Tem que ter 6 caracteres"
                }

                return@setOnClickListener
            }

            val userData = getFormData()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.3.237:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val userService = retrofit.create(UserService::class.java)
            val call = userService.createUser(userData)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    Toast.makeText(this@Register, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                    val toLogin = Intent(this@Register, MainActivity::class.java)
                    startActivity(toLogin)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@Register, "Falha na chamada", Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
        }
    }

    private fun getFormData(): UserModel {
        val name = binding.editNome.text.toString()
        val email = binding.editEmail.text.toString()
        val password = binding.editSenha.text.toString()
        val description = "sei lá"
        val isCompany = "Sim"

        return UserModel(name, email, password, description, isCompany)
    }
}