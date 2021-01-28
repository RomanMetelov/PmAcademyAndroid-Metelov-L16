package com.example.pmacademyandroid_metelov_l16

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerAdapter(activity: AppCompatActivity, private val countryList: List<Country>) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = countryList.size

    override fun createFragment(position: Int): Fragment {
        val country = countryList[position]
        return MyFragment.newInstance(country.name, country.population, country.area)
    }
}