package com.example.kioskui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kioskui.databinding.FragmentManagerBinding

class ManagerFragment : Fragment() {

    private lateinit var binding: FragmentManagerBinding
    private var setmenuFragment: SetmenuFragment? = null
    private var singleFragment: SingleFragment? = null
    private var sideFragment: SideFragment? = null
    private var drinkFragment: DrinkFragment? = null
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
        binding = FragmentManagerBinding.inflate(inflater, container, false)
        return binding.root
    }

//    이미지 클릭 불가능하게 수정, 반투명하게 보이게 수정
//    binding.menu1Img.setClickable(false)
//    binding.menu1Img.setAlpha(0.3f)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReturnMain.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Choice_Manager)
        }
        binding.setButton.setOnClickListener {
            setmenuFragment = SetmenuFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, setmenuFragment!!).commit()
//            binding.btn1.setBackgroundColor()
        }
        binding.singleBtn.setOnClickListener {
            singleFragment = SingleFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, singleFragment!!).commit()
        }
        binding.sideBtn.setOnClickListener {
            sideFragment = SideFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, sideFragment!!).commit()
        }
        binding.drinkBtn.setOnClickListener {
            drinkFragment = DrinkFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, drinkFragment!!).commit()
        }

    }
}