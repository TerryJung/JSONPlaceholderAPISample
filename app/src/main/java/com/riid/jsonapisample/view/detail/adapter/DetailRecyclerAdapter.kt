package com.riid.jsonapisample.view.detail.adapter

import android.content.res.Resources
import android.view.ViewGroup
import com.riid.jsonapisample.base.adapter.BaseRecyclerViewAdapter
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.view.detail.adapter.holder.CommentViewHolder
import com.riid.jsonapisample.view.detail.adapter.holder.ContentViewHolder
import com.riid.jsonapisample.view.detail.adapter.holder.SectionViewHolder
import com.riid.jsonapisample.view.detail.adapter.viewmodel.DetailAdapterViewModel

class DetailRecyclerAdapter : BaseRecyclerViewAdapter<DetailAdapterViewModel>(::DetailAdapterViewModel) {

    override fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder<*, DetailAdapterViewModel> =
            when (viewType) {
                DetailAdapterViewModel.VIEW_TYPE_SECTION -> SectionViewHolder(parent)
                DetailAdapterViewModel.VIEW_TYPE_CONTENT -> ContentViewHolder(parent)
                DetailAdapterViewModel.VIEW_TYPE_COMMENT -> CommentViewHolder(parent)
                else -> throw Resources.NotFoundException("ViewType error")
            }
}