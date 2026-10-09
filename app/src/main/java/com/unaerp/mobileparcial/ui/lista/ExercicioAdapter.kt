package com.unaerp.mobileparcial.ui.lista

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.unaerp.mobileparcial.R
import com.unaerp.mobileparcial.databinding.ItemExercicioBinding
import com.unaerp.mobileparcial.model.Exercicio
import com.unaerp.mobileparcial.model.cargaFormatada

class ExercicioAdapter(
    private val exercicios: List<Exercicio>,
    private val onItemClick: (Exercicio) -> Unit
) : RecyclerView.Adapter<ExercicioAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemExercicioBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemExercicioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val exercicio = exercicios[position]
        val context = holder.itemView.context
        with(holder.binding) {
            tvNome.text = exercicio.nome
            tvGrupo.text = exercicio.grupo.rotulo
            tvResumo.text = context.getString(
                R.string.resumo_exercicio,
                exercicio.series,
                exercicio.repeticoes,
                exercicio.cargaFormatada(context)
            )
            ivIcone.imageTintList =
                ColorStateList.valueOf(ContextCompat.getColor(context, exercicio.grupo.corRes))
            root.setOnClickListener { onItemClick(exercicio) }
        }
    }

    override fun getItemCount(): Int =exercicios.size
}
