package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetofaculdademobile2.Model.UserModel
import com.example.projetofaculdademobile2.Service.UserService
import com.example.projetofaculdademobile2.databinding.ActivityEditProfileBinding
import com.example.projetofaculdademobile2.databinding.ActivityRegisterBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditProfile : AppCompatActivity() {

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
    }
}