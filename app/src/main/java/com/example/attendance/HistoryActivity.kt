package com.example.attendance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {

    private val dataset: ArrayList<String> = arrayListOf(
        "2023/06/22  10:17:32  勤務中",
        "2023/06/20  15:23:80  退勤",
        "2023/06/19  13:09:08  休憩中"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //選択された名前
        val selectedName: TextView = findViewById(R.id.historyName)
        selectedName.text = intent.getStringExtra("SELECTED")
        println("------------")
        println(selectedName.text.toString())
        println("------------")

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)

        val rLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = rLayoutManager

        val adapter: UserAdapter = UserAdapter(dataset)
        recyclerView.adapter = adapter

        //メニューポップアップ
        val button: Button = findViewById(R.id.toLogin)
        val popUp = PopupMenu(this, button)

        popUp.menu.add(Menu.NONE, 0, 0, "ログアウト")

        popUp.setOnMenuItemClickListener { menuItem ->
            val id = menuItem.itemId
            button.text = menuItem.title
            if (id == 0) {
                val intent: Intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            false
        }
        button.setOnClickListener {
            popUp.show()
        }
    }
}