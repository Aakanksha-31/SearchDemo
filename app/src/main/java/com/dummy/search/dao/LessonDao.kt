package com.dummy.search.dao

import androidx.room.Query
import com.dummy.search.model.Lesson

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
interface LessonDao {
    @Query("SELECT * FROM `table_lesson` WHERE title LIKE '%'||:searchQuery||'%'")
    fun getSearchedLesson(searchQuery: String): ArrayList<Lesson>
}