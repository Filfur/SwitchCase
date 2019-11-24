package com.artemglotov.switchcase.ui.caseList.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemglotov.switchcase.core.models.Case
import kotlinx.coroutines.launch

class CaseListViewModel : ViewModel() {
    val cases: MutableLiveData<List<Case>> = MutableLiveData()

    val selectedCase: MutableLiveData<Case> = MutableLiveData()

    init {
        fetchCases()
    }

    private fun fetchCases() {
        viewModelScope.launch {
            val fetchedCases = listOf<Case>()
            cases.postValue(fetchedCases)
        }
    }

    fun selectCase(case: Case) {
        selectedCase.postValue(case)
    }
}