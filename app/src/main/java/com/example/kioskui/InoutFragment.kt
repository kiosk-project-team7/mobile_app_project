package com.example.kioskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kioskui.databinding.FragmentInoutBinding

class InoutFragment : Fragment() {

    private lateinit var binding: FragmentInoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.outBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Menu)
        }

        binding.inBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Menu)
        }

    }
}