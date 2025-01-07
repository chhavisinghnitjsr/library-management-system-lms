package com.example.library.demo.entity;


import jakarta.persistence.*;

import java.util.Date;


@Entity
public class BookRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    private String title;
        private String author;
        private String description;

        private String language;

        private String added_by;
        private Date added_at;
        private Date updated_at;
        private String updated_by;

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public BookRequestEntity() {
    }

    public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getAddedBy() {
            return added_by;
        }

        public void setAddedBy(String added_by) {
            this.added_by = added_by;
        }

        public Date getAddedAt() {
            return added_at;
        }

        public void setAddedAt(Date added_at) {
            this.added_at = added_at;
        }

        public Date getUpdatedAt() {
            return updated_at;
        }

        public void setUpdatedAt(Date updated_at) {
            this.updated_at = updated_at;
        }

        public BookRequestEntity(String title, String author, String description, String language, String added_by,Date added_at,String updated_by, Date updated_at) {
            this.title = title;
            this.author = author;
            this.description = description;
            this.language = language;
            this.added_by = added_by;
            this.added_at = added_at;
            this.updated_by = updated_by;
            this.updated_at = updated_at;

        }

        @Override
        public String toString() {
            return "BookRequest{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", added_by='" + added_by + '\'' +
                ", added_at='" + added_at + '\'' +
                ", updated_by='" + updated_by + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
        }

}
