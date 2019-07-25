package com.riid.jsonapisample.network

import com.cob.riid.jsonapisample.util.createRetrofit


object RetrofitFactory {

    private const val APIURL = "https://jsonplaceholder.typicode.com"

    val api: JsonPlaceHolderInterface by lazy {
        createRetrofit(JsonPlaceHolderInterface::class.java, APIURL)
    }
}