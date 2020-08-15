package com.e.kotlin4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class CicloviaAdapter() : RecyclerView.Adapter<CicloviaAdapter.ViewHolder>() {

   lateinit var lista: MutableList<Ciclovia>

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list, parent, false) as View
      return ViewHolder(view)
   }

   override fun getItemCount(): Int {
      return lista.size
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val ciclo: Ciclovia = lista[position]
      holder.bind(ciclo)
   }

   fun updateLista(mlista: MutableList<Ciclovia>) {
   	lista = mlista
	notifyDataSetChanged()
   }

   class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {

      var nombre: TextView = v.findViewById(R.id.nombre)
      var comuna: TextView = v.findViewById(R.id.comuna)

      fun bind(ciclo: Ciclovia) {
         nombre.text = ciclo.nombre
         comuna.text = ciclo.comuna
      }
   }

}
