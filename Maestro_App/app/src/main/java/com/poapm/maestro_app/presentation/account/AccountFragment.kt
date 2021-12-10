package com.poapm.maestro_app.presentation.account


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.extension.failure
import com.poapm.maestro_app.core.extension.loadFromURLCircular
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


        val url = loggedUser?.url
        val default = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.rae.es%2Fnoticia%2Fcorpus-del-espanol-del-siglo-xxi-random&psig=AOvVaw2-uuMuSARxHfhojPSrNfH1&ust=1639012080560000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCNCN0_uB0_QCFQAAAAAdAAAAABAD"
        if(binding.teacher?.url != null){
            url?.let { binding.imgStudent.loadFromURLCircular(it) }
        }else{
            binding.imgStudent.loadFromURLCircular(default)
        }

        accountViewModel.doGetAllTeachers("")
    }


}