package com.dummy.search.localSource.lesson

import com.dummy.search.model.Lesson

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
interface LessonLocalSource {
    fun getSearchedData(searchQuery: String): ArrayList<Lesson>
}