package com.example.feature.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.feature.home.HomeUiState

class SampleViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val list = HomeUiState.Success().list
    private val fragments: List<Fragment> = (0..list.lastIndex).map { index ->
        SampleViewPagerFragment.newInstance(
            title = list[index]
        )
    }

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(pageNum: Int): Fragment {
        return fragments[pageNum]
    }
}