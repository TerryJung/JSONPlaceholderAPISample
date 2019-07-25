package com.riid.jsonapisample.data

data class Comment(
        val postId: Long,
        val id: Int,
        val name: String,
        val email: String,
        val body: String)