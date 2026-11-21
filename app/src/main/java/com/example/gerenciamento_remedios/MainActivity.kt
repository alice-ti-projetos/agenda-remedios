// pacote atual
package com.example.gerenciamento_remedios

//importamento de pacotes/bibliotecas
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

//atividade principal
class MainActivity : AppCompatActivity() {
    // funcao do que o android vai fazer qnd o app for aberto, este cria a atividade
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.act_btn_add_med).setOnClickListener {
            AddMedDialogFragment().show(supportFragmentManager, AddMedDialogFragment.TAG)
        }
    }
}