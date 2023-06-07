package com.example.projetofaculdademobile2.ListProjectProfile

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.Model.CommentModel
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.Service.ProjectService
import com.example.projetofaculdademobile2.databinding.ListItemPostUserProjectProfileBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProjectProfileDetailsViewHolder(val listItemPostUserProjectProfileBinding: ListItemPostUserProjectProfileBinding) :
    RecyclerView.ViewHolder(listItemPostUserProjectProfileBinding.root) {

    fun bind(projectModelParcelize: ProjectModelParcelize) {

        projectModelParcelize?.let { it ->
            listItemPostUserProjectProfileBinding.title.text = it.title
            listItemPostUserProjectProfileBinding.description.text = it.body
            listItemPostUserProjectProfileBinding.idProject.text = it.userid

            listItemPostUserProjectProfileBinding.DeleteProfileList.setOnClickListener {
                val projectId = it.tag.toString() // Obtém o ID do projeto do elemento clicado

                // Chame o método para excluir o projeSto com o ID correspondente na sua API
                deleteProject(projectId)
            }
        }
    }

    private fun deleteProject(projectId: String) {
        // Crie um objeto Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.116:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Crie um serviço usando a interface que contém os métodos de requisição
        val service = retrofit.create(ProjectService::class.java)

        // Chame o método para excluir o projeto
        val call: Call<ResponseBody> = service.deleteProject(projectId)

        // Faça a chamada
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                // Verifique a resposta do servidor
                if (response.isSuccessful) {

                } else {
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }
        })
    }
}
