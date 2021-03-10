package com.tkhs0604.tablayoutscrolltotopsample.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(
    private val tabsCount: Int,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val _fragments = mutableListOf<Fragment>()
    val fragments: List<Fragment> = _fragments

    override fun createFragment(position: Int): Fragment {
        return MainFragment.newInstance().also {
            _fragments.add(it)
        }
    }

    override fun getItemCount(): Int {
        return tabsCount
    }

}
