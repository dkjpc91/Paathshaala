package com.mithilakshar.maithilipathshala.UI

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mithilakshar.maithilipathshala.R
import android.view.animation.AnimationUtils
import com.mithilakshar.maithilipathshala.databinding.ActivitySplashBinding
import android.os.Handler
import android.os.Looper
import android.content.Intent

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein)

        binding.apply {
            splash.startAnimation(fadeInAnimation)
            splashTxt.startAnimation(fadeInAnimation)

        }

        Handler(Looper.getMainLooper()).postDelayed({
            // Intent to move to SecondActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3 seconds delay

    }
}