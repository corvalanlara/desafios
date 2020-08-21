package cl.desafiolatam.desafiodos.task

import cl.desafiolatam.desafiodos.orm.Tarea

interface OnItemClickListener {
    fun onItemClick(taskItem:Tarea)
}
