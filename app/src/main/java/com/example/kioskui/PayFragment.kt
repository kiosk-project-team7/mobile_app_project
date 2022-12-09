package com.example.kioskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kioskui.databinding.FragmentPayBinding
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels

class PayFragment : Fragment() {
    private lateinit var binding: FragmentPayBinding
    private val sharedViewModel : OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Start)
        }

        binding.cashBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Start)
        }
    }
}