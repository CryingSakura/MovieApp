/*
package com.example.movieapp_try1.network.model

import androidx.paging.PagingSource
import androidx.paging.PagingSource.LoadResult.*
import androidx.paging.PagingState
import com.example.movieapp_try1.data.model.PopularMovieList
import com.example.movieapp_try1.data.model.Result
import com.example.movieapp_try1.network.ReqRep
import com.example.movieapp_try1.network.services.RequestService
import com.example.movieapp_try1.network.services.RequestService.Companion.BASE_URL
import retrofit2.HttpException

class MoviePageSource(
    private val requestService: RequestService
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        val anchorPosition =  state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        if (BASE_URL.isEmpty()){
            return Page(emptyList(), prevKey = null, nextKey = null)
        }

        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize

        val response = requestService.getMovieList(RequestService.API, page)
        val results = checkNotNull(response.results)
        val nextKey = if(results.size < pageSize) null else page + 1
        val prevKey = if(page == 1) null else page - 1
        return Page(results, prevKey, nextKey)

    }

}
*/
