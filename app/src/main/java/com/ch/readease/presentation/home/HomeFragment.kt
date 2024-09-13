package com.ch.readease.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ch.readease.databinding.FragmentHomeBinding
import com.ch.readease.dummy.DummyAuthorDataSource
import com.ch.readease.dummy.DummyAuthorDataSourceImpl
import com.ch.readease.dummy.DummyNewsDataSourceImpl
import com.ch.readease.model.Author
import com.ch.readease.model.News
import com.ch.readease.presentation.home.adapter.AuthorAdapter
import com.ch.readease.presentation.home.adapter.NewsAdapter
import com.ch.readease.presentation.news.NewsActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val adapterAuthor: AuthorAdapter by lazy {
        AuthorAdapter { author: Author ->

        }
    }

    private val adapterNews: NewsAdapter by lazy {
        NewsAdapter { news: News ->
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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAuthor()
        setupNews()
    }

    private fun setupNews() {
        binding.rvNews1.adapter = adapterNews
        adapterNews.setItems(DummyNewsDataSourceImpl().getNewsData())
    }

    private fun setupAuthor() {
        binding.rvAuthor.adapter = adapterAuthor
        adapterAuthor.setItems(DummyAuthorDataSourceImpl().getAuthorData())
    }
}