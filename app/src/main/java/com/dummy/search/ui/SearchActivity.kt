package com.dummy.search.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageButton
import com.dummy.search.R
import com.dummy.search.repo.SearchRepositoryImpl
import com.dummy.search.domain.SearchUseCaseImpl
import com.dummy.search.localSource.lesson.LessonLocalSourceImpl
import com.dummy.search.localSource.test.TestLocalSourceImpl
import com.dummy.search.model.Search
import com.dummy.search.viewModel.SearchViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    //explicit variables for local sources, repo and use case would be removed once DI is implemented
    private var viewModel = SearchViewModel(
        SearchUseCaseImpl(
            SearchRepositoryImpl(
                LessonLocalSourceImpl(),
                TestLocalSourceImpl()
            )
        )
    )

    private lateinit var etSearchInput: EditText
    private lateinit var searchIcon: AppCompatImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        listener()
        observer()
    }

    private fun observer() {
        //stop loader on success and error
        //observe and set adapter
        viewModel.searchResult.observe(this, { response ->
            processResponse(response)
        })
    }

    private fun processResponse(response: ArrayList<Search>) {
        setAdapter(response)
    }

    private fun setAdapter(searchResult: MutableList<Search>) {
        //TODO
    }

    private fun listener() {
        searchIcon.setOnClickListener {
            if(etSearchInput.text.isNotEmpty()) {
                viewModel.getSearchResults(etSearchInput.text.toString())
            }
        }
    }

    private fun init() {
        etSearchInput = findViewById(R.id.etSearchInput)
        searchIcon = findViewById(R.id.searchIcon)
    }
}