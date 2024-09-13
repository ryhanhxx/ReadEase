package com.ch.readease.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ch.readease.databinding.ItemNewsGridBinding
import com.ch.readease.model.News

class NewsAdapter(private val onItemClick: (News) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsItemListViewHolder>() {

    private var items: MutableList<News> = mutableListOf()

    fun setItems(items: List<News>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsItemListViewHolder {
        val binding =
            ItemNewsGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return NewsItemListViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: NewsItemListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class NewsItemListViewHolder(
        private val binding: ItemNewsGridBinding,
        private val onItemClick: (News) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {
            binding.ivImg.load(item.imgUrl)
            binding.tvTitle.text = item.title
            binding.tvAuthor.text = item.author
            binding.tvContent.text = item.content
            binding.root.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}