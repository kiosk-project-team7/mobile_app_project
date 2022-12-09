package com.example.kioskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kioskui.databinding.FragmentManagerBinding

class ManagerFragment : Fragment() {

    private lateinit var binding: FragmentManagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentManagerBinding.inflate(inflater, container, false)
        return binding.root
    }
    
//    이미지 클릭 불가능하게 수정, 반투명하게 보이게 수정
//    binding.menu1Img.setClickable(false)
//    binding.menu1Img.setAlpha(0.3f)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}