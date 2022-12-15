package com.example.kioskui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kioskui.MainActivity.menuInit.Companion.total_price
import com.example.kioskui.databinding.FragmentDailyManagerBinding
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.kioskui.MainActivity.menuInit.Companion.calculate
import com.example.kioskui.MainActivity.menuInit.Companion.selectedAmt
import com.example.kioskui.MainActivity.menuInit.Companion.today_total_price
import com.example.kioskui.MainActivity.menuInit.Companion.total_num
import java.util.Collections.max

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class dailyManagerFragment : Fragment() {

    private lateinit var binding: FragmentDailyManagerBinding
    private val sharedViewModel : OrderViewModel by activityViewModels()
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
        binding.apply{
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel

        }
        calculate()
        var daily = binding.dailySelling
        val sailnum = binding.salesNumber
        val totalsail = binding.totalSelling

        var dailyselling : Int = today_total_price
        Log.d("text3","$dailyselling" )
        daily.setText("$dailyselling"+"원")
        sailnum.setText("$total_num"+"개")
        totalsail.setText("$dailyselling"+"원")
        var count: Int = 0


        /*
        for (i in 0..3)
            for (j in 0..11)
                count += MainActivity.menuInit.selectedAmt[i][j]

        textView2.setText("$count 개")
*/
        /*
        var totalselling : Int = 0
        for (i in 0..3)
            for (j in 0..11)
                totalselling += MainActivity.menuInit.selectedAmt[i][j] * MainActivity.menuInit.price[i][j]

         */

        //textView3.setText("$totalselling")

    }
}