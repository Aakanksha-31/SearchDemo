package com.dummy.search.domain

import com.dummy.search.dataManager.SearchRepository
import com.dummy.search.model.Lesson
import com.dummy.search.model.Search
import com.dummy.search.model.Test

/**
 * Created by Aakanksha on 13/09/22.
 * aakanksha.verma@dailyrounds.org
 */
class SearchUseCaseImpl(private var dataManager : SearchRepository) : SearchUseCase {

    override fun getSearchedData(searchQuery: String): ArrayList<Search> {
        val lessonList = /*async {*/ dataManager.getLessonSearchedData(searchQuery)/*}*/
        val testList = /*async {*/ dataManager.getTestSearchedData(searchQuery)/*}*/

        return getMergedData(lessonList, testList)
    }

    private fun getMergedData(
        lessonList: java.util.ArrayList<Lesson>,
        testList: java.util.ArrayList<Test>
    ): ArrayList<Search> {
        val mergedList = arrayListOf<Search>()
        mergedList.addAll(lessonList.map {
            Search(id = it.id, title = it.title, type = it.type)
        })
        mergedList.addAll(testList.map {
            Search(id = it.id, title = it.title)
        })
        return mergedList
    }
}