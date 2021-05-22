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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task__play__game_)

        binding.btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnSubmit -> {
                strEditText = binding.edNumber.text.toString().trim()

                Log.d("Insert", strEditText)
                check()
            }
        }
    }


    fun check() {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        for (i in 0..2) {
            val row = LinearLayout(this)
            row.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            for (j in 0..3) {
                val btnTag = Button(this)
                btnTag.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                btnTag.text = "Button " + (j + 1 + i * 4)
                btnTag.id = j + 1 + i * 4
                row.addView(btnTag)
            }
            layout.addView(row)
        }
        setContentView(layout);
    }
}