package com.riid.jsonapisample.view.edit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import com.cob.riid.jsonapisample.R
import com.riid.jsonapisample.POST_ID
import com.riid.jsonapisample.POST_TITLE
import com.riid.jsonapisample.data.source.post.PostsDataRepository
import com.riid.jsonapisample.data.source.post.PostsDataSource
import com.riid.jsonapisample.data.source.post.PostsRemoteDataSource
import com.riid.jsonapisample.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        text_title.text = Editable.Factory.getInstance().newEditable(intent.getStringExtra(POST_TITLE))

        updateButton.setOnClickListener(View.OnClickListener {

            PostsDataRepository.editPost(intent.getLongExtra(POST_ID, 0), text_title.text.toString()).also {
                finish()
            }
        })
    }
}
