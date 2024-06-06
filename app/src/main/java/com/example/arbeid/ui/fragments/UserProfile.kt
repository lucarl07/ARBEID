package com.example.arbeid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.arbeid.databinding.FragmentUserProfileBinding
import com.example.arbeid.model.UserSkill
import com.example.arbeid.viewmodel.UserSkillAdapter

class UserProfile : Fragment() {

    // Declaring the nullable and non-nullable forms of binding:
    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    // Declaring the recycler view for the user's skills and its class associates:
    private lateinit var skRecyclerView: RecyclerView
    private lateinit var skList: ArrayList<UserSkill>
    private lateinit var skAdapter: UserSkillAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflating the layout:
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)

        skRecyclerView = binding.skillRecyclerView
        skRecyclerView.setHasFixedSize(true)
        skRecyclerView.layoutManager = LinearLayoutManager(this.context)

        skList = ArrayList()
        skList.add(UserSkill("JavaScript ES6 - Avançado"))
        skList.add(UserSkill("HTML5 - Avançado"))
        skList.add(UserSkill("CSS3 - Avançado"))
        skList.add(UserSkill("Vue.js - Avançado"))
        skList.add(UserSkill("React - Intermediário"))
        skList.add(UserSkill("PHP - Básico"))

        skAdapter = UserSkillAdapter(skList)
        skRecyclerView.adapter = skAdapter

        binding.apply {
            // Allowing CardView expansion:
            userSkillsSelector.setOnClickListener {
                expandCardView(userSkills, skillRecyclerView)
            }
            userExperienceSelector.setOnClickListener {
                 expandCardView(userExperience, something)
            }
        }

        return binding.root
    }

    private fun expandCardView(layout: CardView, accordion: View) {
        val newView = when (accordion.isVisible) {
            false -> View.VISIBLE
            true -> View.GONE
        }

        TransitionManager.beginDelayedTransition(layout, AutoTransition())
        accordion.visibility = newView;
    }

}