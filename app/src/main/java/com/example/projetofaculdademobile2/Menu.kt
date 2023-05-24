package com.example.projetofaculdademobile2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetofaculdademobile2.databinding.ActivityMainBinding
import com.example.projetofaculdademobile2.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toProfileMenu.setOnClickListener {
            val toProfile = Intent(this, Profile::class.java)
            startActivity(toProfile)
        }

        binding.toFeedMenu.setOnClickListener {
            var toFeed = Intent(this, Feed::class.java)
            startActivity(toFeed)
        }

        binding.toPostMenu.setOnClickListener {
            var toPost = Intent(this, Publication::class.java)
            startActivity(toPost)
        }

        binding.toSearchMenu.setOnClickListener {
            var toEditPublication = Intent(this, EditProject::class.java)
            startActivity(toEditPublication)
        }
    }
}

