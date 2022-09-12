package com.dummy.search.dataManager

import com.dummy.search.localSource.lesson.LessonLocalSource
import com.dummy.search.localSource.test.TestLocalSource
import com.dummy.search.model.Lesson
import com.dummy.search.model.Test

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
class SearchRepositoryImpl(
    private var lessonLocalSource: LessonLocalSource,
    private var testLocalSource: TestLocalSource
) : SearchRepository {

    override fun getTestSearchedData(searchQuery: String): ArrayList<Test> {
        return testLocalSource.getSearchedData(searchQuery)
    }

    override fun getLessonSearchedData(searchQuery: String): ArrayList<Lesson> {
        return lessonLocalSource.getSearchedData(searchQuery)
    }
}