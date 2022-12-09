package com.example.kioskui

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivities
import android.app.PendingIntent.getActivity
import android.content.ClipData
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.FragmentMenuBinding
import com.example.kioskui.databinding.FragmentSetmenuBinding


class SetmenuFragment : Fragment() {
    var bundle : Bundle? = null
    private lateinit var binding: FragmentSetmenuBinding
    private var checkedItem: Int = 0

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
            val data = mutableListOf<Itemview>()
            val eventHandler = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    if(p1==DialogInterface.BUTTON_POSITIVE) //담기버튼
                    {
                        Toast.makeText(mainActivity,"담기버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show()
                    }
                    else //취소버튼
                    {
                        Toast.makeText(mainActivity,"취소버튼을 누르셨습니다.",Toast.LENGTH_SHORT).show()
                    }
                }

            }
            val cDialogView =
                LayoutInflater.from(view.context).inflate(R.layout.custom_dialog, null)

            val drawable = getDrawable(view.context ,R.drawable.set_01_black_onion_chicken)
            val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
            val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)
            imageView.setImageDrawable(drawable)
            textView.setText("메뉴1 설명-----")

            val mBuilder = AlertDialog.Builder(view.context)
                .setView(cDialogView)
                .setTitle("블랙어니언치킨버거 세트")
                .setIcon(drawable)


            mBuilder.setNegativeButton("닫기", null)
            mBuilder.show()

            val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)
            cusButton.setOnClickListener {
                val items =
                    arrayOf<String>("00추가", "00추가", "00추가", "00추가", "00추가", "00추가", "00추가", "00추가")

                AlertDialog.Builder(view.context).run {
                    setTitle("Test")
                    setIcon(R.drawable.ic_launcher_background)
                    setSingleChoiceItems(items,
                        checkedItem,
                        object : DialogInterface.OnClickListener {
                            override fun onClick(
                                p0: DialogInterface?,
                                which: Int,
                            ) {
                                Log.d("선택", "${items[which]}이 선택되었습니다.")
                            }
                        })
                    setPositiveButton("담기", eventHandler) //여기서 담기 눌렀을때 추가해야함.
                    setNegativeButton("취소", eventHandler)
                    show()
                }
            }
            val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
            recButton.setOnClickListener {

            }
        }

        binding.menu2Img.setOnClickListener {
            val cDialogView =
                LayoutInflater.from(view.context).inflate(R.layout.custom_dialog, null)

            val drawable = getDrawable(view.context ,R.drawable.set_02_black_onion)
            val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
            val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)
            imageView.setImageDrawable(drawable)
            textView.setText("메뉴2 설명-----")

            val mBuilder = AlertDialog.Builder(view.context)
                .setView(cDialogView)
                .setTitle("블랙어니언와퍼 세트")
                .setIcon(drawable)


            mBuilder.setNegativeButton("닫기", null)
            mBuilder.show()

            val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)
            cusButton.setOnClickListener {
                val items =
                    arrayOf<String>("00추가", "00추가", "00추가", "00추가", "00추가", "00추가", "00추가", "00추가")

                AlertDialog.Builder(view.context).run {
                    setTitle("Test")
                    setIcon(R.drawable.ic_launcher_background)
                    setSingleChoiceItems(items,
                        checkedItem,
                        object : DialogInterface.OnClickListener {
                            override fun onClick(
                                p0: DialogInterface?,
                                which: Int,
                            ) {
                                Log.d("선택", "${items[which]}이 선택되었습니다.")
                            }
                        })
                    setPositiveButton("담기", null)
                    setNegativeButton("취소", null)
                    show()
                }
            }

            val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
            recButton.setOnClickListener {

            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}