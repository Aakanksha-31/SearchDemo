package com.dummy.search.localSource.lesson

import com.dummy.search.model.Lesson
import com.dummy.search.dao.LessonDao

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
class LessonLocalSourceImpl: LessonLocalSource {
    private lateinit var lessonDao : LessonDao
    override fun getSearchedData(searchQuery: String): ArrayList<Lesson> {
        return  lessonDao.getSearchedLesson(searchQuery)
    }
}