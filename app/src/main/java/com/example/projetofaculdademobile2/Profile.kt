package com.example.projetofaculdademobile2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofaculdademobile2.ListProjectProfile.ProjectProfilePostRecyclerViewAdapter
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.Service.ProjectService
import com.example.projetofaculdademobile2.databinding.ActivityProfileBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var projectModelParcelizes: ArrayList<ProjectModelParcelize>
    private lateinit var adapter: ProjectProfilePostRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
        val id = sharedPreferences.getString("id", "")
        val name = sharedPreferences.getString("name", "")
        val description = sharedPreferences.getString("description", "")

        binding.nameUserId.text = name
        binding.descriptionUserId.text = description

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

        binding.tabBar.toLogout.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear() // Limpa todos os valores armazenados no SharedPreferences
            editor.apply()
            val toLogout = Intent(this, MainActivity::class.java)
            startActivity(toLogout)
        }

        binding.buttonProfile.setOnClickListener {
            var toEditProfile = Intent(this, EditProfile::class.java)
            startActivity(toEditProfile)
        }

        setUpList()
        binding.run {
            makeRequest()
        }
    }

    private fun changeElementsVisibility(
        errorMessageVisibility: Int = View.GONE,
        emptyMessageVisibility: Int = View.GONE,
        rvVisibilityMessageVisibility: Int = View.GONE
    ) {
        binding.erroMessage.visibility = errorMessageVisibility
        binding.emptyMessage.visibility = emptyMessageVisibility
        binding.listProjectProfile.visibility = rvVisibilityMessageVisibility
    }


    private fun makeRequest() {
        // create retrofit object
        val instance = Retrofit.Builder()
            .baseUrl("http://192.168.0.116:8080/")
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
                val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
                val id = sharedPreferences.getString("id", "")
                if (response.isSuccessful) {
                    val projects = response.body()

                    if (projects != null) {
                        val filteredProjects = projects.filter { it.userid ==  id}

                        projectModelParcelizes.addAll(filteredProjects)
                        adapter.notifyDataSetChanged()

                        if (filteredProjects.isNotEmpty()) {
                            changeElementsVisibility(rvVisibilityMessageVisibility = View.VISIBLE)
                        } else {
                            changeElementsVisibility(emptyMessageVisibility = View.VISIBLE)
                        }
                    } else {
                        changeElementsVisibility(emptyMessageVisibility = View.VISIBLE)
                    }
                } else {
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
        adapter = ProjectProfilePostRecyclerViewAdapter(
            projectModelParcelizes
        )
        binding.listProjectProfile.layoutManager = LinearLayoutManager(this)
        binding.listProjectProfile.adapter = adapter
    }
}