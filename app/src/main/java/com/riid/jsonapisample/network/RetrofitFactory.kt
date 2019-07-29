package com.riid.jsonapisample.network

import com.cob.riid.jsonapisample.util.createRetrofit


object RetrofitFactory {

    private const val API_URL = "https://jsonplaceholder.typicode.com"

    val api: JsonPlaceHolderInterface by lazy {
        createRetrofit(JsonPlaceHolderInterface::class.java, API_URL)
    }
}