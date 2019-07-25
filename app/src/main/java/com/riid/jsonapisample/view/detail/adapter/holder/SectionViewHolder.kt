package com.riid.jsonapisample.view.detail.adapter.holder

import android.view.ViewGroup
import com.cob.riid.jsonapisample.R
import kotlinx.android.synthetic.main.item_detail_section.*
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.view.detail.adapter.viewmodel.DetailAdapterViewModel

class SectionViewHolder(parent: ViewGroup) :
        BaseViewHolder<String, DetailAdapterViewModel>(R.layout.item_detail_section, parent) {

    override fun DetailAdapterViewModel.onInitViewModel() {

    }

    override fun onBindViewHolder(item: String?) {
        tv_title.text = item
    }
}