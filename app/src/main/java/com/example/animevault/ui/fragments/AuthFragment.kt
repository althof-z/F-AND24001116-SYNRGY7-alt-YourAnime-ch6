package com.example.animevault.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.animevault.R
import com.example.animevault.databinding.FragmentAuthBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class AuthFragment : Fragment() {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleBottomNavigation()
        binding.bottomNav.selectedItemId = R.id.nav_home
    }

    private fun setFragment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun handleBottomNavigation() {
        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    setFragment(AnimeFragment())
                    true
                }
                R.id.nav_list -> {
                    Log.e("NAVBOTTOM", "masuk list")
                    setFragment(FavoriteFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}
