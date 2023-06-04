package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.projetofaculdademobile2.databinding.ActivityMainBinding

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

                var hasError = false

                if (email.isEmpty()) {
                    binding.editEmail.error = "Campo obrigatório"
                    hasError = true
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.editEmail.error = "Formato de e-mail inválido"
                    hasError = true
                }

                if (password.isEmpty()) {
                    binding.editSenha.error = "Campo obrigatório"
                }

                return@setOnClickListener
            }


            val navigationFeed = Intent(this, Feed::class.java)
            startActivity(navigationFeed)
        }

        // register
        binding.loginToRegister.setOnClickListener {
            val navigationToRegister = Intent(this, Register::class.java)
            startActivity(navigationToRegister)
        }
    }

}