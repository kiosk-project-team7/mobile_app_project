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
        binding.menu1Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 1) }
        binding.menu2Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 2) }
        binding.menu3Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 3) }
        binding.menu4Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 4) }
        binding.menu5Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 5) }
        binding.menu6Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 6) }
        binding.menu7Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 7) }
        binding.menu8Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 8) }
        binding.menu9Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 9) }
        binding.menu10Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 10) }
        binding.menu11Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 11) }
        binding.menu12Img.setOnClickListener { MainActivity.menuInit.whenSelected(3, 12) }
    }
}