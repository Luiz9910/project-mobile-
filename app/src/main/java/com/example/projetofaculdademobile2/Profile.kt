package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetofaculdademobile2.ListProjectFeed.ProjectPost
import com.example.projetofaculdademobile2.ListProjectFeed.ProjectPostRecyclerViewAdapter
import com.example.projetofaculdademobile2.ListProjectProfile.ProjectProfilePost
import com.example.projetofaculdademobile2.ListProjectProfile.ProjectProfilePostRecyclerViewAdapter
import com.example.projetofaculdademobile2.databinding.ActivityPostProjectBinding
import com.example.projetofaculdademobile2.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var projectProfilePosts: ArrayList<ProjectProfilePost>
    private lateinit var adapter: ProjectProfilePostRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
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

        fun createInitialDataSet(): ArrayList<ProjectProfilePost> = arrayListOf(
             ProjectProfilePost("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
             ProjectProfilePost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
             ProjectProfilePost("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
             ProjectProfilePost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
             ProjectProfilePost("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
             ProjectProfilePost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
             ProjectProfilePost("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
             ProjectProfilePost("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif")
        )

        fun setUpList() {
            projectProfilePosts = createInitialDataSet()
            adapter = ProjectProfilePostRecyclerViewAdapter(
                projectProfilePosts
            )
            val gridLayoutManager = GridLayoutManager(
                this,
                1
            )
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int = 1
            }
            binding.lisItemProfileUserView.layoutManager = gridLayoutManager
            binding.lisItemProfileUserView.adapter = adapter
        }


        data class PersonOrError(
            val error: Boolean,
            val projectPost: ProjectPost
        )

        setUpList()
    }
}