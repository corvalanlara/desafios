package cl.desafiolatam.desafiodos.orm

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete

@Dao
interface TareaDAO {
	@Query("SELECT * FROM tareas")
	fun all(): List<Tarea>

	@Insert
	fun save(tarea: Tarea)

	@Query("UPDATE tareas SET descripcion = :newText WHERE id = :id")
	fun update(id: Long, newText: String)

	@Query("DELETE FROM tareas")
	fun deleteAll()
}
