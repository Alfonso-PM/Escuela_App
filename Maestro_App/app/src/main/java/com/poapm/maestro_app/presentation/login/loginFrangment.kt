package com.poapm.maestro_app.presentation.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poapm.maestro_app.R

class loginFrangment : Fragment() {

    companion object {
        fun newInstance() = loginFrangment()
    }

    private lateinit var viewModel: LoginFrangmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_frangment_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginFrangmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}