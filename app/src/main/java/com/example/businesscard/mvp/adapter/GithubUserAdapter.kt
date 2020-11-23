package com.example.businesscard.mvp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.businesscard.R
import com.example.businesscard.mvp.model.User
import kotlinx.android.synthetic.main.item_user_adapter.view.*

class GithubUserAdapter(private val context: Context, private val users: List<User>) :
    RecyclerView.Adapter<GithubUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user_adapter, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: GithubUserAdapter.ViewHolder, position: Int) {
        holder.textId.text = users[position].id.toString()
        holder.textUsername.text = users[position].login
        holder.buttonViewProfile.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(users[position].url))
            context.startActivity(browserIntent)
        }
        Glide.with(context).load(users[position].avatarUrl).into(holder.avatar)    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textId: TextView = itemView.textId
        val textUsername: TextView = itemView.textUsername
        val avatar: ImageView = itemView.avatar
        val buttonViewProfile: Button = itemView.buttonViewProfile
    }
}