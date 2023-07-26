package com.example.assignment2gc3629;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("page_count")
    private String pageCount;
    private String title;
    private String[] authors;
    private String[] categories;
    private String language;
    private String summary;

    public String getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String[] getCategories() {
        return categories;
    }

    public String getLanguage() {
        return language;
    }

    public String getSummary() {
        return summary;
    }
}
