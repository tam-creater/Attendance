package com.example.attendance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //名前の変更
        val selectedName: TextView = findViewById(R.id.historyName)
        selectedName.text = intent.getStringExtra("NAME")

        //履歴の上書き
        val history1: TextView = findViewById(R.id.history1)
        history1.text = intent.getStringExtra("TIME")
    }
}