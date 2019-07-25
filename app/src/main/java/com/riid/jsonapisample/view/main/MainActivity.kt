package com.riid.jsonapisample.view.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.cob.riid.jsonapisample.R
import com.cob.riid.jsonapisample.util.createDialog
import com.cob.riid.jsonapisample.util.inject
import kotlinx.android.synthetic.main.activity_main.*
import com.riid.jsonapisample.POST_ID
import com.riid.jsonapisample.data.source.post.PostsDataRepository
import com.riid.jsonapisample.view.detail.DetailActivity
import com.riid.jsonapisample.view.main.adapter.PostRecyclerAdapter
import com.riid.jsonapisample.view.main.adapter.viewmodel.MainAdapterViewModel
import com.riid.jsonapisample.view.main.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {

    private val postRecyclerAdapter: PostRecyclerAdapter by lazy {
        PostRecyclerAdapter()
    }

    private val postsViewModel: PostsViewModel by lazy {
        PostsViewModel(PostsDataRepository, postRecyclerAdapter.viewModel).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        postsViewModel.init()
        postRecyclerAdapter.viewModel.init()

        postsViewModel.loadPosts()
    }

    private fun initView() {
        recycler_view.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postRecyclerAdapter

            addOnScrollListener(scrollListener)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        recycler_view?.removeOnScrollListener(scrollListener)
    }

    private fun PostsViewModel.init() {
        showProgress = {
            group_progress.visibility = View.VISIBLE
        }
        hideProgress = {
            group_progress.visibility = View.GONE
        }

    }

    private fun MainAdapterViewModel.init() {
        showDetailPage = { postId ->
            startActivity(Intent(this@MainActivity, DetailActivity::class.java).apply {
                putExtra(POST_ID, postId)
            })
        }

        showOptionPopup = { adapterPosition, postTitle ->
            createDialog(
                    title = getString(R.string.label_post_delete),
                    message = getString(R.string.message_item_remove, postTitle),
                    positiveButtonListener = { _, _ ->
                        postsViewModel.deleteItem(adapterPosition)
                    }).show()
        }
    }

    private val scrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            if (isFinishing) return

            val visibleItemCount = recyclerView.childCount
            val totalItemCount = postRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? LinearLayoutManager)?.findFirstVisibleItemPosition()
                    ?: 0

            if (group_progress.visibility != View.VISIBLE && (firstVisibleItem + visibleItemCount) >= totalItemCount - 5) {
                postsViewModel.loadPosts()
            }
        }
    }
}
