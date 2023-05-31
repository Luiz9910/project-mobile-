package com.example.projetofaculdademobile2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetofaculdademobile2.databinding.ActivityPostProjectBinding

class Post : AppCompatActivity() {

    private lateinit var binding: ActivityPostProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}