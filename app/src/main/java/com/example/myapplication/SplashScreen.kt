package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {

    private lateinit var imageView:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        imageView=findViewById(R.id.imageView)

        val anim = AnimationUtils.loadAnimation(this,R.anim.animm)
        imageView.startAnimation(anim)


        Handler().postDelayed(
            {startActivity(Intent(applicationContext,MainActivity::class.java))  }, 50000)}


}


