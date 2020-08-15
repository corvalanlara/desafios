package com.e.kotlin4

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    private val LISTA = SetupCiclovias().init() as ArrayList<Ciclovia>
    private var currentLista: MutableList<Ciclovia> = LISTA
    private lateinit var vistaLista: RecyclerView
    private lateinit var madapter: CicloviaAdapter
    private lateinit var mlayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mlayoutManager = LinearLayoutManager(this)
        madapter = CicloviaAdapter()
	madapter.updateLista(currentLista)

        vistaLista = lista.apply {
            layoutManager = mlayoutManager
            adapter = madapter
        }

        val soloComunas = LISTA.map{ it.comuna }.toSet().toMutableList()
        val listaComunas = listOf("Todos") + soloComunas

	    val change = object : AdapterView.OnItemSelectedListener {
		    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                when(pos) {
                    0 -> vistaLista.adapter = madapter
                    else -> { 
				currentLista = LISTA.filter{ x -> x.comuna == parent.getItemAtPosition(pos)} as ArrayList<Ciclovia>
				madapter.updateLista(currentLista)
			  
			    }
                         }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                madapter.updateLista(currentLista)
            }
	    }
	
        val spinnerAdapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, listaComunas)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = change
	    //spinner.setSelection(0, false)
	    //spinner.prompt = "Todas las comunas"

        val click = View.OnClickListener {
		currentLista = currentLista.reversed() as ArrayList<Ciclovia>
                madapter.updateLista(currentLista)
        }

        invertir.setOnClickListener(click)

        }

}
