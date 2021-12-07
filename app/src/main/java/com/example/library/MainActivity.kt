package com.example.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.library.databinding.ActivityMainBinding
import com.example.library.fragments.FragmentMaterials
import com.example.library.fragments.FragmentReservation
import com.example.library.fragments.FragmentUserProfile

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewPager: ViewPager

    class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        val fragmentMaterials = FragmentMaterials()
        val fragmentReservation = FragmentReservation()
        val fragmentUserProfile = FragmentUserProfile()

        override fun getCount(): Int  = 3

        override fun getItem(i: Int): Fragment {
            if(i==0){
                return fragmentMaterials
            }else if(i==1){
                return fragmentReservation
            }
            return fragmentUserProfile
        }

        override fun getPageTitle(i: Int): CharSequence {
            if(i==0){
                return "LIBRARY"
            }else if(i==1){
                return "RESERVE"
            }
            return "PROFILE"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.pager
        binding.tabLayout.setupWithViewPager(viewPager)

        binding.pager.adapter = PagerAdapter(supportFragmentManager)

    }
}