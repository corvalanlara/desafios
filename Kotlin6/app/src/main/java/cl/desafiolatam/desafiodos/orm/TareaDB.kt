package cl.desafiolatam.desafiodos.orm

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Tarea::class], version = 1, exportSchema = false)
abstract class TareaDB : RoomDatabase() {
	abstract fun getTareaDAO() : TareaDAO
}
