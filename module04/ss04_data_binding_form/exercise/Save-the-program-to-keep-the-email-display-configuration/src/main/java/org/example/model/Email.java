package org.example.model;

public class Email {
    private int idMail;
    private String language;
    private Integer pageSize;
    private boolean spamFilter;
    private String signature;

    public Email() {
    }

    public Email(int idMail, String language, Integer pageSize, boolean spamFilter, String signature) {
        this.idMail = idMail;
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public int getIdMail() {
        return idMail;
    }

    public void setIdMail(int idMail) {
        this.idMail = idMail;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
