package com.example.deportes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SportAdapter(
    private val sportsList: List<Sport>,
    private val onSelectionChanged: () -> Unit
) : RecyclerView.Adapter<SportAdapter.SportViewHolder>() {

    inner class SportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sportIcon: ImageView = itemView.findViewById(R.id.sportIcon)
        val sportName: TextView = itemView.findViewById(R.id.sportName)
        val sportCheckBox: CheckBox = itemView.findViewById(R.id.sportCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sport, parent, false)
        return SportViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val sport = sportsList[position]
        holder.sportIcon.setImageResource(sport.icon)
        holder.sportName.text = sport.name
        holder.sportCheckBox.isChecked = sport.isSelected

        holder.sportCheckBox.setOnCheckedChangeListener { _, isChecked ->
            sport.isSelected = isChecked
            onSelectionChanged()
        }
    }

    override fun getItemCount(): Int = sportsList.size
}
