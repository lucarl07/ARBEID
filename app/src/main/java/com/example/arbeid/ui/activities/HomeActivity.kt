package com.example.arbeid.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.arbeid.R
import com.example.arbeid.databinding.ActivityHomeBinding
import com.example.arbeid.ui.fragments.TestFragment01
import com.example.arbeid.ui.fragments.TestFragment02
import com.example.arbeid.ui.fragments.UserProfile

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)
        replaceFragment(TestFragment01())

        binding.bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(TestFragment01())
                R.id.courses -> replaceFragment(TestFragment02())
                R.id.create_post -> replaceFragment(TestFragment01())
                R.id.user_profile -> replaceFragment(UserProfile())
            }; true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}