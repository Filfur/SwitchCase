package com.artemglotov.switchcase.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.artemglotov.switchcase.R
import com.artemglotov.switchcase.ui.login.viewModels.LoginViewModel
import com.artemglotov.switchcase.ui.utils.hideKeyboard
import kotlinx.android.synthetic.main.destination_sign_in.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SignInFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModel()

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.destination_sign_in, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_login.setOnClickListener {
            hideKeyboard()
            val email = text_email.text
            val password = text_password.text

            lifecycleScope.launch {
                delay(2000)
                
                if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                    val isSuccess = viewModel.signIn(email.toString(), password.toString())

                    if (isSuccess) {
                        navController.navigate(SignInFragmentDirections.actionCaseList())
                    }
                }
            }
        }

        text_to_sign_up.setOnClickListener {
            navController.navigate(SignInFragmentDirections.actionSignUp())
        }
    }

}