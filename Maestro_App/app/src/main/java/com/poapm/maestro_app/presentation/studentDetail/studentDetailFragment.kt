package com.poapm.maestro_app.presentation.studentDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poapm.maestro_app.R

class studentDetailFragment : Fragment() {

    companion object {
        fun newInstance() = studentDetailFragment()
    }

    private lateinit var viewModel: StudentDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.student_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StudentDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}