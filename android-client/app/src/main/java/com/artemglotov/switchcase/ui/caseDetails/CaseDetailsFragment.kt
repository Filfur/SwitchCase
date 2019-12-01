package com.artemglotov.switchcase.ui.caseDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.core.models.Skin
import com.artemglotov.switchcase.ui.UserViewModel
import com.artemglotov.switchcase.ui.caseDetails.adapters.SkinListAdapter
import com.artemglotov.switchcase.ui.caseDetails.viewModels.CaseDetailsViewModel
import com.gtomato.android.ui.transformer.LinearViewTransformer
import com.gtomato.android.ui.widget.CarouselView
import kotlinx.android.synthetic.main.destination_case_details.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CaseDetailsFragment : Fragment() {

    private val args: CaseDetailsFragmentArgs by navArgs()

    private val viewModel: CaseDetailsViewModel by viewModel(parameters = { parametersOf(args.selectedCase) })

    private val userViewModel: UserViewModel by sharedViewModel()

    private val adapter: SkinListAdapter = SkinListAdapter()

    private val navController: NavController by lazy {
        findNavController()
    }

    private val skinsObserver = Observer<List<Skin>> { skins ->
        adapter.updateItems(skins)
        animation()
    }

    private val droppedSkinObserver = Observer<Skin> { skin ->
        val index = adapter.items.indexOfFirst { it.skinId == skin.skinId }
        isDropActive = false
        list_skin.smoothScrollToPosition(index)
    }

    var isDropActive = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.destination_case_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_skin.apply {
            adapter = this@CaseDetailsFragment.adapter
            transformer = LinearViewTransformer()
            isInfinite = true
            setOnScrollListener(object : CarouselView.OnScrollListener() {
                override fun onScrollEnd(carouselView: CarouselView?) {
                    if (isDropActive) {
                        list_skin.smoothScrollBy(2000, 0, LinearInterpolator(), 1000)
                    }
                    val skin = viewModel.droppedSkin.value
                    if (skin != null) {
                        lifecycleScope.launch {
                            delay(500)
                            navController.navigate(CaseDetailsFragmentDirections.actionSkin(skin))
                        }
                    }
                }
            })
        }

        button_drop.setOnClickListener {
            if (!isDropActive) {
                isDropActive = true

                button_drop.isEnabled = false
                button_drop.animate().apply {
                    alpha(0.5f)
                    duration = 1000
                }.start()

                userViewModel.decreaseBalance(args.selectedCase.price.toInt())
                image_arrow.animate().apply {
                    duration = 1000
                    alpha(1f)
                }.start()

                list_skin.smoothScrollBy(1000, 0, AccelerateInterpolator(), 1000)
                list_skin.setOnTouchListener { _, _ ->
                    true
                }
                viewModel.dropSkin()
            }
        }

        viewModel.skins.observe(this, skinsObserver)
        viewModel.droppedSkin.observe(this, droppedSkinObserver)

        val balance = userViewModel.balance.value
        if (balance == null || balance < args.selectedCase.price) {
            button_drop.isEnabled = false
            button_drop.animate().apply {
                alpha(0.5f)
                duration = 1000
            }.start()
        }
    }

    fun animation() {

    }

}