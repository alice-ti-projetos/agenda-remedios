// pacote atual
package com.example.gerenciamento_remedios

//importamento de pacotes/bibliotecas
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

//atividade principal
class MainActivity : AppCompatActivity() {
    // funcao do que o android vai fazer qnd o app for aberto, este cria a atividade
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
      //cria a atividade quando o app inicia
        super.onCreate(savedInstanceState, persistentState)
        // coloca o layout como o que vc passou
        setContentView(R.layout.activity_main)
    }
}