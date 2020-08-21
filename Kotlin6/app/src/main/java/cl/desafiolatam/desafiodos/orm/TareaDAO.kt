package cl.desafiolatam.desafiodos.orm

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.lifecycle.LiveData

@Dao
interface TareaDAO {
	@Query("SELECT * FROM tareas")
	fun all(): LiveData<List<Tarea>>

	@Insert
	suspend fun save(tarea: Tarea)

	@Query("UPDATE tareas SET descripcion = :newText WHERE id = :id")
	suspend fun update(id: Long, newText: String)

	@Delete
	suspend fun delete(tarea: Tarea)

	@Query("DELETE FROM tareas")
	suspend fun deleteAll()
}
