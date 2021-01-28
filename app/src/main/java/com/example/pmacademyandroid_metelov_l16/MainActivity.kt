package com.example.pmacademyandroid_metelov_l16

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pmacademyandroid_metelov_l16.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val countries = listOf(
        Country("Great Britain", 66.65, 242495.00),
        Country("Netherlands", 17.28, 41543.00),
        Country("France", 67.06,643801.00)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    override fun onStart() {
        super.onStart()

        binding.viewPager.adapter = MyViewPagerAdapter(this, countries)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            tab.text = countries[position].name
        }.attach()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

data class Country(
    val name: String,
    val population: Double,
    val area: Double
)