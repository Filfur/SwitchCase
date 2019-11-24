package com.artemglotov.switchcase.ui.caseDetails.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin
import kotlinx.coroutines.launch

class CaseDetailsViewModel(
    val case: Case
) : ViewModel() {
    val skins: MutableLiveData<List<Skin>> = MutableLiveData()

    init {
        fetchSkins()
    }

    private fun fetchSkins() {
        viewModelScope.launch {
            val fetchedSkins = listOf<Skin>()
            skins.postValue(fetchedSkins)
        }
    }
}