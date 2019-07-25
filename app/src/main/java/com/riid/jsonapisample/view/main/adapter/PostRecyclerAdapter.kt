package com.riid.jsonapisample.view.main.adapter

import android.view.ViewGroup
import com.cob.riid.jsonapisample.R
import com.riid.jsonapisample.base.adapter.BaseRecyclerViewAdapter
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.data.Post
import com.riid.jsonapisample.view.main.adapter.viewmodel.MainAdapterViewModel
import kotlinx.android.synthetic.main.item_post.*

class PostRecyclerAdapter :
        BaseRecyclerViewAdapter<MainAdapterViewModel>(::MainAdapterViewModel) {

    override fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder<*, MainAdapterViewModel> =
            PostViewHolder(parent)
}


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