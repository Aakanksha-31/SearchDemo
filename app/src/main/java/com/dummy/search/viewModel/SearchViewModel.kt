package com.dummy.search.viewModel

import com.dummy.search.domain.SearchUseCase
import com.dummy.search.model.Search

/**
 * Created by Aakanksha on 02/08/22.
 * aakanksha.verma@dailyrounds.org
 */
class SearchViewModel(private var useCase : SearchUseCase) {
    private var searchedQuery: String = ""

    var searchResult: MutableList<Search> = mutableListOf()

    fun getSearchResults(searchQuery: String) {
        searchedQuery = searchQuery
        /**
         * coroutine scope, parallel db calls
         */

        searchResult = useCase.getSearchedData(searchQuery)
        searchResult.sortWith(comparator)
    }

    private var comparator = object : Comparator<Search> {
        override fun compare(p0: Search?, p1: Search?): Int {
            /**
             * Case 1: Starting word = P0
             * Case 2: Exact match in between = P1
             * Case 3: Starting partial word = P2
             * Case 4: Partial word in between = P3
             */
            val split1 = p0?.title?.split(" ")
            val split2 = p1?.title?.split(" ")
            if (split1!![0] == searchedQuery && split2!![0] == searchedQuery) {
                return 0
            } else if (split1[0] == searchedQuery) {
                return 1
            } else if (split2!![0] == searchedQuery) {
                return -1
            } else if (split1.contains(searchedQuery) >= split2.contains(searchedQuery)) {
                return 1
            } else if (split1.contains(searchedQuery) < split2.contains(searchedQuery)) {
                return -1
            } else if (p0.title.indexOf(searchedQuery, 0, true) == 0 && p1.title.indexOf(
                    searchedQuery,
                    0,
                    true
                ) == 0
            ) {
                return 0
            } else if (p0.title.indexOf(searchedQuery, 0, true) == 0) {
                return 1
            } else if (p1.title.indexOf(searchedQuery, 0, true) == 0) {
                return -1
            } else if (p0.title.contains(searchedQuery) && p0.title.contains(searchedQuery)) {
                return 0
            } else if (p0.title.contains(searchedQuery)) {
                return 0
            } else {
                return -1
            }
        }
    }
}