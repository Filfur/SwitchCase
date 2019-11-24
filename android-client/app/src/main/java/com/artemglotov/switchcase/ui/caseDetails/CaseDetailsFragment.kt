package com.artemglotov.switchcase.ui.caseDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.ui.caseDetails.viewModels.CaseDetailsViewModel
import com.artemglotov.switchcase.ui.caseDetails.adapters.SkinListAdapter
import kotlinx.android.synthetic.main.destination_case_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CaseDetailsFragment : Fragment() {

    private val args: CaseDetailsFragmentArgs by navArgs()

    private val viewModel: CaseDetailsViewModel by viewModel(parameters = { parametersOf(args.selectedCase) })

    private val adapter: SkinListAdapter = SkinListAdapter()

    private val skinsObserver = Observer<List<Skin>> { skins ->
        adapter.updateItems(skins)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.destination_case_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_case.adapter = adapter

        viewModel.skins.observe(this, skinsObserver)
    }


}