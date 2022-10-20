package com.sg.dvdlibrary.dto;

public class DVD {

    //declaring variables
    private String title;
    private String releaseDate;
    private String itsRated;
    private String directorName;
    private String studio;
    private String personalNote;

    //creating getters and setters for each
    public String getTitle(){
        return title;
    }
    //don't need a set method here (it's read-only)
    //it is passed in as a parameter to the constructor; needs to be instantiated
    public DVD (String title) {
        this.title = title;
    }

    //creating a get method to return the value of the variable when used
    public String getReleaseDate(){
        return releaseDate;
    }
    //creating a set method that takes the parameter (String releaseDate) and assigns it to the "releaseDate" variable
    //this. is referring to the current object
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getItsRated(){
        return itsRated;
    }
    public void setItsRated(String itsRated){
        this.itsRated = itsRated;
    }

    public String getDirectorName(){
        return directorName;
    }
    public void setDirectorName(String directorName){
        this.directorName = directorName;
    }

    public String getStudio(){
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getPersonalNote(){
        return personalNote;
    }
    public void setPersonalNote(String personalNote){
        this.personalNote = personalNote;
    }
}

