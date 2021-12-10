package com.poapm.maestro_app.presentation.studentDetail

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.poapm.maestro_app.R
import com.poapm.maestro_app.core.presentation.BaseFragment
import com.poapm.maestro_app.databinding.StudentDetailFragmentBinding
import com.poapm.maestro_app.domain.model.DetailClass
import com.poapm.maestro_app.presentation.materia.MateriaViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi


@AndroidEntryPoint
@DelicateCoroutinesApi
@WithFragmentBindings
class studentDetailFragment : BaseFragment(R.layout.student_detail_fragment) {

    private lateinit var binding: StudentDetailFragmentBinding
    private lateinit var detail: DetailClass
    private val args: studentDetailFragmentArgs by navArgs()
    private val studentDetailViewModel by viewModels<StudentDetailViewModel>()


    override fun setBinding(view: View) {
        binding = StudentDetailFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@studentDetailFragment

            student = args.classD

            val std = args.classD

            btnCal.setOnClickListener {
                val g1 = edtGrade1.text.toString().toInt()
                val g2 = edtGrade2.text.toString().toInt()
                val g3 = edtGrade3.text.toString().toInt()

                detail = DetailClass(std.idDetailClass,g1,g2,g3,std.student)

                studentDetailViewModel.doUpdateGrades(detail)

                navController.navigate(studentDetailFragmentDirections.actionStudentDetailFragmentToStudentFragment(std.objClass))
            }

        }
    }

}