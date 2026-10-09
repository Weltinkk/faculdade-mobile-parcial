package com.unaerp.mobileparcial.ui.detalhe

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.unaerp.mobileparcial.R
import com.unaerp.mobileparcial.data.MockData
import com.unaerp.mobileparcial.databinding.FragmentDetalheBinding
import com.unaerp.mobileparcial.databinding.ViewInfoCardBinding
import com.unaerp.mobileparcial.model.cargaFormatada

class DetalheFragment : Fragment() {

    private var _binding: FragmentDetalheBinding? = null
    private val binding get() = checkNotNull(_binding)

    private var cardSeries: ViewInfoCardBinding? = null
    private var totalSeries = 0
    private var seriesConcluidas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        seriesConcluidas = savedInstanceState?.getInt(STATE_SERIES_CONCLUIDAS) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalheBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(ARG_EXERCICIO_ID, -1) ?: -1
        val exercicio = MockData.buscarPorId(id)
        if (exercicio == null) {
            Toast.makeText(requireContext(), R.string.erro_exercicio_nao_encontrado, Toast.LENGTH_LONG).show()
            requireActivity().finish()
            return
        }

        totalSeries = exercicio.series

        binding.ivIcone.imageTintList = ColorStateList.valueOf(
            ContextCompat.getColor(requireContext(), exercicio.grupo.corRes)
        )
        binding.tvNome.text = exercicio.nome
        binding.tvGrupo.text = exercicio.grupo.rotulo
        binding.tvObservacao.text = exercicio.observacao
        binding.tvObservacao.isVisible = exercicio.observacao != null

        val inflater = LayoutInflater.from(requireContext())
        val container = binding.llCards

        val series = ViewInfoCardBinding.inflate(inflater, container, false)
        series.tvRotulo.setText(R.string.rotulo_series)
        cardSeries = series

        val repeticoes = ViewInfoCardBinding.inflate(inflater, container, false)
        repeticoes.tvRotulo.setText(R.string.rotulo_repeticoes)
        repeticoes.tvValor.text = exercicio.repeticoes.toString()

        val carga = ViewInfoCardBinding.inflate(inflater, container, false)
        carga.tvRotulo.setText(R.string.rotulo_carga)
        carga.tvValor.text = exercicio.cargaFormatada(requireContext())

        container.addView(series.root)
        container.addView(criarEspaco())
        container.addView(repeticoes.root)
        container.addView(criarEspaco())
        container.addView(carga.root)

        binding.btnConcluirSerie.setOnClickListener {
            seriesConcluidas++
            atualizarProgresso()
        }
        atualizarProgresso()
    }

    private fun criarEspaco() = Space(requireContext()).apply {
        layoutParams = ViewGroup.LayoutParams(
            resources.getDimensionPixelSize(R.dimen.espaco_cards),
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun atualizarProgresso() {
        cardSeries?.tvValor?.text = getString(R.string.progresso_series, seriesConcluidas, totalSeries)
        val concluido = seriesConcluidas >= totalSeries
        binding.btnConcluirSerie.isEnabled = !concluido
        binding.btnConcluirSerie.setText(
            if (concluido) R.string.exercicio_concluido else R.string.concluir_serie
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_SERIES_CONCLUIDAS, seriesConcluidas)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cardSeries = null
        _binding = null
    }

    companion object {
        private const val ARG_EXERCICIO_ID = "ARG_EXERCICIO_ID"
        private const val STATE_SERIES_CONCLUIDAS = "STATE_SERIES_CONCLUIDAS"

        fun newInstance(exercicioId: Int): DetalheFragment = DetalheFragment().apply {
            arguments = Bundle().apply { putInt(ARG_EXERCICIO_ID, exercicioId) }
        }
    }
}
