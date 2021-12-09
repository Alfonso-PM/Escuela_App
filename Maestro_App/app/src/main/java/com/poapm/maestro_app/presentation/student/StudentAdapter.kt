package com.poapm.maestro_app.presentation.student

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poapm.maestro_app.core.extension.loadFromURLCircular
import com.poapm.maestro_app.databinding.RowStudentBinding
import com.poapm.maestro_app.domain.model.DetailClass

@SuppressLint("NotifyDataSetChanged")
class StudentAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<DetailClass> = mutableListOf()

    lateinit var listener: (detail: DetailClass) -> Unit


    fun addData(list: List<DetailClass>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        RowStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)  =
        (holder as BaseViewHolder).bind(
            list[position], listener
        )

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RowStudentBinding) : BaseViewHolder(binding.root) {

        override fun bind(data: DetailClass, listener: (cls: DetailClass) -> Unit) {
            binding.detail = data

            binding.imgStd.loadFromURLCircular(data.student.urlStudent)

            binding.root.setOnClickListener {
                listener(data)
            }
        }
    }

    abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        abstract fun bind(data: DetailClass, listener: (cls: DetailClass) -> Unit)

    }

}