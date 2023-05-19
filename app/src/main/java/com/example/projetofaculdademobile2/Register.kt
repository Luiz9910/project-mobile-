package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
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

                if (password.isEmpty()) {
                    binding.editSenha.error = "Campo obrigatório"
                }
            } else {
                Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                val toLogin = Intent(this, MainActivity::class.java)
                startActivity(toLogin)
            }
        }
    }
    val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
    var radioButtonSelected: RadioButton? = null

    binding.radioGroup.setOnCheckedChangeListener { checkedId ->
        radioButtonSelected = findViewById(checkedId)
    }

// Exibir o RadioButton selecionado em algum lugar, por exemplo, ao clicar em um botão:
    button.setOnClickListener {
        val selectedOption = radioButtonSelected?.text.toString()
        txtProfile.text = "Opção selecionada: $selectedOption"
    }
}