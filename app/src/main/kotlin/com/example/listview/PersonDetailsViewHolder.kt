package com.example.listview

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.listview.databinding.ListItemDetailsBinding

class PersonDetailsViewHolder(private val listItemDetailsBinding: ListItemDetailsBinding) :
    RecyclerView.ViewHolder(listItemDetailsBinding.root) {

    fun bind(person: Person?) {
        person?.let { it ->
            listItemDetailsBinding.name.text = it.name
            listItemDetailsBinding.phone.text = it.phone

            var hasDetails = false

            it.hobby?.let {
                listItemDetailsBinding.hobby.text = it
                hasDetails = true
            } ?: run {
                listItemDetailsBinding.hobby.visibility = View.GONE
            }

            it.height?.let {
                listItemDetailsBinding.height.text = it.toString()
                hasDetails = true
            } ?: run {
                listItemDetailsBinding.height.visibility = View.GONE
            }

            it.weight?.let {
                listItemDetailsBinding.weight.text = it.toString()
                hasDetails = true
            } ?: run {
                listItemDetailsBinding.weight.visibility = View.GONE
            }

            if (hasDetails.not()) {
                listItemDetailsBinding.details.visibility = View.GONE
            }
        }
    }
}