package com.riid.jsonapisample.base.adapter.viewmodel

import com.riid.jsonapisample.base.adapter.data.source.AdapterRepositoryInterface

@Suppress("UNCHECKED_CAST")
abstract class BaseAdapterViewModel(val adapterDataSource: AdapterRepositoryInterface) {

    lateinit var notifyDataSetChanged: () -> Unit

    lateinit var notifyItemChanged: (position: Int) -> Unit

    lateinit var notifyItemRangeChanged: (position: Int, itemCount: Int) -> Unit

    lateinit var notifyItemInserted: (position: Int) -> Unit

    lateinit var notifyItemRangeInserted: (positionStart: Int, itemCount: Int) -> Unit

    lateinit var notifyItemRemoved: (position: Int) -> Unit

    lateinit var notifyItemRangeRemoved: (positionStart: Int, itemCount: Int) -> Unit
}