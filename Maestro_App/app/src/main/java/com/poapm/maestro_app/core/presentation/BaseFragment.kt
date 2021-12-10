package com.poapm.maestro_app.core.presentation

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.plataform.AuthManager
import com.poapm.maestro_app.domain.model.Teacher

abstract class BaseFragment (@LayoutRes layoutId: Int) : Fragment(layoutId), OnFailure {
    val navController by lazy { findNavController() }
    val baseActivity by lazy { requireActivity() as BaseActivity }
    private lateinit var authManager: AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authManager = AuthManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseActivity.setUpNavigation(navController)

        setBinding(view)
    }

    abstract fun setBinding(view: View)

     var loggedUser: Teacher?
         set(value) {
             authManager.teacher = value
         }
         get() {
             if(authManager.teacher == null){
                 return null
             }else{
                 return authManager.teacher!!
             }
         }

    open fun onViewStateChanged(state: BaseViewState?) {
        when (state) {
            BaseViewState.ShowLoading -> showLoader(true)
            BaseViewState.HideLoading -> showLoader(false)
        }
    }

    open fun showLoader(show: Boolean) = baseActivity.showProgress(show)

    private fun showToast(message: String) = Toast.makeText(
        context,
        message,
        Toast.LENGTH_SHORT
    ).show()

    override fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.Unauthorized -> {
                //failure.defaultMessage?.let { showToast(getString(it)) }
            }
            is Failure.ServerError -> showToast(failure.serverMessage ?: "")
            is Failure.DatabaseError -> {
                //failure.defaultMessage?.let { showToast(getString(it)) }
            }
            is Failure.NetworkConnection -> {
                //failure.defaultMessage?.let { showToast(getString(it)) }
            } //showToast(getString(R.string.error_no_internet_connection))
            is Failure.FeatureFailure -> failure.defaultMessage?.let { showToast(getString(it)) }
        }
    }

}