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
import com.ch.readease.model.Author
import com.ch.readease.presentation.home.adapter.AuthorAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val authorAdapter: AuthorAdapter by lazy {
        AuthorAdapter { author: Author ->

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        setupAuthor()
        setupNews1()
        setupNews2()
    }

    private fun setupNews2() {

    }

    private fun setupNews1() {

    }

    private fun setupAuthor() {
        binding.rvNews.adapter = authorAdapter
        authorAdapter.setItems(DummyAuthorDataSourceImpl().getAuthorData())
    }
}