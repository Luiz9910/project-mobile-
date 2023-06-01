package com.example.projetofaculdademobile2.ListProjectFeed


import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.databinding.ListItemProjectsFeedBinding

class FeedProjectsListVH(private val binding: ListItemProjectsFeedBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(projectModel: ProjectModel){
        binding.repositoryTitle.text = projectModel.title
        projectModel.body?.let {
            binding.repositoryDescription.text = projectModel.body
        }
    }
}