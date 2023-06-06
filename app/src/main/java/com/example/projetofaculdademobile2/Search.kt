package com.example.projetofaculdademobile2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofaculdademobile2.ListProjectFeed.FeedProjectsListAdapter
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.Service.ProjectService
import com.example.projetofaculdademobile2.databinding.ActivitySearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Search : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    private lateinit var projectModelParcelizes: ArrayList<ProjectModelParcelize>
    private lateinit var adapter: FeedProjectsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabBar.toFeedMenu.setOnClickListener {
            var toFeed = Intent(this, Feed::class.java)
            startActivity(toFeed)
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

        setUpList()
        binding.iconSearch.setOnClickListener {
            var userInput = binding.editText.getText().toString();
            makeRequest(userInput)
        }
    }

    private fun changeElementsVisibility(
        errorMessageVisibility: Int = View.GONE,
        emptyMessageVisibility: Int = View.GONE,
        rvVisibilityMessageVisibility: Int = View.GONE
    ) {
        binding.erroMessage.visibility = errorMessageVisibility
        binding.emptyMessage.visibility = emptyMessageVisibility
        binding.listProjectSearch.visibility = rvVisibilityMessageVisibility
    }


    private fun makeRequest(title: String) {
        // create retrofit object
        val instance = Retrofit.Builder()
            .baseUrl("http://192.168.0.116:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // create service using Interface that has the request methods
        val service = instance.create(ProjectService::class.java)
        // build the call
        val reponse: Call<List<ProjectModelParcelize>> = service.listSearchProject(title)
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

                if (response.code() == 204) {
                    changeElementsVisibility(emptyMessageVisibility = View.VISIBLE)
                }

                if (response.code() == 500) {
                    changeElementsVisibility(errorMessageVisibility = View.VISIBLE)
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
        binding.listProjectSearch.layoutManager = LinearLayoutManager(this)
        binding.listProjectSearch.adapter = adapter
    }
}