package com.riid.jsonapisample.network

import io.reactivex.Flowable
import com.riid.jsonapisample.data.Comment
import com.riid.jsonapisample.data.Post
import retrofit2.http.*

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

    @FormUrlEncoded
    @Headers("Content-Type: application/json; charset=utf-8")
    @PATCH("/posts/{id}")
    fun editPost(
            @Path("id") id: Long,
            @Field("title") title: String) : Flowable<Any>
}