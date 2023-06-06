package com.example.projetofaculdademobile2.ListProjectProfile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.Model.ProjectModelParcelize
import com.example.projetofaculdademobile2.databinding.ListItemPostUserProjectProfileBinding

/**
 * TODO (ATIVIDADE)
 * Modifique o adapter para poder carregar dois tipos de views diferentes!
 * Você vai precisar criar uma view para um item diferente
 * Criar um viewholder diferente
 * Modificar a classe Person para conter mais atributos que serão apresentados na outra view
 * Modificar os métodos onCreateViewHolder e onBindViewHolder para inflar a view correta e
 *      carregar corretamente os elementos
 *
 * Dica: Será necessário fazer o override da função getItemViewType para identificar
 * a view que contem os detalhes
 */
class ProjectProfilePostRecyclerViewAdapter(
    private val persons: ArrayList<ProjectModelParcelize>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Cria a view que você deseja mostrar na lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val listItemDetailsBinding = ListItemPostUserProjectProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectProfileDetailsViewHolder(listItemPostUserProjectProfileBinding = listItemDetailsBinding)
    }

    override fun getItemViewType(position: Int): Int =
        if (position % 3 == 0) 1 else 0

    /**
     * Retorna o count da lista
     */
    override fun getItemCount(): Int = persons.size

    /**
     * carrega os elementos da lista
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ProjectProfileDetailsViewHolder)?.bind(persons[position])
    }
}