package com.poapm.maestro_app.presentation.student

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.extension.failure
import com.poapm.maestro_app.core.extension.observe
import com.poapm.maestro_app.core.presentation.BaseFragment
import com.poapm.maestro_app.core.presentation.BaseViewState
import com.poapm.maestro_app.databinding.MateriaFragmentBinding
import com.poapm.maestro_app.databinding.StudentFragmentBinding
import com.poapm.maestro_app.domain.model.DetailClass
import com.poapm.maestro_app.presentation.materia.materiaFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class studentFragment : BaseFragment(R.layout.student_fragment) {

    private lateinit var binding: StudentFragmentBinding
    private lateinit var idTeacher :DetailClass
    private  val adapter: StudentAdapter by lazy { StudentAdapter() }
    private val studentViewModel by viewModels<StudentViewModel>()
    private val args by navArgs<studentFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        studentViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is StudentViewState.DetailReceived -> setUpAdapter(state.detail)
        }
    }

    override fun setBinding(view: View) {
        binding = StudentFragmentBinding.bind(view)

        binding.lifecycleOwner = this

        studentViewModel.doGetDetailByIdClass(args.classId.idClass)
    }

    private fun setUpAdapter(detail : List<DetailClass>) {

        adapter.addData(detail)

        adapter.listener = {
            navController.navigate(studentFragmentDirections.actionStudentFragmentToStudentDetailFragment(it))
        }

        binding.rcStudent.apply {
            adapter = this@studentFragment.adapter
        }
    }
}