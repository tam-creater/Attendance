package com.example.attendance

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class AttendanceConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_confirmation)

        //ユーザー名の取得
        val selectedName = intent.getStringExtra("NAME")
        val selectedStatus = intent.getStringExtra("CONFORM")
        val selectedYear = intent.getStringExtra("YEAR")
        val selectedTime = intent.getStringExtra("TIME")

        //選択されたユーザーの色変更
        val selectedBtn: Button = when(selectedName) {
            "奥山 博文" -> findViewById(R.id.name1)
            "小林 大樹" -> findViewById(R.id.name2)
            "与儀 武志" -> findViewById(R.id.name3)
            "田村 真司" -> findViewById(R.id.name4)
            "箕輪 琢磨" -> findViewById(R.id.name5)
            "六原 大地" -> findViewById(R.id.name6)
            else -> findViewById(R.id.name1)
        }

        selectedBtn.setTextColor(Color.BLUE)

        //ステータスの変更
        val selectedText: TextView = when(selectedName) {
            "奥山 博文" -> findViewById(R.id.status1)
            "小林 大樹" -> findViewById(R.id.status2)
            "与儀 武志" -> findViewById(R.id.status3)
            "田村 真司" -> findViewById(R.id.status4)
            "箕輪 琢磨" -> findViewById(R.id.status5)
            "六原 大地" -> findViewById(R.id.status6)
            else -> findViewById(R.id.status1)
        }

        selectedText.text = selectedStatus

        //履歴に送るフォーマット
        val history = "$selectedYear $selectedTime $selectedStatus"

        //画面遷移
        val btn1: Button = findViewById(R.id.name1)
        val btn2: Button = findViewById(R.id.name2)
        val btn3: Button = findViewById(R.id.name3)
        val btn4: Button = findViewById(R.id.name4)
        val btn5: Button = findViewById(R.id.name5)
        val btn6: Button = findViewById(R.id.name6)

        btn1.setOnClickListener {
            val intent: Intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("NAME", selectedName)
            intent.putExtra("TIME", history)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent: Intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("NAME", selectedName)
            intent.putExtra("TIME", history)
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent: Intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("NAME", selectedName)
            intent.putExtra("TIME", history)
            startActivity(intent)
        }

        btn4.setOnClickListener {
            val intent: Intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("NAME", selectedName)
            intent.putExtra("TIME", history)
            startActivity(intent)
        }

        btn5.setOnClickListener {
            val intent: Intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("NAME", selectedName)
            intent.putExtra("TIME", history)
            startActivity(intent)
        }

        btn6.setOnClickListener {
            val intent: Intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("NAME", selectedName)
            intent.putExtra("TIME", history)
            startActivity(intent)
        }
    }
}