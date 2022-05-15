package com.example.deasa10.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.example.deasa10.R
import com.example.deasa10.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnPlayInTeams.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_selectTeamFragment)
            }

            imgMenu.setOnClickListener {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }

            nvMenu.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.itemLogIn -> findNavController().navigate(R.id.action_startFragment_to_logInFragment)
                }
                true
            }
        }

        val navMenuHeader = binding.nvMenu.getHeaderView(0)
        val name = navMenuHeader.findViewById<TextView>(R.id.tvUser)
        name.text = "userName"


    }

}