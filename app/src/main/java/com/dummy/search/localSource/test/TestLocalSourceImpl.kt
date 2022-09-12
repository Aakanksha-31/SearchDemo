package com.dummy.search.localSource.test

import com.dummy.search.dao.TestDao
import com.dummy.search.model.Test

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
class TestLocalSourceImpl: TestLocalSource {
    private lateinit var testDao : TestDao
    override fun getSearchedData(searchQuery: String): ArrayList<Test> {
        return testDao.getSearchedTest(searchQuery)
    }
}