package com.example.attendance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    //データベースからデータの獲得？
    private val dataset: ArrayList<String> = arrayListOf(
        "奥山 博文",
        "小林 大樹",
        "与儀 武志",
        "田村 真司",
        "箕輪 琢磨",
        "六原 大地"
    )
    //参加しているプロジェクトの数
    private val joinedProject = 1
    //プロジェクトを設定しているか
    private val projectExistence = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //スピナーのプルダウンの設定
        val adapter:ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter.add("未登録")
        for(i in 0 until dataset.size) {
            adapter.add(dataset[i])
        }
        val spinner:Spinner = findViewById(R.id.spinner)
        spinner.adapter = adapter

        //ログインボタンの処理
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            if(spinner.selectedItem == "未登録") {
                val mySnackbar = Snackbar.make(
                    findViewById(R.id.login_layout),
                    R.string.no_user,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else if(joinedProject == 0) { //現在参加しているプロジェクトがない場合
                val intent = Intent(this, FinishActivity::class.java)
                startActivity(intent)
            } else if(projectExistence) { //参加しているプロジェクトがあり、設定している場合
                val intent: Intent = Intent(this,ResisterActivity::class.java)
                intent.putExtra("NAME", spinner.selectedItem as String)
                intent.putExtra("PRO", "新人研修プロジェクト")
                startActivity(intent)
            } else {//参加しているプロジェクトはあるが設定がまだな場合
                val intent = Intent(this, ProjectActivity::class.java)
                intent.putExtra("NAME", spinner.selectedItem as String)
                startActivity(intent)
            }
        }
    }
}