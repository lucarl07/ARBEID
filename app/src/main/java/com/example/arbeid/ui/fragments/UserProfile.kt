package com.example.arbeid.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.arbeid.R
import com.example.arbeid.databinding.FragmentUserProfileBinding

class UserProfile : Fragment() {

    // Declaring the nullable and non-nullable forms of binding:
    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    // Declaring the later-initialized expandable CardViews:
    private lateinit var expandableSkills: CardView
    private lateinit var expandableExperience: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        expandableSkills = binding.userSkills
        expandableExperience = binding.userExperience

        binding.userSkills.setOnClickListener {
            expandCardView(it, expandableSkills, binding.userSkillsList)
        }
        binding.userExperience.setOnClickListener {
            expandCardView(it, expandableExperience, binding.userExperienceList)
        }

        return binding.root
    }

    fun expandCardView(view: View, layout: CardView, accordion: View) {
        val newView = if (accordion.visibility == View.GONE) {
            View.VISIBLE
        } else {
            View.GONE
        }

        TransitionManager.beginDelayedTransition(layout, AutoTransition())
        accordion.visibility = newView;
    }

}