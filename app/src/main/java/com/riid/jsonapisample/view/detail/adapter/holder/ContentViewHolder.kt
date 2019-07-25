package com.riid.jsonapisample.view.detail.adapter.holder

import android.view.ViewGroup
import com.cob.riid.jsonapisample.R
import kotlinx.android.synthetic.main.item_detail_content.*
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.data.Post
import com.riid.jsonapisample.view.detail.adapter.viewmodel.DetailAdapterViewModel

class ContentViewHolder(parent: ViewGroup) :
        BaseViewHolder<Post, DetailAdapterViewModel>(R.layout.item_detail_content, parent) {

    override fun DetailAdapterViewModel.onInitViewModel() {

    }

    override fun onBindViewHolder(item: Post?) {
        tv_body.text = item?.body
    }
}