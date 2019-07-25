package com.riid.jsonapisample.view.main.adapter.holder

import android.view.ViewGroup
import com.cob.riid.jsonapisample.R
import kotlinx.android.synthetic.main.item_post.*
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.data.Post
import com.riid.jsonapisample.view.main.adapter.viewmodel.MainAdapterViewModel

class PostViewHolder(parent: ViewGroup) :
        BaseViewHolder<Post, MainAdapterViewModel>(R.layout.item_post, parent) {

    override fun MainAdapterViewModel.onInitViewModel() {
        containerView.setOnClickListener {
            onClickItem(adapterPosition)
        }

        containerView.setOnLongClickListener {
            onLongClickItem(adapterPosition)
        }
    }

    override fun onBindViewHolder(item: Post?) {
        tv_title.text = item?.title
        tv_body.text = item?.body
    }
}