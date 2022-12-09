package com.example.kioskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kioskui.databinding.FragmentDrinkBinding

class DrinkFragment : Fragment() {

    private lateinit var binding: FragmentDrinkBinding
//    private var checkedItem: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrinkBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 메뉴 사진 누르면 담기
        binding.menu1Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 1,
                resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu2Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 2,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu3Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 3,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu4Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 4,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu5Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 5,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu6Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 6,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu7Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 7,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu8Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 8,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu9Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 9,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu10Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 10,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu11Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 11,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
        binding.menu12Img.setOnClickListener {
            MainActivity.menuInit.whenSelected(3, 12,
            resources.getDrawable(R.drawable.drink_01_americano_ice))
        }
    }
}