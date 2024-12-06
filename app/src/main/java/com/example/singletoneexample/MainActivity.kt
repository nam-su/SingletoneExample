package com.example.singletoneexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        val text = MyApplication.sharedPreferences.getString("data","")

        if (text.equals("")) {
            textView.text = "저장된 텍스트가 없습니다."
        } else {
            textView.text = text
        }

        // 버튼을 누르면 editText에 입력한 값을 Shared에 저장.
        button.setOnClickListener {
            val editor = MyApplication.sharedPreferences.edit()
            editor.putString("data",editText.text.toString())
            editor.apply()
            textView.text = editText.text.toString()
        }
    }
}