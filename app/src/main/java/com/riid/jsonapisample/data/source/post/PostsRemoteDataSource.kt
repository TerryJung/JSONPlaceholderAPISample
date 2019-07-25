package com.riid.jsonapisample.data.source.post

import com.riid.jsonapisample.network.JsonPlaceHolderInterface
import com.riid.jsonapisample.network.RetrofitFactory

class PostsRemoteDataSource {

    private val api: JsonPlaceHolderInterface by lazy {
        RetrofitFactory.api
    }

    fun getPosts(start: Int, limit: Int) =
            api.getPosts(start, limit)

    fun getPost(id: Long) =
            api.getPostById(id)

    fun getPostComments(id: Long) =
            api.getPostComments(id)

    fun postDelete(id: Long) =
            api.deletePosts(id)

    fun editPost(id: Long, title: String) =
            api.editPost(id, title)
}