package com.ch.readease.presentation.news

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.ch.readease.databinding.ActivityNewsBinding
import com.ch.readease.model.News
import com.ch.readease.utils.GenericViewModelFactory

class NewsActivity : AppCompatActivity() {

    private val binding: ActivityNewsBinding by lazy {
        ActivityNewsBinding.inflate(layoutInflater)
    }

    private val viewModel: NewsViewModel by viewModels {
        GenericViewModelFactory.create(NewsViewModel(intent?.extras))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navigateBack()
        showNewsData(viewModel.news)
    }

    private fun navigateBack(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
    private fun showNewsData(news: News?) {
        news?.apply {
            binding.ivImg.load(this.imgUrl) {
                crossfade(true)
            }
            binding.tvTitle.text = this.title
            binding.tvContent.text = this.content
        }
    }

    companion object {
        const val NEWS_KEY = "NEWS_KEY"
        fun startActivity(context: Context, news: News?) {
            val intent = Intent(context, NewsActivity::class.java)
            intent.putExtra(NEWS_KEY, news)
            context.startActivity(intent)
        }
    }
}