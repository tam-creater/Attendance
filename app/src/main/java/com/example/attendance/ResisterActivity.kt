package com.example.attendance

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import java.util.Calendar

class ResisterActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resister)

        //選択された名前の表示
        val selectedName: TextView = findViewById(R.id.selectedName)
        selectedName.text = intent.getStringExtra("NAME")

        //年月日
        val cal = Calendar.getInstance()
        val year:TextView = findViewById(R.id.year)
        year.text = "%4d/%02d/%02d".format(
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH) + 1,
            cal.get(Calendar.DAY_OF_MONTH)
        )

        //時間
        val time:TextView = findViewById(R.id.time)
        time.text = "%02d:%02d:%02d".format(
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            cal.get(Calendar.SECOND)
        )

        //現在のステータス
        val status:TextView = findViewById(R.id.status)

        //ボタンの機能
        val workBtn: Button = findViewById(R.id.work)
        workBtn.setOnClickListener {
            status.text = workBtn.text
        }
        val restBtn: Button = findViewById(R.id.rest)
        restBtn.setOnClickListener {
            status.text = restBtn.text
        }
        val leaveBtn: Button = findViewById(R.id.leave)
        leaveBtn.setOnClickListener {
            status.text = leaveBtn.text
        }

        //メニューポップアップ
        val button: Button = findViewById(R.id.details)
        val popUp = PopupMenu(this, button)

        popUp.menu.add(Menu.NONE, 0, 0, "出勤状況の確認")
        popUp.menu.add(Menu.NONE, 1, 1, "プロジェクト変更")
        popUp.menu.add(Menu.NONE, 2, 2, "ログインユーザー変更")
        popUp.menu.add(Menu.NONE, 3, 3, "プロジェクトの管理")
        popUp.menu.add(Menu.NONE, 4, 4, "ユーザーの管理")

        popUp.setOnMenuItemClickListener { menuItem ->
            val id = menuItem.itemId
            button.text = menuItem.title
            if (id == 0) {
                val intent: Intent = Intent(this, AttendanceConfirmationActivity::class.java)
                intent.putExtra("CONFORM", status.text.toString())
                intent.putExtra("NAME", selectedName.text.toString())
                intent.putExtra("YEAR", year.text.toString())
                intent.putExtra("TIME", time.text.toString())
                startActivity(intent)
            }
            false
        }
        button.setOnClickListener {
            popUp.show()
        }
    }
}