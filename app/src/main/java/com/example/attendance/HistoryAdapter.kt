package com.example.attendance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(dataset: ArrayList<String>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var localDataset: ArrayList<String> = dataset

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val textView: TextView
        init {
            textView = view.findViewById(R.id.listedHistory)
        }

        fun getTextView(): TextView {
            return textView
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        val holder = UserAdapter.ViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.getTextView().text = localDataset[position]
    }

    override fun getItemCount(): Int {
        return localDataset.size
    }
}