package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetofaculdademobile2.Service.ProjectService
import com.example.projetofaculdademobile2.Model.ProjectModel
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

            val userData = getFormData()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.116:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val projectService = retrofit.create(ProjectService::class.java)
            val call = projectService.postProject(userData)

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>,
                ) {
                    if (response.code() == 201) {
                        Toast.makeText(
                            this@PostProject,
                            "Projeto salvo com sucesso",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this@PostProject,
                            "Falha ao publicar projeto",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(this@PostProject, "Falha na chamada", Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
        }

    }
    private fun getFormData(): ProjectModel {
        val title = binding.TituloPublicacao.text.toString()
        val description = binding.DescriptionPublicacao.text.toString()
        val userId = "1"
        // preciso ajeitar isso, ao inves de retonar todos esses texto que tá aí em baixo eu tenho que pegar os dados que veio do usuário e passar ele aí em baixo
        return ProjectModel("scooby-doo", "tururururururuururururururururururu", "1");
    }
}