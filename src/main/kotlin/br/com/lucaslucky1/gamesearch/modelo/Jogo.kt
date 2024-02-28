package org.example.br.com.lucaslucky1.gamesearch.modelo

import com.google.gson.annotations.SerializedName

data class Jogo( val titulo:String, val idSteam:String,val preco:String){
    override fun toString(): String {
        return "Jogo: " +
                "\n  Titulo: '$titulo'," +
                "\n  ID Steam: '$idSteam'"+
                "\n  Preço: $$preco"
    }
}
