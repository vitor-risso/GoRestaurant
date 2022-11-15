package com.vitorhr.gorestaurant.adapter.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.vitorhr.gorestaurant.R
import com.vitorhr.gorestaurant.model.Dish
import com.vitorhr.gorestaurant.ui.itemdetails.ItemDetailsActivity
import java.text.DecimalFormat

class DishesRecyclerViewAdapter(val items: List<Dish>, val context: Context? = null) :
    RecyclerView.Adapter<DishesRecyclerViewAdapter.DishesViewHolder>() {
    class DishesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: AppCompatImageView = view.findViewById(R.id.IVDish)
        val title: MaterialTextView = view.findViewById(R.id.TVTitle)
        val description: MaterialTextView = view.findViewById(R.id.TVDescription)
        val price: MaterialTextView = view.findViewById(R.id.TVPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dishes_item, parent, false)

        return DishesViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
        with(items[position]) {
            holder.image.setImageResource(image)
            holder.title.text = title
            holder.description.text = description

            val formatter = DecimalFormat("##,##")

            holder.price.text = formatter.format(priceInCents)

            context?.let {
                holder.itemView.setOnClickListener {
                    val intent = Intent(context, ItemDetailsActivity::class.java)
                    intent.putExtra("IMAGE_ID",image )
                    intent.putExtra("TITLE", title)
                    intent.putExtra("DESCRIPTION", description)
                    intent.putExtra("ORIGINAL_PRICE", priceInCents)
                    context.startActivity(intent)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}