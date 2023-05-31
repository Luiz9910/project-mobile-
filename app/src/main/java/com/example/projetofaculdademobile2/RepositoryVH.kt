package com.example.projetofaculdademobile2

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofaculdademobile2.databinding.GithubRepoListItemBinding

class RepositoryVH(private val binding: GithubRepoListItemBinding): RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("StringFormatInvalid")
    fun bind(repositorio: Repositorio){
        binding.repositoryTitle.text = binding.root.context.getString(R.string.title, repositorio.name)
        repositorio.description?.let {
            binding.repositoryDescription.text = binding.root.context.getString(R.string.description, repositorio.description)
        }
    }
}