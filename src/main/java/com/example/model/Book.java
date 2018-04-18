package com.example.model;


import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

import java.awt.geom.NoninvertibleTransformException;

/**
 * @author garden
 * @create 4/10/18
 */
public class Book {
    // Similar to the table in SQL database
    public static final String BOOK_KIND = "Book_item";
    private String name;
    private String category;
    private int num;
    // Create a DataStore service
    private Datastore datastore;

    private Book(){
        this.datastore = DatastoreOptions.getDefaultInstance().getService();
    }
    public Book builder(){
        return null;
    }






}
