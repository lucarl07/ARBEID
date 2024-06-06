package com.example.arbeid.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arbeid.R
import com.example.arbeid.model.UserSkill

class UserSkillAdapter(private val skillList: ArrayList<UserSkill>)
    : RecyclerView.Adapter<UserSkillAdapter.SkillViewHolder>() {

    class SkillViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
         val textView: TextView = itemView.findViewById(R.id.list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_info_each_item, parent, false)
        return SkillViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val skill = skillList[position]
        holder.textView.text = skill.name
    }

    override fun getItemCount(): Int {
        return skillList.size
    }
}