package com.artemglotov.switchcase

import android.app.Application
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.ui.caseDetails.viewModels.CaseDetailsViewModel
import com.artemglotov.switchcase.ui.caseList.viewModels.CaseListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SwitchCaseApplication : Application() {
    private val koinModule = module {
        viewModel { CaseListViewModel() }
        viewModel { (case: Case) -> CaseDetailsViewModel(case) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SwitchCaseApplication)
            modules(koinModule)
        }
    }
}