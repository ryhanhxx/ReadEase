package com.ch.readease.presentation.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.ch.readease.R
import com.ch.readease.databinding.ActivityOnboardingBinding
import com.ch.readease.dummy.DummyOnboardingDataSourceImpl
import com.ch.readease.presentation.main.MainActivity
import com.ch.readease.presentation.onboarding.adapter.OnboardingAdapter

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    private val OnboardingAdapter: OnboardingAdapter by lazy {
        OnboardingAdapter { Onboarding ->

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
        setupIndicator()
        setCurrentIndicator(0)
        setupButton()
    }

    private fun setupViewPager() {
        binding.vpSlide.adapter = OnboardingAdapter
        val dummyData = DummyOnboardingDataSourceImpl().getOnboardingData(this)
        OnboardingAdapter.setItems(dummyData)
    }

    private fun setupIndicator() {
        val indicators = arrayOfNulls<ImageView>(OnboardingAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(6, 0, 0, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.llIndicatorsContainer.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = binding.llIndicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.llIndicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

    private fun setupButton() {
        binding.vpSlide.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        binding.bNext.setOnClickListener {
            if (binding.vpSlide.currentItem + 1 < OnboardingAdapter.itemCount) {
                binding.vpSlide.currentItem += 1
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        binding.tvSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}