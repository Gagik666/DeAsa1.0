package com.example.deasa10.screens.dialogScreens

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.deasa10.ViewModels.TeamViewModel
import com.example.deasa10.dataList.DataList
import com.example.deasa10.databinding.FragmentTeamDialogBinding
import com.example.deasa10.screens.SelectTeamFragmentDirections

class TeamDialogFragment : DialogFragment() {
    lateinit var binding: FragmentTeamDialogBinding
    lateinit var teamViewModel: TeamViewModel
    private val args: TeamDialogFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamDialogBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamViewModel = ViewModelProvider(this).get(TeamViewModel::class.java)

        teamViewModel.renameTeam(binding.edName.text.toString())
        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.tvName.text = args.name
        binding.btnOk.setOnClickListener {
            if (args.id == 1) {
                DataList.teamList.forEach {
                   if(it.team == binding.tvName.text) {
                        it.team = binding.edName.text.toString()
                   }
                }
            }

            if (args.id == 2) {
                DataList.teamList.forEach {
                    if(it.firstPlayer == binding.tvName.text) {
                        it.firstPlayer = binding.edName.text.toString()
                    }
                }
            }

            if (args.id == 3) {
                DataList.teamList.forEach {
                    if(it.secondPlayer == binding.tvName.text) {
                        it.secondPlayer = binding.edName.text.toString()
                    }
                }
            }
            dismiss()
        }


    }

}