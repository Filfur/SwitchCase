package com.artemglotov.switchcase.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.ui.UserViewModel
import com.artemglotov.switchcase.ui.profile.viewModels.ProfileViewModel
import com.artemglotov.switchcase.ui.utils.hideKeyboard
import kotlinx.android.synthetic.main.destination_profile.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModel()

    private val userViewModel: UserViewModel by sharedViewModel()

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.destination_profile, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.user.apply {
            text_username.setText(name)
            text_password.setText(password)
            text_steam_link.setText(steamLink)
            text_email.setText(email)
        }

        button_save.setOnClickListener {
            hideKeyboard()

            val email = text_email.text
            val password = text_password.text
            val steamLink = text_steam_link.text
            val username = text_username.text

            lifecycleScope.launch {
                delay(2000)

                if (!email.isNullOrEmpty() && !password.isNullOrEmpty() && !steamLink.isNullOrEmpty() && !username.isNullOrEmpty()) {
                    val isSuccess = viewModel.saveProfile(
                        email.toString(),
                        password.toString(),
                        username.toString(),
                        steamLink.toString()
                    )
                    if (isSuccess) {
                        navController.popBackStack()
                    }
                }
            }
        }

        button_sign_out.setOnClickListener {
            hideKeyboard()

            lifecycleScope.launch {
                userViewModel.isSignedIn = false
                navController.navigate(ProfileFragmentDirections.actionSignIn())
            }
        }
    }

}