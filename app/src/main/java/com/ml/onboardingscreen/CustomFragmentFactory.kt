package com.ml.onboardingscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory


class CustomFragmentFactory(private val list: List<String>) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == ViewPagerFragment::class.java.name) {
            return ViewPagerFragment(list)
        }
        return super.instantiate(classLoader, className)
    }
}