package com.interview.practicaltatsoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.interview.practicaltatsoft.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnButtonFirst.setOnClickListener(this)
        binding.btnButtonTwo.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnButtonFirst -> {
                var intentSecound = Intent(this, Task_Play_Game_Activity::class.java)
                startActivity(intentSecound)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
            }
            binding.btnButtonTwo -> {
                var intentSecound = Intent(this, Task_Two_Activity::class.java)
                startActivity(intentSecound)
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        }
    }
}