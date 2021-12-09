package com.poapm.alumno_app.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.poapm.alumno_app.R
import com.poapm.alumno_app.core.extension.observe
import com.poapm.alumno_app.core.extension.failure
import com.poapm.alumno_app.core.presentation.BaseFragment
import com.poapm.alumno_app.core.presentation.BaseViewState
import com.poapm.alumno_app.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi


@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class loginFragment : BaseFragment(R.layout.login_fragment) {

    private lateinit var binding: LoginFragmentBinding

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }

    }

    override fun setBinding(view: View) {
        binding = LoginFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@loginFragment

            logVM = loginViewModel

            btnLogin.setOnClickListener { loginViewModel.doLogin() }

        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is LoginViewState.UserFound ->
                navController.popBackStack()
        }
    }


}