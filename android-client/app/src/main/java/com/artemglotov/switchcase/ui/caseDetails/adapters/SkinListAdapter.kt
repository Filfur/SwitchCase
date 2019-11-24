package com.artemglotov.switchcase.ui.caseDetails.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.core.models.Skin
import kotlinx.android.synthetic.main.fragment_skin_list_item.view.*

class SkinListAdapter() : RecyclerView.Adapter<SkinListAdapter.SkinViewHolder>() {

    var items: List<Skin> = listOf()

    fun updateItems(newItems: List<Skin>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_skin_list_item, parent, false)
        return SkinViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: SkinViewHolder, position: Int) {
        val item = items[position]
        holder.bindData(item)
    }

    class SkinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var weaponName: TextView = itemView.text_weapon_name
        var skinName: TextView = itemView.text_skin_name
        var image: ImageView = itemView.image_case

        fun bindData(item: Skin) {
            weaponName.text = item.weaponName
            skinName.text = item.skinName

//            Glide.with(image).load(item.imageLink).into(image)
        }
    }
}