package com.example.projetofaculdademobile2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projetofaculdademobile2.ListProjectFeed.FeedProjectsListAdapter
import com.example.projetofaculdademobile2.ListProjectProfile.ProjectProfilePostRecyclerViewAdapter
import com.example.projetofaculdademobile2.Model.CommentModel
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.Service.CommentService
import com.example.projetofaculdademobile2.databinding.ActivityProjectAndCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProjectAndComments : AppCompatActivity() {
    private lateinit var binding: ActivityProjectAndCommentsBinding
    private lateinit var projectModelParcelizes: ArrayList<CommentService>
    private lateinit var adapter: FeedProjectsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectAndCommentsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences = getSharedPreferences("MeuApp", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")

        val intent = intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        binding.nameUser.text = name
        binding.title.text = "Título: ${title}"
        binding.description.text = "Descrição: ${description}"
    }
}
