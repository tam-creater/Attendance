package com.example.attendance

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(dataset: ArrayList<String>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var localDataset: ArrayList<String> = dataset
    val attendance = AttendanceConfirmationActivity()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val textView: TextView
        init {
            textView = view.findViewById(R.id.listedName)
        }

        fun getTextView(): TextView {
            return textView
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.user, parent,false)
        val holder =  ViewHolder(itemView)
        val position = holder.absoluteAdapterPosition
        holder.itemView.setOnClickListener {
            val intent = Intent(itemView.context, HistoryActivity::class.java)
            for(i in 0 until attendance.dataset.size) {
                if(position == i) {
                    intent.putExtra("NAME", attendance.dataset[i])
                }
            }
            itemView.context.startActivity(intent)
        }
        /*for(i in 0 until attendence.dataset.size) {
            if(attendence.selectedName == attendence.dataset[i]) {

            }
        }*/
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.getTextView().text = localDataset[position]
    }

    override fun getItemCount(): Int {
        return localDataset.size
    }
}