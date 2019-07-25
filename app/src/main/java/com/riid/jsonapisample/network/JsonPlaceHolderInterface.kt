package com.riid.jsonapisample.network

import io.reactivex.Flowable
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.riid.jsonapisample.data.Comment
import com.riid.jsonapisample.data.Post

interface JsonPlaceHolderInterface {

    @GET("/posts/")
    fun getPosts(@Query("_start") start: Int,
                 @Query("_limit") limit: Int): Flowable<List<Post>>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: Long): Flowable<Post>

    @GET("/posts/{id}/comments")
    fun getPostComments(@Path("id") id: Long): Flowable<List<Comment>>

    @DELETE("/posts/{id}")
    fun deletePosts(@Path("id") id: Long): Flowable<Any>
}