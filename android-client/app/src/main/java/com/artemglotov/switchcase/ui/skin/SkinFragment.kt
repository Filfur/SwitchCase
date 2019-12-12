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
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
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

        viewModel.skin.apply {
            text_skin_name.text = name

            text_weapon_name.text = weaponName

            Glide.with(this@SkinFragment).load(imageLink).into(image_skin)

            button_sell.text = getString(R.string.get_money_back, price.toString())
        }


        button_save_to_steam.setOnClickListener {
            viewModel.sendToSteam()
            Snackbar.make(view, "Your skin saved into STEAM", Snackbar.LENGTH_LONG).show()
            navController.popBackStack()
        }

        button_sell.setOnClickListener {
            val price = viewModel.getMoneyBack()
            userViewModel.increaseBalance(price)
            Snackbar.make(view, "Your skin was sold for ${"$"}${price}", Snackbar.LENGTH_LONG).show()
            navController.popBackStack()
        }
    }

}