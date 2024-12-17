package com.pockemon.api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class ReviewDTO {
    private int id;
    private String title;
    private String content;
    private int starts;

    public ReviewDTO(int id, String content, String title, int starts) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.starts = starts;
    }

    public ReviewDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStarts() {
        return starts;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
