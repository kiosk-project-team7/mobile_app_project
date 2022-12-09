package com.example.kioskui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kioskui.databinding.FragmentSet1Binding

class Set1Fragment : Fragment() {

    private lateinit var binding: FragmentSet1Binding

    private var set2Fragment: Set2Fragment? = null

    private lateinit var mainActivity : MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSet1Binding.inflate(inflater, container, false)
        binding.menuImg.setImageDrawable(MainActivity.order.selectedImg[MainActivity.order.orderNum - 1])
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cusBtn.setOnClickListener {
            set2Fragment = Set2Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set2Fragment!!).commit()

        }
        binding.recBtn.setOnClickListener {   //메인 로고를 누를 시

        }
    }
}
