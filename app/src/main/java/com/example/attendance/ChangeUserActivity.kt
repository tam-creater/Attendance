package com.example.attendance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar

class ChangeUserActivity : AppCompatActivity() {

    //ログインされている名前の獲得
    val selectedName = intent.getStringExtra("NAME")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_user)

        val btn: Button = findViewById(R.id.change)

        //スピナーのプルダウンの設定
        val adapter:ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter.add("未登録")
        adapter.add("奥山 博文")
        adapter.add("小林 大樹")
        adapter.add("与儀 武志")
        adapter.add("田村 真司")
        adapter.add("箕輪 琢磨")
        adapter.add("六原 大地")
        adapter.remove("未登録")
        adapter.remove(selectedName)
        val spinner:Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter

        //ログインボタンの処理
        btn.setOnClickListener {
            if(spinner.selectedItem == "未登録") {
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.login_layout),
                    R.string.no_user,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                val intent: Intent = Intent(this,ResisterActivity::class.java)
                intent.putExtra("NAME", spinner.selectedItem as String)
                startActivity(intent)
            }

        }
    }
}