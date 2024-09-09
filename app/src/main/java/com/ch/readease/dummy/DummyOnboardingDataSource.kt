package com.ch.readease.dummy

import android.content.Context
import com.ch.readease.R
import com.ch.readease.model.Onboarding

interface DummyOnboardingDataSource {
    fun getOnboardingData(context: Context): List<Onboarding>
}

class DummyOnboardingDataSourceImpl() : DummyOnboardingDataSource {
    override fun getOnboardingData(context: Context): List<Onboarding> {

        return mutableListOf(
            Onboarding(
                title = "Temukan",
                desc = "Temukan buku-buku menarik dari berbagai genre.",
                icon = R.drawable.img_onboard_1
            ),
            Onboarding(
                title = "Baca",
                desc = "Nikmati pengalaman membaca yang nyaman dan fleksibel.",
                icon = R.drawable.img_onboard_2
            ),
            Onboarding(
                title = "Nikmati",
                desc = "Dapatkan kesenangan membaca di mana saja dan kapan saja.",
                icon = R.drawable.img_onboard_3
            )
        )
    }
}