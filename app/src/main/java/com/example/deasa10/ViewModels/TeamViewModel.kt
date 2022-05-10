package com.example.deasa10.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deasa10.dataList.DataList
import com.example.deasa10.models.Teams

class TeamViewModel: ViewModel() {
    val liveDataTeams: MutableLiveData<MutableList<Teams>> = MutableLiveData()
    val liveDataTeam = MutableLiveData<String>()

    init {
        getTeams()
        liveDataTeam
    }

    fun getTeams(): MutableLiveData<MutableList<Teams>> {
        liveDataTeams.value = DataList.teamList
        return liveDataTeams
    }

    fun renameTeam(name: String): MutableLiveData<String> {
        liveDataTeam.value = name
        return liveDataTeam
    }

}