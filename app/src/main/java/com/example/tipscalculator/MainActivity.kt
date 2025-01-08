package com.example.tipscalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val valorContaTemp = binding.tieValorConta.text
            val numPessoasTemp = binding.tieNumPessoas.text
            val porcentagemTemp = binding.tiePorcentagem.text

            if (valorContaTemp?.isEmpty() == true ||
                numPessoasTemp?.isEmpty() == true ||
                porcentagemTemp?.isEmpty() == true
                ){
                Snackbar
                    .make(
                        binding.tieValorConta,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            }else{
                val valorConta: Float = valorContaTemp.toString().toFloat()
                val numPessoas: Int = numPessoasTemp.toString().toInt()
                val porcentagem: Int = porcentagemTemp.toString().toInt()

                val totalMesa =  valorConta / numPessoas
                val tip = totalMesa * porcentagem / 100
                val totalComTip = totalMesa + tip

                val intent = Intent(this, ResultadoActivity::class.java)
                .apply {
                    putExtra("KEY_TOTAL_MESA", totalMesa)
                    putExtra("KEY_NUM_PESSOAS", numPessoas)
                    putExtra("KEY_PORCENTAGEM", porcentagem)
                    putExtra("KEY_TOTAL", totalComTip)
                }
                limpar ()
                startActivity(intent)
            }
        }
        binding.btnLimpar.setOnClickListener {
            limpar()
        }
    }
    private fun limpar(){
        binding.tieValorConta.setText("")
        binding.tieNumPessoas.setText("")
        binding.tiePorcentagem.setText("")
    }
}