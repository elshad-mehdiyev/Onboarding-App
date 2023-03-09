package com.ml.onboardingscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {
    private var currentPage = 0
    private var isFinished = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val next = findViewById<TextView>(R.id.next)
        val skip = findViewById<TextView>(R.id.skip)
        val list = listOf("1", "2", "3")
        val adapter = ViewPagerAdapter(this, list)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter
        dotsIndicator.attachTo(viewPager)
        viewPager.isUserInputEnabled = false

        if (isFinished) {
            next.setOnClickListener {
                startActivity(Intent(this, ResultScreen::class.java))
                finish()
            }
        } else {
            next.setOnClickListener {
                currentPage++
                viewPager.setCurrentItem(currentPage)
                if (currentPage == list.size - 1) {
                    next.text = "finish"
                    isFinished = true
                }
            }
        }
        skip.setOnClickListener {
            startActivity(Intent(this, ResultScreen::class.java))
            finish()
        }
    }
}