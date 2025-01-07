package com.example.library.demo.entity;

import jakarta.persistence.*;
import java.util.Date;


@Entity
public class BookResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", nullable = false)

        private Integer book_id;
        private String status;
        private String description;
        private String title;
        private String author;
        private String language;
        private int is_available;
        private String is_deleted;
        private String added_by;
        private Date added_at;
        private Date updated_at;
        private String updated_by;

        public BookResponseEntity() {
        }

        public Integer getBookId() {
            return book_id;
        }

        public void setBookId(Integer book_id) {
            this.book_id = book_id;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public int getIsAvailable() {
            return is_available;
        }

        public void setIsAvailable(int is_available) {
            this.is_available = is_available;
        }
        public String getIsDeleted() {
            return is_deleted;
        }
        public void setIsDeleted(String is_deleted) {
            this.is_deleted = is_deleted;
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

        public BookResponseEntity(Integer book_id, String status, String description,  String title, String language, int is_available, String added_by, Date added_at,String updated_by, Date updated_at, String is_deleted) {
            this.book_id = book_id;
            this.status = status;
            this.description = description;
            this.title = title;
            this.language = language;
            this.is_available = is_available;
            this.added_by = added_by;
            this.added_at = added_at;
            this.updated_by = updated_by;
            this.updated_at = updated_at;
            this.is_deleted = is_deleted;
        }

        @Override
        public String toString() {
            return "BookResponse{" +
                "book_id=" + book_id +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", is_available='" + is_available +'\'' +
                ", added_by='" + added_by + '\'' +
                ", added_at='" + added_at +'\'' +
                ", updated_by='" + updated_by + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", is_deleted='" + is_deleted + '\'' +
                '}';
        }

}
