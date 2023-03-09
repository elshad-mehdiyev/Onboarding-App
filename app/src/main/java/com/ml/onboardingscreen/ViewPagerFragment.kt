package com.ml.onboardingscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ml.onboardingscreen.Constant.ARG_OBJECT


class ViewPagerFragment(val list: List<String>) : Fragment() {

    private var idViewPager = 0
    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_view_pager, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            idViewPager = getInt(ARG_OBJECT)
        }
        val pageNumber = root.findViewById<TextView>(R.id.pageNumber)

        for (i in list.indices) {
            when(idViewPager) {
                i + 1 -> pageNumber.text = list[i]
            }
        }
    }
}