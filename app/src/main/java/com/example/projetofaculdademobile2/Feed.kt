package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetofaculdademobile2.ListProjectFeed.ProjectPost
import com.example.projetofaculdademobile2.ListProjectFeed.ProjectPostRecyclerViewAdapter
import com.example.projetofaculdademobile2.databinding.ActivityFeedBinding

class Feed : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private lateinit var projectPosts: ArrayList<ProjectPost>
    private lateinit var adapter: ProjectPostRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpList()

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
    }

    private fun setUpList() {
        projectPosts = createInitialDataSet()
        adapter = ProjectPostRecyclerViewAdapter(
            projectPosts
        )
        val gridLayoutManager = GridLayoutManager(
            this,
            1
        )
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = 1
        }
        binding.listViewPersons.layoutManager = gridLayoutManager
        binding.listViewPersons.adapter = adapter
    }

    private fun createInitialDataSet(): ArrayList<ProjectPost> = arrayListOf(
        ProjectPost("Athletes", "luizluizluizluizluizluizluizluizluizluizluizluizluizluizluizluizluiz"),
        ProjectPost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        ProjectPost("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        ProjectPost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        ProjectPost("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        ProjectPost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        ProjectPost("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        ProjectPost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif")
    )

    data class PersonOrError(
        val error: Boolean,
        val projectPost: ProjectPost
    )
}