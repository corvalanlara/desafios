package cl.desafiolatam.desafiodos.orm

import androidx.lifecycle.LiveData

class TareaRepo(private val dao: TareaDAO) {

	val all: LiveData<List<Tarea>> = dao.all()

	suspend fun save(tarea: Tarea) {
		dao.save(tarea)
	}

	suspend fun update(id: Long, text: String) {
		dao.update(id, text)
	}

	suspend fun delete(tarea: Tarea) {
		dao.delete(tarea)
	}

	suspend fun deleteAll() {
		dao.deleteAll()
	}

}
