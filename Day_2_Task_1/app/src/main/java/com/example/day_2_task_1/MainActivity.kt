package com.example.day_2_task_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    val clickCountUserMap = mutableMapOf<String,Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.clickCountView)
        val clickMeButton = findViewById<TextView>(R.id.buttonClick)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.inputName)

        clickMeButton.setOnClickListener{
            val userName = userNameTextInputView.editText?.text?.toString()
            val maskedUserName =
                if (userName.isNullOrEmpty()) "Somebody"
                else userName

            val oldClickCount = clickCountUserMap[maskedUserName] ?: 0
            val newClickCount = oldClickCount + 1
            clickCountUserMap[maskedUserName] = newClickCount
            clickCountDisplayView.text = "$maskedUserName Clicked $newClickCount times"
        }
    }
}