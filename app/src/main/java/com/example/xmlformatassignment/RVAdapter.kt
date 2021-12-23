package com.example.xmlformatassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter(var students: List<Student>):RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val student = students[position]

        holder.itemView.apply {
            tvName.text = student.name
            tvGrade.text = student.grade.toString()
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }

    fun update(students: List<Student>){
        this.students = students
        notifyDataSetChanged()
    }
}