package com.example.restapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.pojo.Post
import kotlinx.android.synthetic.main.list_item.view.*

class PostAdapter(private val myDataset: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return PostHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = myDataset[position]
        holder.textId.text = post.id.toString()
        holder.name.text = post.name
	holder.email.text = post.email
	holder.phone.text = post.phone
    }

    class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.txtName
        var textId: TextView = itemView.tvId
	var phone: TextView = itemView.txtPhone
	var email: TextView = itemView.txtEmail
    }
}
