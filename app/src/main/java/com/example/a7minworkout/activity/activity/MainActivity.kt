package com.example.a7minworkout.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.a7minworkout.R
import com.example.a7minworkout.activity.fragments.BmiFragment
import com.example.a7minworkout.activity.fragments.ExerciseFragment
import com.example.a7minworkout.activity.fragments.MainFragment
import com.example.a7minworkout.activity.fragments.SettingFragment
import com.example.a7minworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.chipnav.setItemSelected(R.id.startFragment, true)
        var trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.frame, MainFragment()).commit()
        itemMenu()
        window.statusBarColor = ContextCompat.getColor(this, R.color.teal_200)
    }

    private fun itemMenu() {

        binding.chipnav.setOnItemSelectedListener {
            when (it) {

                R.id.startFragment -> {
                    var trans = supportFragmentManager.beginTransaction()
                    trans.replace(R.id.frame, MainFragment()).commit()
                }
                R.id.bmiFragment -> {
                    var trans = supportFragmentManager.beginTransaction()
                    trans.replace(R.id.frame, BmiFragment()).commit()
                }
                R.id.calendarFragment -> {
                    var trans = supportFragmentManager.beginTransaction()
                    trans.replace(R.id.frame, ExerciseFragment()).commit()
                }
                R.id.settingFragment -> {
                    var trans = supportFragmentManager.beginTransaction()
                    trans.replace(R.id.frame, SettingFragment()).commit()
                }
            }
        }
    }
}
