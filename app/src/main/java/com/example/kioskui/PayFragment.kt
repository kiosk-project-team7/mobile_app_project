package com.example.kioskui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kioskui.databinding.FragmentPayBinding
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
import com.example.kioskui.MainActivity.menuInit.Companion.today_total_price
import com.example.kioskui.MainActivity.menuInit.Companion.total_price

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
            today_total_price += total_price
            total_price=0
            Toast.makeText(activity,"결제수단으로 카드를 선택하셨습니다",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.Fragment_Start)
        }

        binding.cashBtn.setOnClickListener {
            Toast.makeText(activity,"결제수단으로 현금을 선택하셨습니다",Toast.LENGTH_SHORT).show()
            today_total_price += total_price
            total_price=0
            findNavController().navigate(R.id.Fragment_Start)
        }
    }
}