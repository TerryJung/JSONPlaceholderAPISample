package com.riid.jsonapisample.view.detail.adapter.holder

import android.view.ViewGroup
import com.cob.riid.jsonapisample.R
import kotlinx.android.synthetic.main.item_detail_comment.*
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.data.Comment
import com.riid.jsonapisample.view.detail.adapter.viewmodel.DetailAdapterViewModel

class CommentViewHolder(parent: ViewGroup) :
        BaseViewHolder<Comment, DetailAdapterViewModel>(R.layout.item_detail_comment, parent) {

    override fun DetailAdapterViewModel.onInitViewModel() {

    }

    override fun onBindViewHolder(item: Comment?) {
        tv_user_name.text = item?.name
        tv_comment.text = item?.body
    }
}