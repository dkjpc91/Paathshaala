package com.mithilakshar.maithilipathshala.UI

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieDrawable
import com.bumptech.glide.Glide
import com.mithilakshar.maithilipathshala.R
import com.mithilakshar.maithilipathshala.databinding.ActivityFavourateBinding

class FavourateActivity : AppCompatActivity() {

    lateinit var binding: ActivityFavourateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityFavourateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        hideSystemUI()
















    }


    private fun hideSystemUI() {
        // Enables regular immersive mode (without sticky)
        // For API level 30 and above (Android 11+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            // For API level 30 and below (Android 10 and earlier)
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            // Set the content to appear under the system bars so that the content
                            // doesn't resize when the system bars hide and show.
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Hide the nav bar and status bar
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            // Keep the app content behind the bars even if user interacts with it
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
    }
}