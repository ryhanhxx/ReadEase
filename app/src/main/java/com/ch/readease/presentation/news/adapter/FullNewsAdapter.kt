package com.ch.readease.presentation.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.readease.databinding.ItemNewsListBinding
import com.ch.readease.model.News

class FullNewsAdapter(private val onItemClick: (News) -> Unit) :
    RecyclerView.Adapter<FullNewsAdapter.FullNewsListViewHolder>() {

    private var items: MutableList<News> = mutableListOf()

    fun setItems(items: List<News>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FullNewsListViewHolder {
        val binding =
            ItemNewsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return FullNewsListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: FullNewsListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class FullNewsListViewHolder(
        private val binding: ItemNewsListBinding,
        private val onItemClick: (News) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            binding.ivImg.load(item.imgUrl)
            binding.tvTitle.text = item.title
            binding.tvAuthor.text = item.author
            binding.tvDesc.text = item.desc
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}