package com.ch.readease.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.readease.databinding.ItemAuthorBinding
import com.ch.readease.model.Author

class AuthorAdapter(private val onItemClick: (Author) -> Unit) :
    RecyclerView.Adapter<AuthorAdapter.AuthorItemListViewHolder>() {

    private var items: MutableList<Author> = mutableListOf()

    fun setItems(items: List<Author>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AuthorItemListViewHolder {
        val binding =
            ItemAuthorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return AuthorItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: AuthorItemListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class AuthorItemListViewHolder(
        private val binding: ItemAuthorBinding,
        private val onItemClick: (Author) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Author) {
            binding.ivImg.load(item.imageUrl)
            binding.tvName.text = item.name
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}