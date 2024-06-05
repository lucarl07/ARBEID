package com.example.arbeid.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.arbeid.R
import com.example.arbeid.databinding.FragmentUserProfileBinding

class UserProfile : Fragment() {

    // Declaring the nullable and non-nullable forms of binding:
    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflating the layout:
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)

        binding.apply {
            // Allowing for expansion in the CardViews:
            userSkillsSelector.setOnClickListener {
                expandCardView(userSkills, userSkillsList)
            }
            userExperienceSelector.setOnClickListener {
                expandCardView(userExperience, userExperienceList)
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