package com.artemglotov.switchcase.ui.caseList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.core.models.Case
import com.artemglotov.switchcase.ui.caseList.adapters.CaseListAdapter
import com.artemglotov.switchcase.ui.caseList.viewModels.CaseListViewModel
import kotlinx.android.synthetic.main.destination_case_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class CaseListFragment : Fragment() {

    private val viewModel: CaseListViewModel by viewModel()

    private val adapter: CaseListAdapter = CaseListAdapter { case ->
        viewModel.selectCase(case)
    }

    private val casesObserver = Observer<List<Case>> { cases ->
        adapter.updateItems(cases)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.destination_case_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_case.adapter = adapter

        viewModel.cases.observe(this, casesObserver)
    }


}