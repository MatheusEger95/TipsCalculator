package com.example.tipscalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator.databinding.ActivityResultadoBinding

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalMesa = intent.getFloatExtra("KEY_TOTAL_MESA", 0.0f)
        val numPessoas = intent.getIntExtra("KEY_NUM_PESSOAS", 0)
        val porcentagem = intent.getIntExtra("KEY_PORCENTAGEM", 0)
        val totalComTip = intent.getFloatExtra("KEY_TOTAL", 0.0f)

        binding.tvValor2.text = totalMesa.toString()
        binding.tvNumPessoas2.text = numPessoas.toString()
        binding.tvPorcentagem2.text = porcentagem.toString() + "%"
        binding.tvResultado.text = totalComTip.toString()


        binding.btnAtualizar.setOnClickListener {
            finish()
        }
    }
}