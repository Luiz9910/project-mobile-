package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetofaculdademobile2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // register
        binding.loginToRegister.setOnClickListener {
            val navigationToRegister = Intent(this, Register::class.java)
            startActivity(navigationToRegister)
        }

        //login
        binding.logar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()

            if (email.isEmpty() || password.isEmpty()) {

                if (email.isEmpty()) {
                    binding.editEmail.error = "Campo obrigatório"
                }

                if (password.isEmpty()) {
                    binding.editSenha.error = "Campo obrigatório"
                }

            } else {
                val navigationFeed = Intent(this, tela3::class.java)

                startActivity(navigationFeed)
            }
        }
    }

}