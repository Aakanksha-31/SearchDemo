package com.dummy.search.localSource.test

import com.dummy.search.model.Test

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
interface TestLocalSource {
    fun getSearchedData(searchQuery: String): ArrayList<Test>
}