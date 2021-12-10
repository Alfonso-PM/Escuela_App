package com.poapm.maestro_app.presentation.materia

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import com.poapm.maestro_app.core.extension.failure
import com.poapm.maestro_app.core.extension.observe
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.presentation.BaseFragment
import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.databinding.MateriaFragmentBinding
import com.poapm.maestro_app.domain.model.Class
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class materiaFragment : BaseFragment(R.layout.materia_fragment) {

    private lateinit var binding: MateriaFragmentBinding
    private  val adapter: MateriaAdapter by lazy { MateriaAdapter() }
    private val materiaViewModel by viewModels<MateriaViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        materiaViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is MateriaViewState.MateriaReceived -> setUpAdapter(state.materia)
        }
    }

    override fun setBinding(view: View) {
        binding = MateriaFragmentBinding.bind(view)

        binding.rcMateria.layoutManager = GridLayoutManager(requireContext() ,2)

        binding.lifecycleOwner = this

        materiaViewModel.validate(loggedUser)
    }

    private fun setUpAdapter(classCls : List<Class>) {

        adapter.addData(classCls)

        adapter.listener = {
            navController.navigate(materiaFragmentDirections.actionMateriaFragmentToMateriaDetailFragment(it))
        }

        binding.rcMateria.apply {
            adapter = this@materiaFragment.adapter
        }
    }


}