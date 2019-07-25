package com.riid.jsonapisample.view.detail.adapter.viewmodel

import com.riid.jsonapisample.base.adapter.data.source.AdapterRepositoryInterface
import com.riid.jsonapisample.base.adapter.viewmodel.BaseAdapterViewModel
import com.riid.jsonapisample.data.Post

class DetailAdapterViewModel(adapterDataSource: AdapterRepositoryInterface) : BaseAdapterViewModel(adapterDataSource) {

    companion object {
        const val VIEW_TYPE_SECTION = 0
        const val VIEW_TYPE_CONTENT = 1000
        const val VIEW_TYPE_COMMENT = 2000
    }
    lateinit var showEditPage: (adapterPosition: Int, postId: Long, postTitle: String) -> Unit


    fun onLongClickItem(adapterPosition: Int): Boolean =
            adapterDataSource.getItem<Post>(adapterPosition)?.let {
                showEditPage(adapterPosition, it.id, it.title)
                false
            } ?: true

}