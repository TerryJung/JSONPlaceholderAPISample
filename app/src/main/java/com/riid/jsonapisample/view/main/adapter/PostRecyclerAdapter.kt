package com.riid.jsonapisample.view.main.adapter

import android.view.ViewGroup
import com.riid.jsonapisample.base.adapter.BaseRecyclerViewAdapter
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.view.main.adapter.holder.PostViewHolder
import com.riid.jsonapisample.view.main.adapter.viewmodel.MainAdapterViewModel

class PostRecyclerAdapter :
        BaseRecyclerViewAdapter<MainAdapterViewModel>(::MainAdapterViewModel) {

    override fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder<*, MainAdapterViewModel> =
            PostViewHolder(parent)
}