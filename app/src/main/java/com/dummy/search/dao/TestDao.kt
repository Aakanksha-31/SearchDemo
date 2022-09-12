package com.dummy.search.dao

import androidx.room.Query
import com.dummy.search.model.Test

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
interface TestDao {
    @Query("SELECT * FROM `table_test` WHERE title LIKE '%'||:searchQuery||'%'")
    fun getSearchedTest(searchQuery: String): ArrayList<Test>
}