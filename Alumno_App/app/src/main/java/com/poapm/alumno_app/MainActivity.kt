package com.poapm.alumno_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.poapm.alumno_app.core.presentation.BaseActivity
import com.poapm.alumno_app.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun layoutId()= R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    override val fragmentContainer: FragmentContainerView
        get() = binding.fcvStuddent

    override fun setUpNavigation(navController: NavController) =
        NavigationUI.setupWithNavController(binding.bnvMain, navController)

    override fun showProgress(show: Boolean) {
        binding.progressView.isVisible=show
    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId())
    }
}