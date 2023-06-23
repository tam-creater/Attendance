package com.example.attendance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AttendanceConfirmationActivity : AppCompatActivity() {

    //データベースからデータの獲得
    val dataset: ArrayList<String> = arrayListOf(
        "奥山 博文",
        "小林 大樹",
        "与儀 武志",
        "田村 真司",
        "箕輪 琢磨",
        "六原 大地"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_confirmation)

        //リサイクラービューの設定
        val recyclerView: RecyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.setHasFixedSize(true)

        val rLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = rLayoutManager

        val adapter: AttendanceConfirmationAdapter = AttendanceConfirmationAdapter(dataset)
        recyclerView.adapter = adapter
    }
}