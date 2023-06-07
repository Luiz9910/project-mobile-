package com.example.projetofaculdademobile2.ListProjectProfile

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.ProjectAndComments
import com.example.projetofaculdademobile2.databinding.ListItemPostUserProjectProfileBinding


class ProjectProfilePostRecyclerViewAdapter(
    private val projectModelParcelizes: ArrayList<ProjectModelParcelize>
) : RecyclerView.Adapter<ProjectProfileDetailsViewHolder>() {

    /**
     * Cria a view que você deseja mostrar na lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectProfileDetailsViewHolder {
        val listItemDetailsBinding = ListItemPostUserProjectProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectProfileDetailsViewHolder(listItemPostUserProjectProfileBinding = listItemDetailsBinding)
    }

    override fun getItemViewType(position: Int): Int =
        if (position % 3 == 0) 1 else 0

    /**
     * Retorna o count da lista
     */
    override fun getItemCount(): Int = projectModelParcelizes.size

    /**
     * carrega os elementos da lista
     */
    override fun onBindViewHolder(holder: ProjectProfileDetailsViewHolder, position: Int) {
        val project = projectModelParcelizes[position]
        holder.bind(project)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProjectAndComments::class.java)
            intent.putExtra("id", project.id)
            intent.putExtra("title", project.title)
            intent.putExtra("description", project.body)
            context.startActivity(intent)
        }

        holder.listItemPostUserProjectProfileBinding.DeleteProfileList.tag = project.id
    }
}