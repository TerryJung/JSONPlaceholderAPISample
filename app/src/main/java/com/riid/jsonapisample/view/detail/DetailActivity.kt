package com.riid.jsonapisample.view.detail

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.cob.riid.jsonapisample.R
import com.cob.riid.jsonapisample.util.createDialog
import com.cob.riid.jsonapisample.util.inject
import kotlinx.android.synthetic.main.activity_detail.*
import com.riid.jsonapisample.POST_ID
import com.riid.jsonapisample.POST_TITLE
import com.riid.jsonapisample.data.source.post.PostsDataRepository
import com.riid.jsonapisample.view.detail.adapter.DetailRecyclerAdapter
import com.riid.jsonapisample.view.detail.adapter.viewmodel.DetailAdapterViewModel
import com.riid.jsonapisample.view.detail.viewmodel.DetailViewModel
import com.riid.jsonapisample.view.edit.EditActivity

class DetailActivity : AppCompatActivity() {


    private val detailRecyclerAdapter: DetailRecyclerAdapter by lazy {
        DetailRecyclerAdapter()
    }

    private val detailViewModel: DetailViewModel by lazy {
        DetailViewModel(application, PostsDataRepository, detailRecyclerAdapter.viewModel).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initView()
        detailRecyclerAdapter.viewModel.init()
        detailViewModel.run {
            init()
            loadDetail(intent?.getLongExtra(POST_ID, -1) ?: -1)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initView() {
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        recycler_view.run {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter = detailRecyclerAdapter
        }
    }

    private fun DetailViewModel.init() {
        showProgress = {
            progress.visibility = View.VISIBLE
        }

        hideProgress = {
            progress.visibility = View.GONE
        }


    }

    private fun DetailAdapterViewModel.init() {
        showEditPage = { adapterPosition, postId, title ->
            startActivity(Intent(this@DetailActivity, EditActivity::class.java).apply {
                putExtra(POST_ID, postId)
                putExtra(POST_TITLE, title)
            })
        }
    }
}