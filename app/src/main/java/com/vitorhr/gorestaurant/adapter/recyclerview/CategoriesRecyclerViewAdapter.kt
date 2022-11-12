package com.vitorhr.gorestaurant.adapter.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.vitorhr.gorestaurant.R
import com.vitorhr.gorestaurant.model.Categories

class CategoriesRecyclerViewAdapter(val items: List<Categories>) :
    RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: AppCompatImageView = view.findViewById(R.id.IVIcon)
        val title: MaterialTextView = view.findViewById(R.id.TVCardTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item, parent, false)

        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        with(items[position]){
            holder.icon.setImageResource(icon)
            holder.title.text = title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}