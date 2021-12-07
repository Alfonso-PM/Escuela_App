package com.poapm.maestro_app.presentation.account


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.extension.failure
import com.poapm.maestro_app.core.extension.observe
import com.poapm.maestro_app.core.presentation.BaseFragment
import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.databinding.AccountFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class AccountFragment : BaseFragment(R.layout.account_fragment) {

    private lateinit var binding: AccountFragmentBinding

    private val accountViewModel by viewModels<AccountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        accountViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }

    }

    override fun onResume() {
        super.onResume()

        accountViewModel.getLocalTeacher()
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is AccountViewState.LoggedUser -> binding.teacher = state.teacher
            is AccountViewState.UserNotFound -> navController.navigate(AccountFragmentDirections.actionAccountFragmentToLoginFrangment())
        }
    }

    override fun setBinding(view: View) {
        binding = AccountFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@AccountFragment
            btnLogout.setOnClickListener { accountViewModel.doLogout() }
        }
    }


}