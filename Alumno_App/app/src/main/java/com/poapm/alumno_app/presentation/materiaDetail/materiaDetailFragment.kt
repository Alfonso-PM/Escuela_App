package com.poapm.alumno_app.presentation.materiaDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.poapm.alumno_app.R
import com.poapm.alumno_app.core.presentation.BaseFragment
import com.poapm.alumno_app.databinding.MateriaDetailFragmentBinding

class materiaDetailFragment : BaseFragment(R.layout.materia_detail_fragment) {
    private lateinit var binding: MateriaDetailFragmentBinding
    private val args: materiaDetailFragmentArgs by navArgs()


    override fun setBinding(view: View) {
        binding = MateriaDetailFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@materiaDetailFragment
            classDetail = args.classDetail
        }
    }


}