package com.riid.jsonapisample.data.source.post

import io.reactivex.Flowable
import com.riid.jsonapisample.data.Comment
import com.riid.jsonapisample.data.Post

interface PostsDataSource {

    var isLast: Boolean

    /**
     * Cache item size
     */
    val cacheSize: Int

    /**
     * get posts using pagination
     */
    fun getPosts(start: Int, limit: Int): Flowable<List<Post>>

    /**
     * get posts detail.
     */
    fun getPostById(id: Long): Flowable<Post>

    /**
     * get comments of a post
     */
    fun getPostComments(id: Long): Flowable<List<Comment>>

    /**
     * delete post
     */
    fun postDelete(id: Long): Flowable<Boolean>

    fun editPost(id: Long, title: String)
    /**
     * All data release
     */
    fun release()
}