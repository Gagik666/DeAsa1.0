package com.example.deasa10.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.deasa10.dataList.DataList
import com.example.deasa10.databinding.FragmentPointBinding


class PointFragment : Fragment() {
    lateinit var binding: FragmentPointBinding
    private val args: PointFragmentArgs by navArgs()
    var queue = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPointBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var point1 = 0
        var point2 = args.point

        DataList.teamPointList.forEach {
            point1 += it.team1.toString().toInt()

        }

        queue = args.queue
        var count = queue
        if (count == 0) {
            count = 1
        }

        if (queue == 4) {
            binding.btnPlay.visibility = View.INVISIBLE
            binding.btnNext.visibility = View.VISIBLE
        }

        binding.btnPlay.setOnClickListener {
            count++
            findNavController().navigate(
                PointFragmentDirections.actionPointFragmentToDeAsaStageFragment(
                    count
                )
            )
        }


        binding.tvTeam1Point.text = point1.toString()
        binding.tvTeam2Point.text = point2.toString()
    }

}