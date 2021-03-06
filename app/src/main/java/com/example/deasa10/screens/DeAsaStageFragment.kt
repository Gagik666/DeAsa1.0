package com.example.deasa10.screens

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deasa10.Adapters.SingerAdapter
import com.example.deasa10.ViewModels.SingerViewModel
import com.example.deasa10.dataList.DataList
import com.example.deasa10.dataList.DataList.teamPointList
import com.example.deasa10.dataList.DataList.tempList
import com.example.deasa10.databinding.FragmentDeAsaStageBinding
import com.example.deasa10.models.Teams
import kotlinx.coroutines.*


class DeAsaStageFragment : Fragment() {
    lateinit var singerViewModel: SingerViewModel
    lateinit var singerAdapter: SingerAdapter
    lateinit var binding: FragmentDeAsaStageBinding
    private val args: DeAsaStageFragmentArgs by navArgs()
    lateinit var list: MutableList<String>
    var queue = 1
    var point1 = 0
    var point2 = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeAsaStageBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch(Dispatchers.Default) {
            seconsd()
        }
        singerViewModel = ViewModelProvider(this).get(SingerViewModel::class.java)
        var count = args.queue
        queue = count
        getSingerTempList()
        binding.rvSinger.layoutManager = LinearLayoutManager(this.context)
        singerAdapter = SingerAdapter(tempList.toMutableSet().toMutableList()) {
            singerViewModel.getPoint(1)

        }
        binding.rvSinger.adapter = singerAdapter

        singerViewModel.liveDataPoint.observe(viewLifecycleOwner, Observer {
            if (queue == 3) {
                point1 = it
            } else if (queue == 2 || queue == 4) {
                DataList.teamPointList.forEach {
                    it.team2 = it.toString().toInt()
                }
            } else {
                point1 = it
            }
            binding.tvPoint.text = "Point $it"

        })




        if (queue == 3) {
            binding.tvTeam.text = DataList.teamList[0].team
        } else if (queue == 2 || queue == 4) {
            binding.tvTeam.text = DataList.teamList[1].team
        } else {
            binding.tvTeam.text = DataList.teamList[0].team
        }


    }

    suspend fun seconsd() {
        for (i in 10 downTo 0) {
            delay(1000)
            withContext(Dispatchers.Main) {
                binding.tvSeconds.text = i.toString()
                if (i == 0) {
                    findNavController().navigate(
                        DeAsaStageFragmentDirections.actionDeAsaStageFragmentToPointFragment(
                            queue, point1
                        )
                    )
                    tempList.clear()
                }
            }

        }
    }

    fun getSingerTempList(): MutableList<String> {
        for (i in 1..6) {
            val randomSinger = (0..19).random()
            tempList.add(DataList.singerList[randomSinger].toString())
        }
        return tempList
    }
}