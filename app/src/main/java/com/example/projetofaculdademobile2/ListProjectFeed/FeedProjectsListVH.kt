package com.example.projetofaculdademobile2.ListProjectFeed


import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.databinding.ListItemProjectsFeedBinding

class FeedProjectsListVH(private val binding: ListItemProjectsFeedBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(projectModelParcelize: ProjectModelParcelize){
        binding.repositoryTitle.text = projectModelParcelize.title
        projectModelParcelize.body?.let {
            binding.repositoryDescription.text = projectModelParcelize.body
        }
    }
}