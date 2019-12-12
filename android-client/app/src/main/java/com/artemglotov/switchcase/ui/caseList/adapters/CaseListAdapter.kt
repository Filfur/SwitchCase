package com.artemglotov.switchcase.ui.caseList.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.core.models.Case
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_case_list_item.view.*

class CaseListAdapter(val onCaseSelected: (case: Case) -> Unit) : RecyclerView.Adapter<CaseListAdapter.CaseViewHolder>() {

    var items: List<Case> = listOf()

    fun updateItems(newItems: List<Case>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_case_list_item, parent, false)
        return CaseViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        val item = items[position]
        holder.bindData(item)
        holder.itemView.setOnClickListener {
            onCaseSelected(item)
        }
    }

    class CaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.text_case_name
        var price: TextView = itemView.text_price
        var image: ImageView = itemView.image_case

        fun bindData(item: Case) {
            name.text = item.name
            price.text = itemView.context.getString(R.string.case_price_template, item.price.toString())

            Glide.with(image).load(item.imageLink).into(image)
        }
    }
}