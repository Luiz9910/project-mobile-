package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
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

    fun isPasswordStrong(password: String): Boolean {
        val minLength = 8
        val hasUppercase = password.matches(".*[A-Z].*".toRegex())
        val hasLowercase = password.matches(".*[a-z].*".toRegex())
        val hasDigit = password.matches(".*\\d.*".toRegex())
        val hasSpecialChar = password.matches(".*[@#$%^&+=].*".toRegex())

        return password.length >= minLength && hasUppercase && hasLowercase && hasDigit && hasSpecialChar
    }


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

            var hasError = false

            if (name.isEmpty()) {
                binding.editNome.error = "Campo obrigatório"
                hasError = true
            }

            if (email.isEmpty()) {
                binding.editEmail.error = "Campo obrigatório"
                hasError = true
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editEmail.error = "Formato de e-mail inválido"
                hasError = true
            }

            if (password.isEmpty()) {
                binding.editSenha.error = "Campo obrigatório"
                hasError = true
            } else if (password.length < 8) {
                binding.editSenha.error = "Tem que ter 6 caracteres"
                hasError = true
            } else if (!isPasswordStrong(password)) {
                binding.editSenha.error = "Senha fraca. Use uma senha mais forte."
                hasError = true
            }

            if (hasError) {
                return@setOnClickListener
            }

            val userData = getFormData()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.116:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val userService = retrofit.create(UserService::class.java)
            val call = userService.createUser(userData)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.code() == 201) {
                        Toast.makeText(this@Register, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                        val toLogin = Intent(this@Register, MainActivity::class.java)
                        startActivity(toLogin)
                        return;
                    }

                    if (response.code() == 400) {
                        binding.editEmail.error = "Email já está sendo utilizado"
                        return;
                    }

                    if (response.code() == 500) {
                        Toast.makeText(this@Register, "Falha ao cadastrar o usuário", Toast.LENGTH_SHORT).show()
                        return;
                    }
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
        val description = "communityaid"
        val isCompany = "Sim"

        return UserModel(name, email, password, description, isCompany)
    }
}