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

    //データベースからデータの獲得
    private val dataset: ArrayList<String> = arrayListOf(
        "奥山 博文",
        "小林 大樹",
        "与儀 武志",
        "田村 真司",
        "箕輪 琢磨",
        "六原 大地"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_user)

        //ログインされている名前の獲得
        val selectedName = intent.getStringExtra("NAME")

        val btn: Button = findViewById(R.id.change)

        //スピナーのプルダウンの設定
        val adapter:ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        for(i in 0 until dataset.size) {
            adapter.add(dataset[i])
        }
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