package com.example.kioskui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.util.Log
import android.widget.ImageView
import androidx.navigation.findNavController
import com.example.kioskui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val fragmentManager = supportFragmentManager

    class menuInit {
        companion object {
            val menuName = arrayOf(arrayListOf<String>("블랙어니언치킨버거 세트", "블랙어니언와퍼 세트", "골든치즈렐라치킨버거 세트", "골든치즈렐라X 세트",
                "골든치즈렐라와퍼버거 세트", "기네스콰트로치즈와퍼 세트", "기네스와퍼 세트", "몬스터X 세트", "몬스터와퍼 세트", "콰트로치즈와퍼 세트",
                "스태키2와퍼 세트", "스태키3와퍼 세트"),
                arrayListOf<String>("블랙어니언치킨버거 세트", "블랙어니언와퍼 세트", "골든치즈렐라치킨버거 세트", "골든치즈렐라X 세트",
                    "골든치즈렐라와퍼버거 세트", "기네스콰트로치즈와퍼 세트", "기네스와퍼 세트", "몬스터X 세트", "몬스터와퍼 세트", "콰트로치즈와퍼 세트",
                    "스태키2와퍼 세트", "스태키3와퍼 세트"),
                arrayListOf<String>("블랙어니언치킨버거 세트", "블랙어니언와퍼 세트", "골든치즈렐라치킨버거 세트", "골든치즈렐라X 세트",
                    "골든치즈렐라와퍼버거 세트", "기네스콰트로치즈와퍼 세트", "기네스와퍼 세트", "몬스터X 세트", "몬스터와퍼 세트", "콰트로치즈와퍼 세트",
                    "스태키2와퍼 세트", "스태키3와퍼 세트"),
                arrayListOf<String>("블랙어니언치킨버거 세트", "블랙어니언와퍼 세트", "골든치즈렐라치킨버거 세트", "골든치즈렐라X 세트",
                    "골든치즈렐라와퍼버거 세트", "기네스콰트로치즈와퍼 세트", "기네스와퍼 세트", "몬스터X 세트", "몬스터와퍼 세트", "콰트로치즈와퍼 세트",
                    "스태키2와퍼 세트", "스태키3와퍼 세트"))
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
            var stock = arrayOf(
                arrayListOf<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100),
                arrayListOf<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100),
                arrayListOf<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100),
                arrayListOf<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100))
            var price = arrayOf(
                arrayListOf<Int>(6900, 7300, 6800, 6400, 6100, 7500,
                                 7000, 6900, 6400, 6500, 5800, 6700),
                arrayListOf<Int>(6000, 6400, 5900, 5500, 5500, 6600,
                                 6100, 6000, 5500, 5600, 4900, 5800),
                arrayListOf<Int>(2900, 4500, 4200, 3200, 4000, 1700,
                                 1500, 2300, 1300, 1000, 3600, 2000),
                arrayListOf<Int>(1400, 1200, 900, 700, 900, 700,
                                 800, 900, 750, 600, 900, 700))
            var selectedAmt = arrayOf(
                arrayListOf<Int> (1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                arrayListOf<Int> (3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                arrayListOf<Int> (5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                arrayListOf<Int> (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
            fun whenSelected(menuNum: Int) {
                selectedAmt[menuNum] += 1
                stock[menuNum] -= 1
            }
        }
    }



    val menu1: menuInit = menuInit()


    class myclass {
       companion object {
           var menuName : String = " "
           var stock : Boolean = false
           var price : Int = 6800
        //   var isSeleced = Array<Boolean>(12,false)
            fun onclickTest(i : Int) {
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


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

}