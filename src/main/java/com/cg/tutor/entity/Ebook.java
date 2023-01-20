package com.cg.tutor.entity;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

 

@Entity
@Table(name="ebook_tbl")
public class Ebook {

 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int bookId;

 

    @Column(name="book_name")
    @NotEmpty(message="won't accept empty")
    private String bookName;

 

    @Column(name="author")
    @NotEmpty(message="won't accept empty")
    private String author;

    @ManyToOne
    @JoinColumn(name="parentId")
    private Parent parent;

 

    public int getBookId() {
        return bookId;
    }

 

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

 

    public String getBookName() {
        return bookName;
    }

 

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

 

    public String getAuthor() {
        return author;
    }

 

    public void setAuthor(String author) {
        this.author = author;
    }

 

    public Parent getParent() {
        return parent;
    }

 

    public void setParent(Parent parent) {
        this.parent = parent;
    }

 

}