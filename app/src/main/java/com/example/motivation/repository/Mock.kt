package com.example.motivation.repository

import com.example.motivation.infra.MotivationContants
import java.util.*


data class Phrase(val description: String, val category : Int)

class Mock {

    private val INFINITY = MotivationContants.PHRASEFILTER.INFINITY
    private val HAPPY = MotivationContants.PHRASEFILTER.HAPPY
    private val SUNN = MotivationContants.PHRASEFILTER.SUNN

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUNN),
        Phrase("Você perde todas as chances que você não aproveita.", SUNN),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUNN),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUNN),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUNN),
        Phrase("Se você acredita, faz toda a diferença.", SUNN),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUNN)
    )

    /**
     * Obtém frase aleatória de acordo com o filtro
     * */
    fun getPhrase(value: Int): String {



        val filtered = mListPhrases.filter { (it.category == value || value == INFINITY) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random().nextInt(filtered.size)


        // Retorna string
        return filtered[rand].description

    }

}