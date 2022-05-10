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
            var countPoint = 0
            countPoint++
            singerViewModel.getPoint(1)

        }
        binding.rvSinger.adapter = singerAdapter

        singerViewModel.liveDataPoint.observe(viewLifecycleOwner, Observer {
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
                            queue,
                            binding.tvPoint.text.toString().toInt()
                        )
                    )
                    tempList.clear()
                }
            }

        }
    }

    fun getSingerTempList(): MutableList<String> {
        for (i in 1..5) {
            val randomSinger = (0..20).random()
            tempList.add(DataList.singerList[randomSinger].toString())
        }
        return tempList
    }
}