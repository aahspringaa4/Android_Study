package com.example.clickergame

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.clickergame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.plus.setOnClickListener {
            count++
            binding.tvResult.setText("" + count)
        }

        binding.minus.setOnClickListener {
            if (count == 0) {
                Toast.makeText(
                    this@MainActivity,
                    "주의! : 저희 게임에서는 0이하로\n          내려갈 수 없습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                count--
                binding.tvResult.setText("" + count)
            }
        }

        binding.reset.setOnClickListener {
            count = 0
            binding.tvResult.setText("" + count)
        }
    }
}