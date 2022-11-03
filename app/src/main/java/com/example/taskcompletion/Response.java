package com.example.taskcompletion;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("count")
	private int count;

	@SerializedName("totalPages")
	private int totalPages;

	@SerializedName("lastItemIndex")
	private int lastItemIndex;

	@SerializedName("page")
	private int page;

	@SerializedName("totalCount")
	private int totalCount;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setLastItemIndex(int lastItemIndex){
		this.lastItemIndex = lastItemIndex;
	}

	public int getLastItemIndex(){
		return lastItemIndex;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"count = '" + count + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			",lastItemIndex = '" + lastItemIndex + '\'' + 
			",page = '" + page + '\'' + 
			",totalCount = '" + totalCount + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}