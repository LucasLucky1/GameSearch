package org.example.br.com.lucaslucky1.gamesearch.main


import com.google.gson.Gson
import org.example.br.com.lucaslucky1.gamesearch.modelo.CheapestPriceJogo
import org.example.br.com.lucaslucky1.gamesearch.modelo.InfoJogo
import org.example.br.com.lucaslucky1.gamesearch.modelo.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um numero de jogo para procurar: ex:'123'")
    val numeroJogo = leitura.nextLine()

    val client: HttpClient = HttpClient.newHttpClient()
    val request: HttpRequest = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$numeroJogo"))
        .build()

    val response = client
         .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()
    val gson = Gson()
    println(json)

    val tentaRodar =runCatching {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        val meuPrecoJogo = gson.fromJson(json, CheapestPriceJogo::class.java)
        val meuJogo = Jogo(meuInfoJogo.info.title,meuInfoJogo.info.steamAppID,meuPrecoJogo.cheapestPriceEver.price)
        println(meuJogo)
    }

    tentaRodar.onFailure {
        println("Tente outro jogo")
    }












}