package com.example.recyclerviewpractice

//import ProfileAdapter
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.recyclerviewpractice.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    lateinit var profileAdapter: ProfileAdapter
//    val datas = mutableListOf<ProfileData>()
//    private lateinit var binding: ActivityMainBinding
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
//
//        initRecycler()
//    }
//
//    private fun initRecycler() {
//        profileAdapter = ProfileAdapter(this)
//        binding.rvProfile.adapter = profileAdapter
//
//        binding.rvProfile.addItemDecoration(VerticalItemDecorator(20))
//        binding.rvProfile.addItemDecoration(HorizontalItemDecorator(10))
//
//        datas.apply {
//            Log.d("결과", "값 삽입")
//            add(
//                ProfileData(
//                    img = R.drawable.ic_android_black_24dp,
//                    have = "멋진 안드로이드",
//                    name = "지미",
//                    talent = "특기 : 괴롭히기"
//                )
//            )
//            add(
//                ProfileData(
//                    img = R.drawable.dream,
//                    have = "무서운 안드로이드",
//                    name = "꿈속의 너",
//                    talent = "특기 : 노래 부르기"
//                )
//            )
//            add(
//                ProfileData(
//                    img = R.drawable.ah,
//                    have = "착한 안드로이드",
//                    name = "아로하",
//                    talent = "특기 : 사람 살리기"
//                )
//            )
//            add(
//                ProfileData(
//                    img = R.drawable.like,
//                    have = "찌질한 안드로이드",
//                    name = "좋니",
//                    talent = "특기 : 전여친 생각하며 울기"
//                )
//            )
//            add(
//                ProfileData(
//                    img = R.drawable.look,
//                    have = "자상한 안드로이드",
//                    name = "바라만 본다",
//                    talent = "특기 : 감동주기"
//                )
//            )
//
//            profileAdapter.datas = datas
//            profileAdapter.notifyDataSetChanged()
//            Log.d("결과", "새로 고침")
//        }
//    }
//}

import ProfileAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main_rV: RecyclerView = findViewById(R.id.rv_profile)
        val send_btn: Button = findViewById(R.id.submit)
        val scanhave: EditText = findViewById(R.id.scanhave)
        val scanname: EditText = findViewById(R.id.scanname)
        val scantalent: EditText = findViewById(R.id.scantalent)

        var have: String = ""
        var name: String = ""
        var talent: String = ""
        val mainList = ArrayList<ProfileData>();

        send_btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                have = scanhave.text.toString()
                name = scanname.text.toString()
                talent = scantalent.text.toString()
                if (have != "" && name != "" && talent != "") {
                    mainList.add(ProfileData(have, name, talent))
                    main_rV.adapter = ProfileAdapter(mainList)

                } else {
                    Toast.makeText(this@MainActivity, "성격 혹은 이름, 특기를 입력하시오", Toast.LENGTH_LONG)
                        .show()
                }
            }

        })
        main_rV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_rV.setHasFixedSize(true)
    }
}