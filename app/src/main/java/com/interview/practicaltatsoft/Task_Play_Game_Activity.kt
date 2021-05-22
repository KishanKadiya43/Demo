package com.interview.practicaltatsoft

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.interview.practicaltatsoft.databinding.ActivityTaskPlayGameBinding


class Task_Play_Game_Activity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityTaskPlayGameBinding
    lateinit var strEditText: String
    var buttonArrayList: ArrayList<String> = ArrayList()
    var buttonssArrayList: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task__play__game_)
        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnSubmit -> {
                strEditText = binding.edNumber.text.toString().trim()
                check()
            }
        }
    }


    fun check() {


        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        for (i in 0..3.toInt()) {
            val row = LinearLayout(this)
            row.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            for (j in 0..strEditText.toInt()) {
                val btnTag = Button(this)
                btnTag.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                btnTag.text = "Button " + (j + 1 + i * 4)
                btnTag.id = j + 1 + i * 4
                buttonArrayList.add(btnTag.id.toString())
                row.addView(btnTag)
            }
            layout.addView(row)
        }
        setContentView(layout);
        Log.d("ARRATYList",buttonArrayList.toString())
    }
}