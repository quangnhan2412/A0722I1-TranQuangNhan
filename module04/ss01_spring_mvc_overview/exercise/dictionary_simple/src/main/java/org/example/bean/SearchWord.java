package org.example.bean;

public class SearchWord {
    private String search;
    private String result;

    public SearchWord(String search, String result) {
        this.search = search;
        this.result = result;
    }

    public SearchWord() {
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
