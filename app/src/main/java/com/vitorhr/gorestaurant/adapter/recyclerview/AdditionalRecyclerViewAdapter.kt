package com.vitorhr.gorestaurant.adapter.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.vitorhr.gorestaurant.R
import com.vitorhr.gorestaurant.listener.AdditionalClickListener
import com.vitorhr.gorestaurant.model.AdditionalItem

class AdditionalRecyclerViewAdapter(
    private val items: List<AdditionalItem>,
    private val onDecrementClickListener: AdditionalClickListener,
    private val onIncrementClickListener: AdditionalClickListener,
) :
    RecyclerView.Adapter<AdditionalRecyclerViewAdapter.AdditionalViewHolder>() {
    class AdditionalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: MaterialTextView = view.findViewById(R.id.TVName)
        val decrementButton: AppCompatButton = view.findViewById(R.id.BTNDecrement)
        val incrementButton: AppCompatButton = view.findViewById(R.id.BTNIncrement)
        val total: MaterialTextView = view.findViewById(R.id.TVTotalItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdditionalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.additional_item, parent, false)

        return AdditionalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdditionalViewHolder, position: Int) {
        with(items[position]) {
            holder.name.text = name

            if (holder.total.text.isNullOrEmpty()) {
                holder.total.text = "0"
            }

            holder.decrementButton.setOnClickListener {
                if(holder.total.text.toString().toInt() == 0) return@setOnClickListener
                holder.total.text = (holder.total.text.toString().toInt() - 1).toString()
                onDecrementClickListener.onClick(priceInCents)
            }

            holder.incrementButton.setOnClickListener {
                holder.total.text = (holder.total.text.toString().toInt() + 1).toString()
                onIncrementClickListener.onClick(priceInCents)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}