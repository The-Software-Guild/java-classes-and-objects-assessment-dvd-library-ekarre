package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

public class DVDLibraryView {

    private UserIO io;
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs/View All");
        io.print("2. Add New DVD");
        io.print("3. Remove DVD");
        io.print("4. Search for DVD");
        io.print("5. Edit a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices", 1,6);
    }

    //create a method to add a new DVD
    public DVD getNewDVDInfo() {
        //give prompts for user to enter information
        String title = io.readString("Please enter the title of the movie");
        String releaseDate = io.readString("Please enter the release date of the movie");
        String itsRated = io.readString("Please enter what the movie was rated");
        String directorsName = io.readString("Please enter the director's name");
        String studio = io.readString("Please enter the studio who made the movie");
        String personalNote = io.readString("Feel free to enter any other personal notes or your own rating of the movie");
        //after info entered, creates new DVD object, and returns it back to the user
        //set method is used to take the parameter and assign it to the variable (which is referencing what the user entered)
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setItsRated(itsRated);
        currentDVD.setDirectorName(directorsName);
        currentDVD.setStudio(studio);
        currentDVD.setPersonalNote(personalNote);
        return currentDVD;
    }
    //create a banner that acts like a header so the user knows where they are
    public void displayCreateDVDBanner() {
        io.print("* * * Enter New DVD * * *");
    }
    //create a banner that lets user know they successfully added a new DVD
    public void displayCreateSuccessBanner() {
        io.print("You successfully added a DVD to your library. Please hit enter to continue.");
    }

    //create a method to display the info for each DVD
    public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            String DVDInfo = String.format("%s %s %s %s %s %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getItsRated(),
                    currentDVD.getDirectorName(),
                    currentDVD.getStudio(),
                    currentDVD.getPersonalNote());
            io.print(DVDInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    //create a banner
    public void displayDisplayAllBanner() {
        io.print("* * * View all DVDs * * *");
    }

    //create a method to display a single DVD by title
    public String getDVDChoice() {
        return io.readString("Please enter the movie title");
    }
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getItsRated());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getPersonalNote());
        } else {
            io.print("That DVD is not in our system.");
        }
        io.readString("Please hit enter to continue.");
    }
    //create a banner
    public void displayDisplayDVDBanner(){
        io.print("* * * View DVD * * *");
    }

    //create a method to remove a DVD from the library by title
    public void displayRemoveResult(DVD dvdRecord) {
        if (dvdRecord != null) {
            io.print("DVD was successfully removed.");
        } else {
            io.print("That DVD is not in our system.");
        }
        io.readString("Please hit enter to continue.");
    }
    //create a banner
    public void displayRemoveDVDBanner() {
        io.print("* * * Remove DVD from Library * * *");
    }
    public void displayRemoveSuccessBanner() {io.print("DVD Successfully Removed");}

    //last couple of command banners
    public void displayExitBanner() {
        io.print("Thank you for using this library. See you next time!");
    }
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!");
    }

    //create a method to edit a DVD by title
    public int printEditMenu() {
        io.print("Edit DVD");
        io.print("1. Release Date");
        io.print("2. Rating");
        io.print("3. Director's Name");
        io.print("4. Studio");
        io.print("5. Personal Note");
        io.print("6. Exit");

        return io.readInt("Please choose which section you wish to edit", 1,7);
    }

    public void displayEditDVDBanner() {
        io.print("* * * Edit DVD * * *");
    }

    public void displayEditDVDSuccess() {
        io.readString("DVD successfully edited. Please hit enter to continue.");
    }

    public void displayEditReleaseDateBanner() {
        io.print("* * * Edit DVD Release Date * * *");
    }

    public void displayEditRatingBanner() {
        io.print("* * * Edit DVD Rating * * *");
    }

    public void displayEditDirectorNameBanner() {
        io.print("* * * Edit DVD Director's Name * * *");
    }

    public void displayEditStudio() {
        io.print("* * * Edit DVD Studio * * *");
    }

    public void displayEditPersonalNote() {
        io.print("* * * Edit Your Personal Note * * *");
    }

    public String getNewReleaseDate() {
        return io.readString("Please enter new release date.");
    }

    public String getNewRating() {
        return io.readString("Please enter new rating.");
    }

    public String getNewDirectorName() {
        return io.readString("Please enter new director's name.");
    }

    public String getNewPersonalNote() {
        return io.readString("Please enter new personal note.");
    }

    public String getNewStudio() {
        return io.readString("Please enter new studio.");
    }

    public void displayNullDVD() {
        io.print("That DVD is not in our system.");
        io.readString("Please hit enter to continue.");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}

