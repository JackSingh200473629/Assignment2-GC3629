package com.example.assignment2gc3629;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    private Book[] results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public Book[] getResults() {
        return results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
