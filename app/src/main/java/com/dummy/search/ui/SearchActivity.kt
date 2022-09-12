package com.dummy.search.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageButton
import com.dummy.search.R
import com.dummy.search.dataManager.SearchRepositoryImpl
import com.dummy.search.domain.SearchUseCaseImpl
import com.dummy.search.localSource.lesson.LessonLocalSourceImpl
import com.dummy.search.localSource.test.TestLocalSourceImpl
import com.dummy.search.model.Search
import com.dummy.search.viewModel.SearchViewModel

class MainActivity : AppCompatActivity() {
    //explicit variables for local sources, repo and use case would be removed once DI is implemented
    private val testLocalSource = TestLocalSourceImpl()
    private val lessonLocalSource = LessonLocalSourceImpl()
    private val repo = SearchRepositoryImpl(lessonLocalSource, testLocalSource)
    private val useCase = SearchUseCaseImpl(repo)
    private var viewModel = SearchViewModel(useCase)
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
        setAdapter(viewModel.searchResult)
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