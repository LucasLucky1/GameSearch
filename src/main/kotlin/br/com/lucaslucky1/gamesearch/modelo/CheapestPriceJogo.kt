package org.example.br.com.lucaslucky1.gamesearch.modelo

data class CheapestPriceJogo(val cheapestPriceEver: ChapestPriceApiShark){
    override fun toString(): String {
        return cheapestPriceEver.toString()
    }
}
