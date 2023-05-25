package com.example.projetofaculdademobile2.ListProjectFeed

import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.databinding.ListItemDetailsBinding

class ProjectDetailsViewHolder(private val listItemDetailsBinding: ListItemDetailsBinding) :
    RecyclerView.ViewHolder(listItemDetailsBinding.root) {

    fun bind(projectPost: ProjectPost?) {
        projectPost?.let { it ->
            listItemDetailsBinding.title.text = it.title
            listItemDetailsBinding.description.text = it.description
        }
    }
}