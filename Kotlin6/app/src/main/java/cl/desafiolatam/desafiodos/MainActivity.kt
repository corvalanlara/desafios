package cl.desafiolatam.desafiodos

import android.content.DialogInterface
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.desafiodos.task.OnItemClickListener
import cl.desafiolatam.desafiodos.task.TaskListAdapter
import cl.desafiolatam.desafiodos.task.TaskUIDataHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_task.view.*
import cl.desafiolatam.desafiodos.orm.Tarea
import cl.desafiolatam.desafiodos.orm.TareaDB
import cl.desafiolatam.desafiodos.orm.TareaDAO
import androidx.room.Room

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var list: RecyclerView
    private lateinit var adapter: TaskListAdapter
    private lateinit var db : TareaDB
    private lateinit var dao: TareaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setUpViews()
	db = Room.databaseBuilder(this, TareaDB::class.java, "tareasdb").allowMainThreadQueries().build()
	dao = db.getTareaDAO()
    }

    override fun onItemClick(taskItem: TaskUIDataHolder) {
        val dialogView = layoutInflater.inflate(R.layout.add_task, null)
        val taskText = dialogView.task_input
        taskText.setText(taskItem.text)
        val dialogBuilder = AlertDialog
            .Builder(this)
            .setTitle("Editar una Tarea")
            .setView(dialogView)
            .setNegativeButton("Cerrar") {
                    dialog: DialogInterface, _: Int -> dialog.dismiss()}
            .setPositiveButton("Editar") {
                    dialog: DialogInterface, _: Int ->
                 if (taskText.text?.isNotEmpty()!!) {
			AsyncTask.execute {
				updateEntity(taskItem, taskText.text.toString())
				val newItems = createEntityListFromDatabase(dao.all())
			runOnUiThread {
				adapter.updateData(newItems)
				dialog.dismiss()
				}
			}
                }
            }
        dialogBuilder.create().show()
    }

    override fun onResume() {
        super.onResume()
        AsyncTask.execute {
            val newItems = createEntityListFromDatabase(dao.all())//mutableListOf<TaskUIDataHolder>()
            runOnUiThread {
                adapter.updateData(newItems)
            }
        }
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

    private fun updateEntity(taskItem: TaskUIDataHolder, newText: String) {
        dao.update(taskItem.id, newText)
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
			AsyncTask.execute {
				dao.save(createEntity(taskText.text.toString()))
				val newItems = createEntityListFromDatabase(dao.all())
			runOnUiThread {
				adapter.updateData(newItems)
				dialog.dismiss()
			}
			}
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
			AsyncTask.execute {
				dao.deleteAll()
				val newItems = createEntityListFromDatabase(dao.all())
			runOnUiThread {
				adapter.updateData(newItems)
				dialog.dismiss()
			}
			}
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
