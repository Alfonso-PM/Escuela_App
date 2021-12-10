package com.poapm.alumno_app.presentation.materia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poapm.alumno_app.domain.model.Class
import androidx.recyclerview.widget.RecyclerView
import com.poapm.alumno_app.core.extension.loadFromURLCircular
import com.poapm.alumno_app.databinding.GidMateriaBinding
import com.poapm.alumno_app.domain.model.ClassDetail

class MateriaAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Class> = mutableListOf()
    lateinit var listener: (category: Class) -> Unit

    fun addData(list: List<Class>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        GidMateriaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)  =
        (holder as BaseViewHolder).bind(
            list[position], listener
        )

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: GidMateriaBinding) : BaseViewHolder(binding.root) {

        override fun bind(data: Class, listener: (cls: Class) -> Unit) {
            binding.classCls = data

            binding.imgMateria.loadFromURLCircular(data.pictureClass)

            binding.root.setOnClickListener {
                listener(data)
            }
        }
    }

    abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        abstract fun bind(data: Class, listener: (cls: Class) -> Unit)

    }

}