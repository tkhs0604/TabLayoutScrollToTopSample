package com.tkhs0604.tablayoutscrolltotopsample.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.tkhs0604.tablayoutscrolltotopsample.R
import com.tkhs0604.tablayoutscrolltotopsample.databinding.ActivityMainBinding
import com.tkhs0604.tablayoutscrolltotopsample.widget.ListScrollable
import com.tkhs0604.tablayoutscrolltotopsample.widget.SimpleOnTabSelectedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(TAB_TITLES.count(), this)
        binding.viewPager.adapter = sectionsPagerAdapter

        binding.tabs.addOnTabSelectedListener(object : SimpleOnTabSelectedListener() {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                super.onTabReselected(tab)

                val tabPosition = tab?.position
                if (tabPosition != null) {
                    val fragment = sectionsPagerAdapter.fragments.getOrNull(tabPosition)
                    (fragment as? ListScrollable)?.scrollToTop()
                }
            }
        })

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.setText(TAB_TITLES[position])
        }.attach()
    }

    companion object {
        private val TAB_TITLES = arrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

}
