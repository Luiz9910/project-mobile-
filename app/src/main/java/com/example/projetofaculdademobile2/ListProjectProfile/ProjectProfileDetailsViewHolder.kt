package com.example.projetofaculdademobile2.ListProjectProfile

import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.databinding.ListItemPostUserProjectProfileBinding

class ProjectProfileDetailsViewHolder(private val listItemPostUserProjectProfileBinding: ListItemPostUserProjectProfileBinding) :
    RecyclerView.ViewHolder(listItemPostUserProjectProfileBinding.root) {

    fun bind(projectModelParcelize: ProjectProfilePost) {

        projectModelParcelize?.let { it ->
            listItemPostUserProjectProfileBinding.title.text = it.title
            listItemPostUserProjectProfileBinding.description.text = it.description
            listItemPostUserProjectProfileBinding.idProject.text = it.userid
        }
    }
}