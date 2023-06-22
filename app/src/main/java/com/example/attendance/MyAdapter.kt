package com.example.attendance

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(dataset: ArrayList<String>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var localDataset: ArrayList<String>
    val attendence = AttendanceConfirmationActivity()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val textView: TextView
        init {
            textView = view.findViewById(R.id.listedName)
        }

        fun getTextView(): TextView {
            return textView
        }

    }

    init {
        localDataset = dataset
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.my_test_view, parent,false)
        val holder =  ViewHolder(itemView)
        holder.itemView.setOnClickListener {
            val position = holder.absoluteAdapterPosition
            val intent = Intent(itemView.context, HistoryActivity::class.java)
            for(i in 0 until attendence.dataset.size) {
                if(position == i) {
                    intent.putExtra("NAME", attendence.dataset[i])
                }
            }
            itemView.context.startActivity(intent)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.getTextView().text = localDataset[position]
    }

    override fun getItemCount(): Int {
        return localDataset.size
    }
}