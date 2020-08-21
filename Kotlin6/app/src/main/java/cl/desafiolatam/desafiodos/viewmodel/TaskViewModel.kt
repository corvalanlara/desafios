package cl.desafiolatam.desafiodos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.desafiolatam.desafiodos.orm.Tarea
import cl.desafiolatam.desafiodos.orm.TareaRepo
import cl.desafiolatam.desafiodos.orm.TareaDB
import kotlinx.coroutines.launch

class TaskViewModel(appli: Application) : AndroidViewModel(appli) {
	private val repo: TareaRepo
	val allTareas: LiveData<List<Tarea>>

	init {
		val dao = TareaDB.getDB(appli).getTareaDAO()
		repo = TareaRepo(dao)
		allTareas = repo.all
	}

	fun save(tarea: Tarea) = viewModelScope.launch {
		repo.save(tarea)
	}

	fun update(tarea: Tarea) = viewModelScope.launch {
		repo.update(tarea)
	}

	fun delete(tarea: Tarea) = viewModelScope.launch {
		repo.delete(tarea)
	}

	fun deleteAll() = viewModelScope.launch {
		repo.deleteAll()
	}
}
