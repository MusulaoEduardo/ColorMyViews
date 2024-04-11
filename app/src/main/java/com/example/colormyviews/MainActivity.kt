package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private var box_one_text = binding.boxOneText
//    private var box_two_text = binding.boxTwoText
//    private var box_three_text = binding.boxThreeText
//    private var box_four_text = binding.boxFourText
//    private var box_five_text = binding.boxFiveText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val clickableView: List<View> =
            listOf(
                binding.boxOneText,
                binding.boxTwoText,
                binding.boxThreeText,
                binding.boxFourText,
                binding.boxFiveText,
                binding.constraintLayout,
                binding.redButton,
                binding.yellowButton,
                binding.greenButton
            )

        for (item in clickableView) {
            item.setOnClickListener { makeColored(it) }
        }

    }

    @SuppressLint("ResourceAsColor")
    private fun makeColored(view: View) {
        when (view.id) {
            //Boxes using color class color for backgroud
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            //Boxes using android color resources for backgroud
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            //Boxes using custom colors for backgroud
            R.id.red_button -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> binding.boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)

        }
    }


}