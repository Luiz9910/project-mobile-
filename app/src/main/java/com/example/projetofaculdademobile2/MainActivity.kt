package com.example.projetofaculdademobile2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.projetofaculdademobile2.Model.LoginRequest
import com.example.projetofaculdademobile2.Model.LoginResponse
import com.example.projetofaculdademobile2.Service.UserService
import com.example.projetofaculdademobile2.databinding.ActivityMainBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //login
        binding.logar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()

            if (email.isEmpty() || password.isEmpty()) {

                if (email.isEmpty()) {
                    binding.editEmail.error = "Campo obrigatório"

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.editEmail.error = "Formato de e-mail inválido"
                }

                if (password.isEmpty()) {
                    binding.editSenha.error = "Campo obrigatório"
                }

                return@setOnClickListener
            }


            val userData = getFormData()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.116:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val userService = retrofit.create(UserService::class.java)
            val call = userService.login(userData)

            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()

                        // Salvar os dados do usuário
                        val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.putString("email", loginResponse?.email)
                        editor.putString("name", loginResponse?.name)
                        editor.apply()

                        Toast.makeText(this@MainActivity, "Login feito com sucesso\nNome: ${loginResponse?.name}\nEmail: ${loginResponse?.email}", Toast.LENGTH_SHORT).show()

                        val toFeed = Intent(this@MainActivity, Feed::class.java)
                        startActivity(toFeed)
                        return
                    }

                    if (response.code() == 400) {
                        Toast.makeText(this@MainActivity, "Email ou senha incorreta" ,Toast.LENGTH_SHORT).show()
                        return;
                    }

                    if (response.code() == 500) {
                        Toast.makeText(this@MainActivity, "Falha ao cadastrar o usuário", Toast.LENGTH_SHORT).show()
                        return;
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Falha na chamada", Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
        }

        // register
        binding.loginToRegister.setOnClickListener {
            val navigationToRegister = Intent(this, Register::class.java)
            startActivity(navigationToRegister)
        }
    }

    private fun getFormData(): LoginRequest {
        val email = binding.editEmail.getText().toString()
        val password = binding.editSenha.getText().toString()

        return LoginRequest(email, password)
    }
}