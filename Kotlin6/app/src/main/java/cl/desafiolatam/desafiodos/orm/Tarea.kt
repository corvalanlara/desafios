package cl.desafiolatam.desafiodos.orm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tareas")
data class Tarea(
	@PrimaryKey(autoGenerate = true) val id: Long = 0,
	val descripcion: String,
	val isCheck: Boolean = false
)
