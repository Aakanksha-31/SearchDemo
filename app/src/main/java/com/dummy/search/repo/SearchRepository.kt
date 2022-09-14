package com.dummy.search.repo

import com.dummy.search.model.Lesson
import com.dummy.search.model.Test

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
interface SearchRepository {
    /**
     * In case we are getting data from multiple tables, making separate repositories (LessonRepository & TestRepository) would make more sense.
     * Making single SearchRepository is beneficial when data is coming from single source
     */
    fun getTestSearchedData(searchQuery: String): ArrayList<Test>
    fun getLessonSearchedData(searchQuery: String): ArrayList<Lesson>
}