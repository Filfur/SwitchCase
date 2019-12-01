package com.artemglotov.switchcase.ui.caseDetails.viewModels

import androidx.lifecycle.*
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.networking.NetworkService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CaseDetailsViewModel(
    val case: Case,
    private val networkService: NetworkService
) : ViewModel() {
    val skins: LiveData<List<Skin>> = liveData {
        val skins = networkService.getCaseSkins(case.caseId)
        emit(skins)
    }

    val droppedSkin: MutableLiveData<Skin> = MutableLiveData()

    fun dropSkin() {
        viewModelScope.launch {
            val skin = networkService.dropSkin(case.caseId)
            delay(3000)
            droppedSkin.postValue(skin)
        }
    }
}