package com.artemglotov.switchcase.ui.caseList.viewModels

import androidx.lifecycle.*
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.networking.NetworkService

class CaseListViewModel(
    private val networkService: NetworkService
) : ViewModel() {

    val cases: LiveData<List<Case>> = liveData {
        val cases = networkService.getCases()
        emit(cases)
    }

}