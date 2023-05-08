package com.example.listview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.databinding.ListItemBinding
import com.example.listview.databinding.ListItemDetailsBinding

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
class PersonRecyclerViewAdapter(
    private val persons: ArrayList<Person>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Cria a view que você deseja mostrar na lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == PERSON_DETAILS_VIEW_HOLDER) {
            val listItemDetailsBinding =
                ListItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            PersonDetailsViewHolder(listItemDetailsBinding)
        } else {
            val listItemBinding =
                ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            PersonViewHolder(listItemBinding)
        }
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
        (holder as? PersonViewHolder)?.bind(persons[position])
        (holder as? PersonDetailsViewHolder)?.bind(persons[position])
    }

    companion object {
        const val PERSON_DETAILS_VIEW_HOLDER = 1
    }

}