package com.artemglotov.switchcase.ui.skin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.ui.UserViewModel
import com.artemglotov.switchcase.ui.skin.viewModels.SkinViewModel
import kotlinx.android.synthetic.main.destination_skin.*
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SkinFragment : Fragment() {


    private val args: SkinFragmentArgs by navArgs()

    private val viewModel: SkinViewModel by viewModel(parameters = { parametersOf(args.skin) })

    private val navController: NavController by lazy {
        findNavController()
    }

    private val userViewModel: UserViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.destination_skin, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val skin = args.skin

        text_skin_name.text = args.skin.skinName

        text_weapon_name.text = args.skin.weaponName

        button_sell.text = "Get money back: ${skin.price}${"$"}"

        button_save_to_steam.setOnClickListener {
            viewModel.sendToSteam()
            navController.popBackStack()
        }

        button_sell.setOnClickListener {
            val price = viewModel.getMoneyBack()
            userViewModel.increaseBalance(price)
            navController.popBackStack()
        }
    }

}