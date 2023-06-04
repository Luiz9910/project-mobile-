package com.example.projetofaculdademobile2.ListProjectFeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.databinding.ListItemProjectsFeedBinding

class FeedProjectsListAdapter(
    private val projectModelParcelizes: ArrayList<ProjectModelParcelize>
) : RecyclerView.Adapter<FeedProjectsListVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedProjectsListVH {
        val binding =
            ListItemProjectsFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedProjectsListVH(binding)
    }

    override fun getItemCount(): Int = projectModelParcelizes.size

    override fun onBindViewHolder(holder: FeedProjectsListVH, position: Int) {
        holder.bind(projectModelParcelizes[position])
    }
}