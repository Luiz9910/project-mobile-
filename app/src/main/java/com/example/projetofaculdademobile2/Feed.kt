package com.example.projetofaculdademobile2

import android.content.Intent
import android.os.Bundle
import android.view.View
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
        // create retrofit object
        val instance = Retrofit.Builder()
            .baseUrl("http://192.168.3.237:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // create service using Interface that has the request methods
        val service = instance.create(ProjectService::class.java)
        // build the call
        val reponse: Call<List<ProjectModelParcelize>> = service.listProject("projects")
        // make the call
        reponse.enqueue(object : Callback<List<ProjectModelParcelize>> {

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