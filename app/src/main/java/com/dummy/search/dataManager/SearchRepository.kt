package com.dummy.search.dataManager

import com.dummy.search.model.Lesson
import com.dummy.search.model.Test

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
interface SearchRepository {
    fun getTestSearchedData(searchQuery: String): ArrayList<Test>
    fun getLessonSearchedData(searchQuery: String): ArrayList<Lesson>
}