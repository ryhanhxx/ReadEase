package com.ch.readease.presentation.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ch.readease.databinding.ItemContainerOnboardingBinding
import com.ch.readease.model.Onboarding

class OnboardingAdapter(
    private val itemClick: (Onboarding) -> Unit
) : RecyclerView.Adapter<OnboardingAdapter.IntroSlideViewHolder>() {

    private var items: MutableList<Onboarding> = mutableListOf()

    fun setItems(items: List<Onboarding>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        val binding = ItemContainerOnboardingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return IntroSlideViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    class IntroSlideViewHolder(
        private val binding: ItemContainerOnboardingBinding,
        val itemClick: (Onboarding) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: Onboarding){
            binding.tvTitle.text = item.title
            binding.tvDesc.text = item.desc
            binding.ivIcon.setImageResource(item.icon)
        }
    }
}