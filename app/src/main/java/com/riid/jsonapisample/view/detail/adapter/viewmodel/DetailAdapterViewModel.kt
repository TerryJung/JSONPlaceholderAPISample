package com.riid.jsonapisample.view.detail.adapter.viewmodel

import com.riid.jsonapisample.base.adapter.data.source.AdapterRepositoryInterface
import com.riid.jsonapisample.base.adapter.viewmodel.BaseAdapterViewModel

class DetailAdapterViewModel(adapterDataSource: AdapterRepositoryInterface) : BaseAdapterViewModel(adapterDataSource) {

    companion object {
        const val VIEW_TYPE_SECTION = 0
        const val VIEW_TYPE_CONTENT = 1000
        const val VIEW_TYPE_COMMENT = 2000
    }
}