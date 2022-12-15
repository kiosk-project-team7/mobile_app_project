package com.example.kioskui

import android.content.ClipData.Item
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.kioskui.databinding.ActivityMainBinding
import com.example.kioskui.databinding.FragmentMenuBinding
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import com.example.kioskui.MainActivity.menuInit.Companion.total_price

open class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val fragmentManager = supportFragmentManager
    lateinit var  viewModel : OrderViewModel
    lateinit var binding: FragmentMenuBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
    class menuInit {
        companion object {
            val menuName = arrayListOf<String>("블랙어니언치킨버거 세트", "블랙어니언와퍼 세트", "골든치즈렐라치킨버거 세트", "골든치즈렐라X 세트",
                "골든치즈렐라와퍼버거 세트", "기네스콰트로치즈와퍼 세트", "기네스와퍼 세트", "몬스터X 세트", "몬스터와퍼 세트", "콰트로치즈와퍼 세트",
                "스태키2와퍼 세트", "스태키3와퍼 세트")
            val imgPath = "R.id.menu1Img"
            val desc = arrayListOf<String>("200분의 기다림, 블랙어니언으로 깊어진 풍미에 바삭한 킹치킨패티까지 블랙 어니언 치킨 버거",
                "200분의 기다림, 블랙어니언으로 깊어진 풍미에 100% 순쇠고기 패티까지 블랙 어니언 와퍼",
                "황금빛 치즈가 통째로! 모짜렐라 치즈와 체다 치즈가 만나 풍미 작렬! 골든치즈렐라치킨버거",
                "황금빛 치즈가 통째로! 모짜렐라 치즈와 체다 치즈가 만나 풍미 작렬! 골든치즈렐라X버거",
                "황금빛 치즈가 통째로! 모짜렐라 치즈와 체다 치즈가 만나 풍미 작렬! 골든치즈렐라와퍼버거",
                "기네스블랙번과 특제 기네스BBQ소스 그리고 불에 직접 구운 100% 순쇠고기 패티 그리고 네가지 고품격 치즈로 탄생항 기네스콰트로치즈와퍼",
                "기네스블랙번과 특제 기네스BBQ소스 그리고 불에 직접 구운 100% 순쇠고기 패티로 만나는 기네스와퍼",
                "강렬한 디아블로소스의 매콤함, 두툼한 프리미엄 패티를 부드러운 브리오슈 번으로 만난 몬스터X",
                "디아블로 소스의 매콤함, 불에 직접 구운 100% 순쇠고기 패티와 치킨패티까지 압도적 크기의 몬스터와퍼",
                "네가지 고품격 치즈와 100% 순쇠고기 패티로 탄생한 버거킹의 스테디셀러, 콰트로치즈와퍼",
                "믿고 먹을 수 있는 와퍼, 불에 직접 구운 100% 순쇠고기 패티 2장으로 더 크게 도전하세요! 스태키2와퍼",
                "믿고 먹을 수 있는 와퍼, 불에 직접 구운 100% 순쇠고기 패티 3장으로 더 크게 도전하세요! 스태키3와퍼")
            var d_name = arrayListOf<String>("아이스아메리카노","아메리카노","코카콜라(L)","코카콜라(R)","코카콜라제로(L)","코카콜라제로(R)","미닛메이드오렌지","씨그램(L)","씨그램(R)","순수","스프라이트(L)","스프라이트(R)")
            var s_name = arrayListOf<String>("21cm 치즈스틱","앵그리너겟킹","바삭킹","치즈프라이","코코넛쉬럼프","코올슬로","콘샐러드","크리미모짜볼","프렌치프라이(L)","프렌치프라이(R)","너겟킹","어니언링")
            var stock = arrayOf( // 48
                arrayListOf<Int>(3, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100), //세트
                arrayListOf<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100), //사이드
                arrayListOf<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100)) //드링크
            var mprice = arrayOf(
                arrayListOf<Int>(6900, 7300, 6800, 6400, 6100, 7500, 7000, 6900, 6400, 6500, 5800, 6700),
                arrayListOf<Int>(6000, 6400, 5900, 5500, 5500, 6600, 6100, 6000, 5500, 5600, 4900, 5800),
                arrayListOf<Int>(2900, 4500, 4200, 3200, 4000, 1700, 1500, 2300, 1300, 1000, 3600, 2000),
                arrayListOf<Int>(1400, 1200, 900, 700, 900, 700, 800, 900, 750, 600, 900, 700))
            var selectedAmt = arrayOf(
                arrayListOf<Int> (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),  //햄버거
                arrayListOf<Int> (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),  //드링크
                arrayListOf<Int> (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),  //사이드
                arrayListOf<Int> (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))  //토핑
            var hotlist = arrayListOf<Int>(8,4) //사이드 , 콜라

            fun whenSelected(menuOpt : Int,menuNum: Int) {
                Log.d("option","${menuOpt}, ${menuNum}")
                selectedAmt[menuOpt][menuNum]++
                stock[menuOpt][menuNum]--
                Log.d("선택관리","${selectedAmt[menuOpt][menuNum]}")
                Log.d("재고관리","${stock[menuOpt][menuNum]}")
            }
            fun detail(top : Int, dop : Int, sop: Int){
                selectedAmt[1][dop]++
                selectedAmt[2][sop]++
                selectedAmt[3][top]++
            }
            fun detail_delete(top : Int, dop : Int, sop: Int){
                selectedAmt[1][dop]--
                selectedAmt[2][sop]--
                selectedAmt[3][top]--
            }
            fun whenDelected(menuOpt: Int,menuNum: Int){
                selectedAmt[menuOpt][menuNum] -= 1
                stock[menuOpt][menuNum] += 1
                Log.d("선택관리","${selectedAmt[menuOpt][menuNum]}")
                Log.d("재고관리","${stock[menuOpt][menuNum]}")
            }
            fun whenAllDelected(menuOpt: Int,menuNum: Int,num:Int)
            {
                selectedAmt[menuOpt][menuNum] -= num
                stock[menuOpt][menuNum] += num
                Log.d("선택관리","${selectedAmt[menuOpt][menuNum]}")
                Log.d("재고관리","${stock[menuOpt][menuNum]}")
            }
            var tmax=0
            var dmax=0
            var smax=0
            var hmax=0
            var total_num = 0
            fun calculate()
            {

                Log.d("test","${selectedAmt[0][1]}")
                Log.d("test","${selectedAmt[0][2]}")
                for( i in 0 .. 3){
                    for( j in 0 .. 11)
                    {
                        dmax= kotlin.math.max(dmax, selectedAmt[0][j])
                        tmax=kotlin.math.max(tmax, selectedAmt[3][j])
                        dmax=kotlin.math.max(dmax, selectedAmt[1][j])
                        smax=kotlin.math.max(smax, selectedAmt[2][j])
                    }
                }
            }
            val data = mutableListOf <Itemview>()
            val pdata = mutableListOf<String>()
            var count = 0
            var total_price =0 //총 가격
            var today_total_price =0
            var check = false
            var menu_opt = 0
            var menu_num =0
            var top=0
            var dop=0
            var sop=0
            fun set_btn(img : ImageView){
                img.alpha=1f
                img.isClickable=true
                }
            }
        }
    }




    class myclass2 {
        companion object {
            var isSeleced : Boolean = true
            fun onclickTest() {
                isSeleced = !isSeleced
                Log.d("test", isSeleced.toString())
            }
        }
    }