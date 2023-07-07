package com.coding.meet.viewflipperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {

    private val imageList = arrayListOf(
        R.drawable.logo1,
        R.drawable.logo2,
        R.drawable.logo3
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        val inAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)

        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation


        for (image in imageList){
            val imageView = ImageView(this)
            imageView.setImageResource(image)
            imageView.layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT,
            )
            viewFlipper.addView(imageView)
        }

        val previousBtn = findViewById<Button>(R.id.previousBtn)
        previousBtn.setOnClickListener {
            viewFlipper.showPrevious()
        }
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            viewFlipper.showNext()
        }
    }
}