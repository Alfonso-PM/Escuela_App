package com.poapm.maestro_app.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.extension.failure
import com.poapm.maestro_app.core.extension.observe
import com.poapm.maestro_app.core.presentation.BaseFragment
import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.databinding.LoginFrangmentFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi


@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class loginFrangment : BaseFragment(R.layout.login_frangment_fragment) {

    private lateinit var binding: LoginFrangmentFragmentBinding

    private val loginViewModel by viewModels<LoginFrangmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }

    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is LoginViewState.UserFound ->
                navController.popBackStack()
        }
    }

    override fun setBinding(view: View) {
        binding = LoginFrangmentFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@loginFrangment

            viewM = loginViewModel

            btnLogin.setOnClickListener { loginViewModel.doLogin() }

        }

    }
}