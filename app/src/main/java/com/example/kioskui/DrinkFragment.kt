package com.example.kioskui

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.kioskui.databinding.FragmentDrinkBinding
import com.example.kioskui.databinding.FragmentSetmenuBinding

class DrinkFragment : Fragment() {
    private lateinit var binding: FragmentDrinkBinding
    private var checkedItem: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrinkBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 메뉴 사진 누르면 다이얼로그
        binding.drinkmenu1Img.setOnClickListener {
            val cDialogView =
                LayoutInflater.from(view.context).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(view.context)
                .setView(cDialogView)
                .setTitle("옵션 선택")


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


        /*val items = arrayOf<String>("00추가","00추가","00추가","00추가","00추가","00추가","00추가","00추가")

            AlertDialog.Builder(view.context).run {
                setTitle("Test")
                setIcon(R.drawable.ic_launcher_background)
                setSingleChoiceItems(items,
                checkedItem,
                object : DialogInterface.OnClickListener{
                    override fun onClick(
                        p0: DialogInterface?,
                        which: Int,
                    ){
                        Log.d("선택", "${items[which]}이 선택되었습니다." )
                    }
                })
                setPositiveButton("담기", null)
                setNegativeButton("취소", null)
                show()
            }
        }*/
    }
}