package com.example.projetofaculdademobile2

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.databinding.ListItemDetailsBinding

class PersonDetailsViewHolder(private val listItemDetailsBinding: ListItemDetailsBinding) :
    RecyclerView.ViewHolder(listItemDetailsBinding.root) {

    fun bind(person: Person?) {
        person?.let { it ->
            listItemDetailsBinding.title.text = it.title
            listItemDetailsBinding.description.text = it.description
        }
    }
}