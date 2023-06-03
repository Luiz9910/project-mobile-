package com.example.projetofaculdademobile2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofaculdademobile2.ListProjectFeed.FeedProjectsListAdapter
import com.example.projetofaculdademobile2.ListProjectFeed.ProjectModel
import com.example.projetofaculdademobile2.ListProjectFeed.ProjectService
import com.example.projetofaculdademobile2.databinding.ActivityFeedBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Feed : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private lateinit var projectModels: ArrayList<ProjectModel>
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
            val toLogout = Intent(this, MainActivity::class.java)
            startActivity(toLogout)
        }
    }

    private fun changeElementsVisibility(
        welcomeMessageVisibility: Int = View.GONE,
        errorMessageVisibility: Int = View.GONE,
        emptyMessageVisibility: Int = View.GONE,
        rvVisibilityMessageVisibility: Int = View.GONE,
        progressBarVisibility: Int = View.GONE
    ) {
        binding.welcomeMessage.visibility = welcomeMessageVisibility
        binding.erroMessage.visibility = errorMessageVisibility
        binding.emptyMessage.visibility = emptyMessageVisibility
        binding.rvRepositories.visibility = rvVisibilityMessageVisibility
        binding.progressBar.visibility = progressBarVisibility
    }


    private fun makeRequest() {
        // create retrofit object
        val instance = Retrofit.Builder()
            .baseUrl("http://192.168.0.116:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // create service using Interface that has the request methods
        val service = instance.create(ProjectService::class.java)
        changeElementsVisibility(progressBarVisibility = View.VISIBLE)
        // build the call
        val reponse: Call<List<ProjectModel>> = service.listProject("projects")
        // make the call
        reponse.enqueue(object : Callback<List<ProjectModel>> {

            override fun onResponse(
                call: Call<List<ProjectModel>>,
                response: Response<List<ProjectModel>>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        if (it.isEmpty()) {
                            changeElementsVisibility(emptyMessageVisibility = View.VISIBLE)
                        } else {
                            projectModels.addAll(it)
                            adapter.notifyItemRangeChanged(0, it.size)
                            changeElementsVisibility(rvVisibilityMessageVisibility = View.VISIBLE)
                        }
                    } ?: run {
                        changeElementsVisibility(errorMessageVisibility = View.VISIBLE)
                    }
                }
            }

            override fun onFailure(
                call: Call<List<ProjectModel>>,
                t: Throwable
            ) {
                t.printStackTrace()
                changeElementsVisibility(errorMessageVisibility = View.VISIBLE)
            }

        })
    }

    private fun setUpList() {
        projectModels = arrayListOf()
        adapter = FeedProjectsListAdapter(
            projectModels
        )
        binding.rvRepositories.layoutManager = LinearLayoutManager(this)
        binding.rvRepositories.adapter = adapter
    }
}