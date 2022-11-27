package com.example.kiosk_project

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kiosk_project.databinding.DialogBinding

class customDiaglog : DialogFragment() {
    private var _binding : DialogBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DialogBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.basic.setOnClickListener { //눌럿을때 추천값하기.
            dismiss()
        }
        binding.detail.setOnClickListener { //디테일 추가
            dismiss()
        }
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}