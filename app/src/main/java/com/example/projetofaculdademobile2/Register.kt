package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetofaculdademobile2.databinding.ActivityMainBinding
import com.example.projetofaculdademobile2.databinding.ActivityRegisterBinding

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

            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            val toLogin = Intent(this, MainActivity::class.java)
            startActivity(toLogin)
        }
    }
}