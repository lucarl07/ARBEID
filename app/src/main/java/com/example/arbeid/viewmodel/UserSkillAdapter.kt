package com.example.arbeid.viewmodel

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arbeid.R
import com.example.arbeid.model.UserSkill

class UserSkillAdapter(private val skillList: ArrayList<UserSkill>)
    : RecyclerView.Adapter<UserSkillAdapter.SkillViewHolder>() {

    class SkillViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
         val textView: TextView = itemView.findViewById(R.id.skill_list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}