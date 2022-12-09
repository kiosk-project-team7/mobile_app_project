package com.example.kioskui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kioskui.databinding.FragmentDailyManagerBinding
import com.example.kioskui.databinding.FragmentDrinkBinding
import com.example.kioskui.databinding.FragmentManagerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class dailyManagerFragment : Fragment() {

    private lateinit var binding: FragmentDailyManagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDailyManagerBinding.inflate(inflater, container, false)
        return binding.root
    }

//    이미지 클릭 불가능하게 수정, 반투명하게 보이게 수정
//    binding.menu1Img.setClickable(false)
//    binding.menu1Img.setAlpha(0.3f)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView1 = binding.dailySelling
        val textView2 = binding.salesNumber
        val textView3 = binding.totalSelling

        var dailyselling : Int = 0
        for (i in 0..3)
            for (j in 0..11)
                dailyselling += MainActivity.menuInit.selectedAmt[i][j] * MainActivity.menuInit.price[i][j]

        Log.d("text3","$dailyselling" )
        textView1.setText("$dailyselling")

        var count: Int = 0
        for (i in 0..3)
            for (j in 0..11)
                count += MainActivity.menuInit.selectedAmt[i][j]

        textView2.setText("$count 개")

        var totalselling : Int = 0
        for (i in 0..3)
            for (j in 0..11)
                totalselling += MainActivity.menuInit.selectedAmt[i][j] * MainActivity.menuInit.price[i][j]

        textView3.setText("$totalselling")

    }
}