package com.example.deasa10.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deasa10.dataList.DataList
import com.example.deasa10.models.Teams

class TeamViewModel: ViewModel() {
    val liveDataTeams: MutableLiveData<MutableList<Teams>> = MutableLiveData()
    val liveDataTeam = MutableLiveData<String>()
    private val teamLiveData = MutableLiveData<MutableList<Teams>>()
    val teamName: MutableLiveData<MutableList<Teams>> get() = teamLiveData


fun rename(name: MutableList<Teams>) {
    teamLiveData.value = name
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