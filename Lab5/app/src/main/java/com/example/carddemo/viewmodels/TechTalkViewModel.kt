package com.example.carddemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.carddemo.repositories.TechTalk.TechTalkRepository
import com.example.carddemo.services.dto.TechTalkDto

class TechTalkViewModel : ViewModel() {
    var techTalksLiveData = MutableLiveData<List<TechTalkDto>>()
    var techTalkRepository = TechTalkRepository()

    init {
        techTalksLiveData = techTalkRepository.techTalks
    }

    fun getTechTalks() {
        techTalkRepository.getTechTalks()
    }
}