package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetofaculdademobile2.databinding.ActivityEditProjectBinding

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
            val toLogout = Intent(this, MainActivity::class.java)
            startActivity(toLogout)
        }
    }
}