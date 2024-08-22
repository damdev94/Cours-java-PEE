/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.directmedia.onlinestore.core.entity;

/**
 *
 * @author damien
 */
public class Work {
    
    private static int lastId;
    
    public Work(){
        this.id = lastId++;
    }
    
    public Work(String title){
        this();
        this.title = title;
    }
    
    private long id;
    private String title;
    private String genre;
    private int release;
    private String summary;
    private Artist mainArtist;
    
    
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
     public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public int getRelease(){
        return release;
    }
    public void setRelease(int release){
        this.release = release;
    }
    
    public String getSummary(){
        return summary;
    }
    public void setSummary(String summary){
        this.summary = summary;    }
    
    public Artist getArtist(){
        return mainArtist;
    }
    public void setArtist(Artist mainArtist){
        this.mainArtist = mainArtist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
