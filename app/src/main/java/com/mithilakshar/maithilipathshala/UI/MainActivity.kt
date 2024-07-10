package com.mithilakshar.maithilipathshala.UI

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.mithilakshar.maithilipathshala.R
import com.mithilakshar.maithilipathshala.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageUrl = "https://i.pinimg.com/564x/fa/46/cc/fa46cc82f80aef54ceb4bc7dd95c8775.jpg"
        val imageUrl2 = "https://i.pinimg.com/564x/68/e6/14/68e614a4460bc2c36d24f457338392c7.jpg"
        val animations = getAssetLottieFiles()
        binding.appbannerlottie.setAnimation(animations.random())
        binding.appbanner.visibility=View.GONE
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.logo) // Optional placeholder
            .error(R.drawable.logo) // Optional error image
            .into(binding.appbanneriv)

        Glide.with(this)
            .load(imageUrl2)
            .placeholder(R.drawable.logo) // Optional placeholder
            .error(R.drawable.logo) // Optional error image
            .into(binding.homefullscreenbanner)

        Handler(Looper.getMainLooper()).postDelayed({

            binding.homefullscreenbanner.visibility=View.GONE
            binding.appbanner.visibility=View.VISIBLE
            binding.appbannerlottie.visibility=View.VISIBLE
            binding.homeviewsubjects.visibility=View.VISIBLE
        },5000)


        Handler(Looper.getMainLooper()).postDelayed({

            binding.appbanneriv.visibility=View.VISIBLE
            binding.appbannerlottie.visibility=View.GONE

        },8000)



    }

    private fun getRawLottieFiles(): List<String> {
        val fields = R.raw::class.java.fields
        return fields.map { it.name }.filter { it.startsWith("lottie") } // Adjust the filter as needed
    }

    private fun getAssetLottieFiles(): List<String> {
        val assetManager = assets
        // List all files in the assets directory
        val files = assetManager.list("")?.filter { it.endsWith(".json") } ?: emptyList()
        // Exclude specific files (e.g., "freeform_resolutions.json")
        return files.filterNot { it == "freeform_resolutions.json" }
    }
}