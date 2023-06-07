package com.example.projetofaculdademobile2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.projetofaculdademobile2.Model.ProjectModel
import com.example.projetofaculdademobile2.Service.ProjectService
import com.example.projetofaculdademobile2.databinding.ActivityEditProjectBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditProject : AppCompatActivity() {
    private lateinit var binding: ActivityEditProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabBar.toFeedMenu.setOnClickListener {
            var toFeed = Intent(this, Feed::class.java)
            startActivity(toFeed)
        }

        binding.tabBar.toSearchMenu.setOnClickListener {
            var toEditPublication = Intent(this, Search::class.java)
            startActivity(toEditPublication)
        }

        binding.tabBar.toPostMenu.setOnClickListener {
            var toPost = Intent(this, PostProject::class.java)
            startActivity(toPost)
        }

        binding.tabBar.toProfileMenu.setOnClickListener {
            val toProfile = Intent(this, Profile::class.java)
            startActivity(toProfile)
        }

        binding.tabBar.toLogout.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear() // Limpa todos os valores armazenados no SharedPreferences
            editor.apply()
            val toLogout = Intent(this, MainActivity::class.java)
            startActivity(toLogout)
        }

        binding.register.setOnClickListener {
            val userData = getFormData()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.116:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val projectId = intent.getStringExtra("id")

            val projectService = retrofit.create(ProjectService::class.java)
            val call = projectService.updateProject("2", userData)

            call.enqueue(object : Callback<ProjectModel> {
                override fun onResponse(
                    call: Call<ProjectModel>,
                    response: Response<ProjectModel>,
                ) {
                    if (response.code() == 200) {
                        Toast.makeText(
                            this@EditProject,
                            "Dados atualizados com sucesso",
                            Toast.LENGTH_SHORT
                        ).show()

                        toProfile()
                    }

                    if (response.code() == 404) {
                        Toast.makeText(
                            this@EditProject,
                            "Usuário não encontrado para atualizar",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    if (response.code() == 500){
                        Toast.makeText(
                            this@EditProject,
                            "Falha ao atualizar dados",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ProjectModel>, t: Throwable) {
                    Toast.makeText(this@EditProject, "Falha na chamada", Toast.LENGTH_SHORT).show()
                    t.printStackTrace()
                }
            })
        }
    }

    private fun getFormData(): ProjectModel {
        val nameInput = binding.editTitulodaPublicaO.getText().toString()
        val emailInput = binding.editPublicaO.getText().toString()
        val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
        val id = sharedPreferences.getString("id", "")

        // preciso ajeitar isso, ao inves de retonar todos esses texto que tá aí em baixo eu tenho que pegar os dados que veio do usuário e passar ele aí em baixo
        return ProjectModel(nameInput, emailInput, id);
    }

    private fun toProfile() {
        val toProfile = Intent(this, Profile::class.java)
        startActivity(toProfile)
    }
}
