package com.example.projetofaculdademobile2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetofaculdademobile2.databinding.ActivityProjectAndCommentsBinding

class ProjectAndComments : AppCompatActivity() {
    private lateinit var binding: ActivityProjectAndCommentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectAndCommentsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val id = intent.getStringExtra("id")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        binding.title.text = title
        binding.description.text = description
    }
}
