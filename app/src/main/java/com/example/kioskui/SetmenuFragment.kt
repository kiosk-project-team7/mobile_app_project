package com.example.kioskui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kioskui.databinding.FragmentSetmenuBinding

class SetmenuFragment : Fragment() {

    private lateinit var binding: FragmentSetmenuBinding
//    private var checkedItem: Int = 0
    private var set1Fragment: Set1Fragment? = null

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
        binding = FragmentSetmenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        // 메뉴 사진 누르면 다이얼로그
        binding.menu1Img.setOnClickListener {
            /*dialog(binding.menu1Img.drawable, binding.menu1Txt.text)*/
            MainActivity.menuInit.whenSelected(0, 0,
                resources.getDrawable(R.drawable.set_01_black_onion_chicken))
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu2Img.setOnClickListener {
            /*dialog(binding.menu2Img.drawable, binding.menu2Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu3Img.setOnClickListener {
            /*dialog(binding.menu3Img.drawable, binding.menu3Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu4Img.setOnClickListener {
            /*dialog(binding.menu4Img.drawable, binding.menu4Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu5Img.setOnClickListener {
            /*dialog(binding.menu5Img.drawable, binding.menu5Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu6Img.setOnClickListener {
            /*dialog(binding.menu6Img.drawable, binding.menu6Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu7Img.setOnClickListener {
            /*dialog(binding.menu7Img.drawable, binding.menu7Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu8Img.setOnClickListener {
            /*dialog(binding.menu8Img.drawable, binding.menu8Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu9Img.setOnClickListener {
            /*dialog(binding.menu9Img.drawable, binding.menu9Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu10Img.setOnClickListener {
            /*dialog(binding.menu10Img.drawable, binding.menu10Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu11Img.setOnClickListener {
            /*dialog(binding.menu11Img.drawable, binding.menu11Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }

        binding.menu12Img.setOnClickListener {
            /*dialog(binding.menu12Img.drawable, binding.menu12Txt.text)*/
            set1Fragment = Set1Fragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, set1Fragment!!).commit()

        }


    }

    // 클릭하면 화면 출력 함수
    /*private fun dialog(img: Drawable, tv: CharSequence){
        // 메뉴 선택 다이얼로그
        val cDialogView =
            LayoutInflater.from(view?.context).inflate(R.layout.custom_dialog, null)

        val logo = cDialogView.findViewById<ImageView>(R.id.logo)
        val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
        val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)



        imageView.setImageDrawable(img)
        textView.setText(tv)

        val mBuilder = view?.let {
            AlertDialog.Builder(it.context)
                .setView(cDialogView)
                .setTitle(tv)
                .setIcon(logo.drawable)
        }


        mBuilder?.setNegativeButton("닫기", null)
        mBuilder?.show()


        // 사용자화 버튼 선택 시 다이얼로그
        val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)
        cusButton.setOnClickListener {
            val c2DialogView =
                LayoutInflater.from(view?.context).inflate(R.layout.custom_option, null)

            val mBuilder2 = view?.let {
                AlertDialog.Builder(it.context)
                    .setView(c2DialogView)
                    .setTitle("사용자화")
                    .setIcon(logo.drawable)
                    .setPositiveButton("담기",null)
                    .setNegativeButton("닫기", null)
                    .show()

                val rdg1 = c2DialogView.findViewById<RadioGroup>(R.id.rdg1)
                val rdg2 = c2DialogView.findViewById<RadioGroup>(R.id.rdg2)

                var rb1 = rdg1.findViewById<RadioButton>(R.id.rb1)
                val rb2 = rdg1.findViewById<RadioButton>(R.id.rb2)
                val rb3 = rdg1.findViewById<RadioButton>(R.id.rb3)
                val rb4 = rdg2.findViewById<RadioButton>(R.id.rb4)
                val rb5 = rdg2.findViewById<RadioButton>(R.id.rb5)
                val rb6 = rdg2.findViewById<RadioButton>(R.id.rb6)

                rdg1.setOnCheckedChangeListener { _, checkedId ->
                    when (checkedId) {
                        R.id.rb1 -> {
                            Log.d("rdg1","rb1")
                            rdg2.clearCheck()
                        }
                        R.id.rb2 -> {
                            Log.d("rdg1","rb2")
                            if (rb4.isChecked)  rb4.isChecked = false
                            if (rb5.isChecked)  rb5.isChecked = false
                            if (rb6.isChecked)  rb6.isChecked = false
                        }
                        R.id.rb3 -> {
                            Log.d("rdg1","rb3")
                            if (rb4.isChecked)  rb4.isChecked = false
                            if (rb5.isChecked)  rb5.isChecked = false
                            if (rb6.isChecked)  rb6.isChecked = false
                        }
                    }
                }

                rdg2.setOnCheckedChangeListener { radioGroup, checkedId ->
                    if (checkedId == R.id.rb4){
                        Log.d("rdg2","rb4")
                        if (rb1.isChecked)  rb1.isChecked = false
                        if (rb2.isChecked)  rb2.isChecked = false
                        if (rb3.isChecked)  rb3.isChecked = false
                    }
                    else if (checkedId == R.id.rb5){
                        Log.d("rdg2","rb5")
                        if (rb1.isChecked)  rb1.isChecked = false
                        if (rb2.isChecked)  rb2.isChecked = false
                        if (rb3.isChecked)  rb3.isChecked = false
                    }
                    else if (checkedId == R.id.rb6){
                        Log.d("rdg2","rb6")
                        if (rb1.isChecked)  rb1.isChecked = false
                        if (rb2.isChecked)  rb2.isChecked = false
                        if (rb3.isChecked)  rb3.isChecked = false
                    }
                }
            }

//            mBuilder2?.setPositiveButton("담기",null)
//            mBuilder2?.setNegativeButton("닫기", null)
//            mBuilder2?.show()
        }

        // 추천 버튼 누를 시
        val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
        recButton.setOnClickListener {

        }
    }*/



}