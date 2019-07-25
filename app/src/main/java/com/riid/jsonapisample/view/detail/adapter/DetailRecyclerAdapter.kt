package com.riid.jsonapisample.view.detail.adapter

import android.content.res.Resources
import android.view.ViewGroup
import com.cob.riid.jsonapisample.R
import com.riid.jsonapisample.base.adapter.BaseRecyclerViewAdapter
import com.riid.jsonapisample.base.adapter.holder.BaseViewHolder
import com.riid.jsonapisample.data.Comment
import com.riid.jsonapisample.data.Post
import com.riid.jsonapisample.view.detail.adapter.viewmodel.DetailAdapterViewModel
import kotlinx.android.synthetic.main.item_detail_comment.*
import kotlinx.android.synthetic.main.item_detail_content.*
import kotlinx.android.synthetic.main.item_detail_section.*

class DetailRecyclerAdapter : BaseRecyclerViewAdapter<DetailAdapterViewModel>(::DetailAdapterViewModel) {

    override fun createViewHolder(viewType: Int, parent: ViewGroup): BaseViewHolder<*, DetailAdapterViewModel> =
            when (viewType) {
                DetailAdapterViewModel.VIEW_TYPE_SECTION -> SectionViewHolder(parent)
                DetailAdapterViewModel.VIEW_TYPE_CONTENT -> ContentViewHolder(parent)
                DetailAdapterViewModel.VIEW_TYPE_COMMENT -> CommentViewHolder(parent)
                else -> throw Resources.NotFoundException("ViewType error")
            }

    class CommentViewHolder(parent: ViewGroup) :
            BaseViewHolder<Comment, DetailAdapterViewModel>(R.layout.item_detail_comment, parent) {

        override fun DetailAdapterViewModel.onInitViewModel() {

        }

        override fun onBindViewHolder(item: Comment?) {
            tv_user_name.text = item?.name
            tv_comment.text = item?.body
        }
    }

    class ContentViewHolder(parent: ViewGroup) :
            BaseViewHolder<Post, DetailAdapterViewModel>(R.layout.item_detail_content, parent) {

        override fun DetailAdapterViewModel.onInitViewModel() {
            containerView.setOnLongClickListener {
                onLongClickItem(adapterPosition)
            }
        }

        override fun onBindViewHolder(item: Post?) {
            tv_body.text = item?.body
        }
    }

    class SectionViewHolder(parent: ViewGroup) :
            BaseViewHolder<String, DetailAdapterViewModel>(R.layout.item_detail_section, parent) {

        override fun DetailAdapterViewModel.onInitViewModel() {

        }

        override fun onBindViewHolder(item: String?) {
            tv_title.text = item
        }
    }
}

