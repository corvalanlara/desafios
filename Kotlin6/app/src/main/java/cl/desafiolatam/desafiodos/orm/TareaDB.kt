package cl.desafiolatam.desafiodos.orm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarea::class], version = 1, exportSchema = false)
abstract class TareaDB : RoomDatabase() {
	abstract fun getTareaDAO() : TareaDAO

	companion object {
		@Volatile
		private var INSTANCE: TareaDB? = null

		fun getDB(context: Context) : TareaDB {
			val tempInstancia = INSTANCE
			if (tempInstancia != null ) {
				return tempInstancia
			}

			synchronized(this) {
				val instancia = Room.databaseBuilder(
					context.applicationContext,
					TareaDB::class.java,
					"tareasdb").build()
				INSTANCE = instancia
				return instancia
			}
		}
	}
}
