package com.unaerp.mobileparcial.model

import android.content.Context
import com.unaerp.mobileparcial.R
import java.text.NumberFormat
import java.util.Locale

data class Exercicio(
    val id: Int,
    val nome: String,
    val grupo: GrupoMuscular,
    val series: Int,
    val repeticoes: Int,
    val cargaKg: Double?,
    val observacao: String?
)

fun Exercicio.cargaFormatada(context: Context): String {
    val carga = cargaKg ?: return context.getString(R.string.peso_corporal)
    val formato = NumberFormat.getNumberInstance(Locale.forLanguageTag("pt-BR")).apply {
        maximumFractionDigits = 1
        isGroupingUsed = false
    }
    return context.getString(R.string.carga_kg, formato.format(carga))
}
