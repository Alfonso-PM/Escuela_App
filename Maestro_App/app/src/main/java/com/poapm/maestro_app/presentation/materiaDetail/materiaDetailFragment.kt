package com.poapm.maestro_app.presentation.materiaDetail


import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.presentation.BaseFragment
import com.poapm.maestro_app.databinding.MateriaDetailFragmentBinding
import com.poapm.maestro_app.presentation.materia.materiaFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class materiaDetailFragment : BaseFragment(R.layout.materia_detail_fragment) {

    private lateinit var binding: MateriaDetailFragmentBinding
    private val args: materiaDetailFragmentArgs by navArgs()

    override fun setBinding(view: View) {

        binding = MateriaDetailFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@materiaDetailFragment

            classDetail = args.classDetail

            if(loggedUser == null){
                btnStudent.isVisible = false
            }

            btnStudent.setOnClickListener {

                navController.navigate(materiaDetailFragmentDirections.actionMateriaDetailFragmentToStudentFragment(args.classDetail))

            }
        }

    }
}