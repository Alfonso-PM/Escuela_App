package com.poapm.alumno_app.presentation.materia

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poapm.alumno_app.R

class materiaFragment : Fragment() {

    companion object {
        fun newInstance() = materiaFragment()
    }

    private lateinit var viewModel: MateriaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.materia_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MateriaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}