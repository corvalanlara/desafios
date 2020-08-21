package cl.desafiolatam.desafiodos.task

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.desafiodos.R
import cl.desafiolatam.desafiodos.orm.Tarea

class TaskListAdapter(private var tasksList: MutableList<Tarea>,
                      private var listener: OnItemClickListener,
                      private var context: Context
): RecyclerView.Adapter<TaskViewHolder>() {
    override fun getItemCount(): Int = tasksList.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val data = tasksList[position]
        holder.taskText.text = data.descripcion
        holder.taskText.setOnClickListener {
            listener.onItemClick(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.task_item, parent, false))
    }

    fun updateData(items: List<Tarea>) {
        tasksList.clear()
        tasksList.addAll(items)
        notifyDataSetChanged()
    }
}
