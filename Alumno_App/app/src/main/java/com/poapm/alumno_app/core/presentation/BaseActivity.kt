package com.poapm.alumno_app.core.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import com.poapm.alumno_app.core.exception.Failure

abstract class BaseActivity : AppCompatActivity(), OnFailure{

    abstract fun layoutId(): Int
    abstract val fragmentContainer: FragmentContainerView

    abstract fun setUpNavigation(navController: NavController)

    override fun handleFailure(failure: Failure?) {
        showProgress(false)
    }

    abstract fun showProgress(show: Boolean)

    abstract fun setBinding()
}