package cl.desafiolatam.desafiodos.task

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.desafiodos.R

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val taskText = view.findViewById<TextView>(R.id.task_text)
}