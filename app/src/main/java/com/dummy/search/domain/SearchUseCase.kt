package com.dummy.search.domain

import com.dummy.search.model.Search

/**
 * Created by Aakanksha on 13/09/22.
 * aakanksha.verma@dailyrounds.org
 */
interface SearchUseCase {
    fun getSearchedData(searchQuery : String) : ArrayList<Search>
}