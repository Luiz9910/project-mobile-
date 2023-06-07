package com.example.projetofaculdademobile2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofaculdademobile2.ListProjectFeed.FeedProjectsListAdapter
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.Service.ProjectService
import com.example.projetofaculdademobile2.databinding.ActivityFeedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Feed : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private lateinit var projectModelParcelizes: ArrayList<ProjectModelParcelize>
    private lateinit var adapter: FeedProjectsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpList()
        binding.run {
            makeRequest()
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
    }

    private fun changeElementsVisibility(
        errorMessageVisibility: Int = View.GONE,
        emptyMessageVisibility: Int = View.GONE,
        rvVisibilityMessageVisibility: Int = View.GONE
    ) {
        binding.erroMessage.visibility = errorMessageVisibility
        binding.emptyMessage.visibility = emptyMessageVisibility
        binding.listProject.visibility = rvVisibilityMessageVisibility
    }


    private fun makeRequest() {
        val instance = Retrofit.Builder()
            .baseUrl("http://192.168.0.116:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = instance.create(ProjectService::class.java)

        val response: Call<List<ProjectModelParcelize>> = service.listProject("projects")

        response.enqueue(object : Callback<List<ProjectModelParcelize>> {
            override fun onResponse(
                call: Call<List<ProjectModelParcelize>>,
                response: Response<List<ProjectModelParcelize>>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        projectModelParcelizes.addAll(it)
                        adapter.notifyItemRangeChanged(0, it.size)
                        changeElementsVisibility(rvVisibilityMessageVisibility = View.VISIBLE)
                    } ?: run {
                        changeElementsVisibility(errorMessageVisibility = View.VISIBLE)
                    }
                }

                if (response.code() == 204){
                    changeElementsVisibility(emptyMessageVisibility = View.VISIBLE)
                    return;
                }

                if (response.code() == 500) {
                    changeElementsVisibility(errorMessageVisibility = View.VISIBLE)
                    return;
                }
            }

            override fun onFailure(
                call: Call<List<ProjectModelParcelize>>,
                t: Throwable
            ) {
                t.printStackTrace()
                changeElementsVisibility(errorMessageVisibility = View.VISIBLE)
            }

        })
    }

    private fun setUpList() {
        projectModelParcelizes = arrayListOf()
        adapter = FeedProjectsListAdapter(
            projectModelParcelizes
        )
        binding.listProject.layoutManager = LinearLayoutManager(this)
        binding.listProject.adapter = adapter
    }
}