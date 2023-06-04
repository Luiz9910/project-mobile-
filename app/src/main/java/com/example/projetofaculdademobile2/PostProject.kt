package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetofaculdademobile2.Service.UserService
import com.example.projetofaculdademobile2.databinding.ActivityPostProjectBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class PostProject : AppCompatActivity() {
    private lateinit var binding: ActivityPostProjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabBar.toFeedMenu.setOnClickListener {
            var toFeed = Intent(this, Feed::class.java)
            startActivity(toFeed)
        }

        binding.tabBar.toSearchMenu.setOnClickListener {
            var toEditPublication = Intent(this, Search::class.java)
            startActivity(toEditPublication)
        }

        binding.tabBar.toProfileMenu.setOnClickListener {
            val toProfile = Intent(this, Profile::class.java)
            startActivity(toProfile)
        }

        binding.tabBar.toLogout.setOnClickListener {
            val toLogout = Intent(this, MainActivity::class.java)
            startActivity(toLogout)
        }
        binding.publicationProjct.setOnClickListener {
            val title = binding.TituloPublicacao.text.toString()
            val descricao = binding.DescriptionPublicacao.text.toString()

            if (title.isEmpty() || descricao.isEmpty()) {
                if (title.isEmpty()) {
                    binding.TituloPublicacao.error = "Campo obrigatório"
                }

                if (descricao.isEmpty()) {
                    binding.DescriptionPublicacao.error = "Campo obrigatório"
                }

                if (descricao.length < 6) {
                    binding.DescriptionPublicacao.error = "Tem que ter no minimo 6 caracteres"
                }

                return@setOnClickListener
            }

        }

    }
    }