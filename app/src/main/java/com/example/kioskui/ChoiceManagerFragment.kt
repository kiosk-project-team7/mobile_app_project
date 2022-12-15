package com.example.kioskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kioskui.databinding.FragmentChoiceManagerBinding
import com.example.kioskui.databinding.FragmentInoutBinding

class ChoiceManagerFragment : Fragment() {

    private lateinit var binding: FragmentChoiceManagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChoiceManagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dailyBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Daily_Manager)
        }

        binding.stockBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Manager)
        }

    }
}