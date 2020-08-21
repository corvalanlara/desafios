package cl.desafiolatam.desafiodos

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.desafiodos.task.OnItemClickListener
import cl.desafiolatam.desafiodos.task.TaskListAdapter
import cl.desafiolatam.desafiodos.task.TaskUIDataHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_task.view.*
import cl.desafiolatam.desafiodos.viewmodel.TaskViewModel
import cl.desafiolatam.desafiodos.orm.Tarea
import androidx.room.Room

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var list: RecyclerView
    private lateinit var adapter: TaskListAdapter
    private lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setUpViews()
	viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
	viewModel.allTareas.observe(this, Observer {
		adapter.updateData(it)
	})
    }

    override fun onItemClick(taskItem: Tarea) {
        val dialogView = layoutInflater.inflate(R.layout.add_task, null)
        val taskText = dialogView.task_input
        taskText.setText(taskItem.descripcion)
        val dialogBuilder = AlertDialog
            .Builder(this)
            .setTitle("Editar una Tarea")
            .setView(dialogView)
            .setNegativeButton("Cerrar") {
                    dialog: DialogInterface, _: Int -> dialog.dismiss()}
            .setPositiveButton("Editar") {
                    dialog: DialogInterface, _: Int ->
                 if (taskText.text?.isNotEmpty()!!) {
				updateEntity(taskItem, taskText.text.toString())
                }
            }
        dialogBuilder.create().show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when {
            item.itemId == R.id.add -> addTask()
            item.itemId == R.id.remove_all -> removeAll()
        }
        return true
    }

    private fun setUpViews() {
        list = task_list
        list.layoutManager = LinearLayoutManager(this)
        adapter = TaskListAdapter( mutableListOf(), this, this)
        list.adapter = adapter
    }

    private fun updateEntity(taskItem: Tarea, newText: String) {
	taskItem.descripcion = newText
        viewModel.update(taskItem)
    }

    private fun addTask() {
        val dialogView = layoutInflater.inflate(R.layout.add_task, null)
        val taskText = dialogView.task_input
        val dialogBuilder = AlertDialog
            .Builder(this)
            .setTitle("Agrega una Tarea")
            .setView(dialogView)
            .setNegativeButton("Cerrar") {
                    dialog: DialogInterface, _: Int -> dialog.dismiss()}
            .setPositiveButton("Agregar") {
                    dialog: DialogInterface, _: Int ->
                if (taskText.text?.isNotEmpty()!!) {
				viewModel.save(createEntity(taskText.text.toString()))
                }
            }
        dialogBuilder.create().show()
    }

    private fun removeAll() {
        val dialog = AlertDialog
            .Builder(this)
            .setTitle("Borrar Todo")
            .setMessage("¿Desea Borrar todas las tareas?")
            .setNegativeButton("Cerrar") {
                    dialog: DialogInterface, _: Int -> dialog.dismiss()}
            .setPositiveButton("Aceptar") { dialog: DialogInterface, _: Int ->
		    viewModel.deleteAll()
            }
        dialog.show()
    }
    private fun createEntity(text:String) : Tarea {
	return Tarea(descripcion=text, isCheck = false)
    }

    private fun createEntityListFromDatabase(entities: List<Tarea>): MutableList<TaskUIDataHolder> {
        val dataList = mutableListOf<TaskUIDataHolder>()
	if (entities.isNotEmpty()) {
		for(entity in entities) {
			val dataView = TaskUIDataHolder(
				entity.id,
				entity.descripcion
			)
			dataList.add(dataView)
		}
	}
        return dataList
    }
}
