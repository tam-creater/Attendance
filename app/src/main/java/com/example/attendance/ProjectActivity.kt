package com.example.attendance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class ProjectActivity : AppCompatActivity() {

    private val dataset: ArrayList<String> = arrayListOf(
        "新人研修プロジェクト",
        "基幹系システム開発プロジェクト",
        "DXプロジェクト"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        //選択されている名前
        val selectedName = intent.getStringExtra("NAME")

        //スピナーのプルダウンの設定
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter.add("未登録")
        for(i in 0 until dataset.size) {
            adapter.add(dataset[i])
        }
        val spinner: Spinner = findViewById(R.id.project_spinner)
        spinner.adapter = adapter

        //ボタンの機能
        val btn: Button =findViewById(R.id.project_button)
        btn.setOnClickListener {
            val intent = Intent(this,ResisterActivity::class.java)
            intent.putExtra("NAME", selectedName)
            intent.putExtra("PRO", spinner.selectedItem as String)
            startActivity(intent)
        }
    }
}