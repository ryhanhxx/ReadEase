package com.ch.readease.presentation.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ch.readease.databinding.FragmentNewsBinding
import com.ch.readease.dummy.DummyNewsDataSourceImpl
import com.ch.readease.model.News
import com.ch.readease.presentation.news.adapter.FullNewsAdapter

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    private val adapterNews: FullNewsAdapter by lazy {
        FullNewsAdapter { news: News ->
            navigateToDetailFragment(news)
        }
    }

    private fun navigateToDetailFragment(news: News) {
        NewsActivity.startActivity(requireContext(), news)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNews()
    }

    private fun setupNews() {
        binding.rvNews1.adapter = adapterNews
        adapterNews.setItems(DummyNewsDataSourceImpl().getNewsData())
    }


}