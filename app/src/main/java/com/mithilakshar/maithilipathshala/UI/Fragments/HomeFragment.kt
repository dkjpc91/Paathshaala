package com.mithilakshar.maithilipathshala.UI.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieDrawable
import com.bumptech.glide.Glide
import com.mithilakshar.maithilipathshala.R
import com.mithilakshar.maithilipathshala.UI.FavourateActivity
import com.mithilakshar.maithilipathshala.databinding.ActivityFavourateBinding
import com.mithilakshar.maithilipathshala.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)



        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = "https://i.pinimg.com/564x/fa/46/cc/fa46cc82f80aef54ceb4bc7dd95c8775.jpg"
        val imageUrl2 = ""

        binding.maths.setOnClickListener {

            val intent = Intent(requireContext(),FavourateActivity::class.java)
            startActivity(intent)
        }




        binding.appbanner.visibility = View.GONE

        binding.appbannerlottie.setAnimationFromUrl("https://lottie.host/ea1b5370-e4c7-4226-9ef7-8d4e6958c244/duEUsEy7LL.json")
        binding.appbannerlottie.repeatCount =
            LottieDrawable.INFINITE // Optional: to make the animation loop indefinitely
        binding.appbannerlottie.playAnimation()

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

        if (imageUrl2.isNotEmpty()) {

            Handler(Looper.getMainLooper()).postDelayed({

                binding.homefullscreenbanner.visibility = View.GONE
                binding.appbanner.visibility = View.VISIBLE
                binding.appbannerlottie.visibility = View.VISIBLE
                binding.homeviewsubjects.visibility = View.VISIBLE
            }, 5000)
            Handler(Looper.getMainLooper()).postDelayed({

                binding.appbanneriv.visibility = View.VISIBLE
                binding.appbannerlottie.visibility = View.GONE

            }, 8000)

        } else {

            Handler(Looper.getMainLooper()).postDelayed({

                binding.homefullscreenbanner.visibility = View.GONE
                binding.appbanner.visibility = View.VISIBLE
                binding.appbannerlottie.visibility = View.VISIBLE
                binding.homeviewsubjects.visibility = View.VISIBLE
            }, 50)

            Handler(Looper.getMainLooper()).postDelayed({

                binding.appbanneriv.visibility = View.VISIBLE
                binding.appbannerlottie.visibility = View.GONE

            }, 3000)


        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}