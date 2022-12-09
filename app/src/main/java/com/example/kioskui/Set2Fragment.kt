package com.example.kioskui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kioskui.databinding.FragmentSet2Binding

class Set2Fragment : Fragment() {
    private lateinit var binding: FragmentSet2Binding

    private var menuFragment: MenuFragment? = null

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
        binding = FragmentSet2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.set2.setOnClickListener {
            menuFragment = MenuFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, menuFragment!!).commit()
        }

        /*binding.startBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Inout)
        }
        binding.mainLogo.setOnClickListener {   //메인 로고를 누를 시
            findNavController().navigate(R.id.Fragment_Manager)
        }*/
    }
}