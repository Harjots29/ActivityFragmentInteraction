package com.harjot.activityfragmentinteraction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harjot.activityfragmentinteraction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityInterface: ActivityInterface
    lateinit var binding: ActivityMainBinding
    var counter=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRed.setOnClickListener {
            activityInterface.textChange("Red is Clicked")
            activityInterface.colorchange(1)
        }

        binding.btnGreen.setOnClickListener {
            activityInterface.textChange("Green is Clicked")
            activityInterface.colorchange(2)
        }
        binding.btnYellow.setOnClickListener {
            activityInterface.textChange("Yellow is Clicked")
            activityInterface.colorchange(3)
        }

        binding.btnReset.setOnClickListener {
            counter=0
            binding.tvCounter.setText("$counter")
        }
    }

    fun fragmentFunction() {
        counter++
        binding.tvCounter.setText("$counter")
    }
}