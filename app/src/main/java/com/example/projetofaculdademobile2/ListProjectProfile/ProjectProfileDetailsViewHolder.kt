package com.example.projetofaculdademobile2.ListProjectProfile

import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.databinding.ListItemPostProjectBinding

class ProjectProfileDetailsViewHolder(private val listItemDetailsBinding: ListItemPostProjectBinding) :
    RecyclerView.ViewHolder(listItemDetailsBinding.root) {

    fun bind(projectPost: ProjectProfilePost?) {
        projectPost?.let { it ->
            listItemDetailsBinding.title.text = it.title
            listItemDetailsBinding.description.text = it.description
        }
    }
}