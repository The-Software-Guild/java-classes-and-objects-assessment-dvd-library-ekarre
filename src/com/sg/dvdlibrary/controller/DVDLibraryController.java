package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;


import java.util.List;

//this is going to control when the menu system is displayed
public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    //implement a constructor that initializes the two above
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    //create a method called run() that will display the menu, let the user choose, and then performs an action based on choice
    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        try {
            //create while loop that goes on as long as keepGoing is true (they are on the menu)
            while (keepGoing) {

                menuSelection = getMenuSelection();

                //create switch case to say which option they chose in real words from their number
                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        removeDVD();
                        break;
                    case 4:
                        viewDVD();
                        break;
                    case 5:
                        editDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage(); //prints "Goodbye" and exits when keepGoing is false
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    //create method (below) to get the menuSelection in the run() method above
    //made a call to the printMenuAndGetSelection() from DVDLibraryView (we instantiated it above)
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    //create new DVD
    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayCreateSuccessBanner();
    }

    //display all DVDs
    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> DVDList = dao.getAllDVDs();
        view.displayDVDList(DVDList);
    }

    //display a single DVD
    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    //remove a DVD from the library
    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDChoice();
        dao.removeDVD(title);
        view.displayRemoveSuccessBanner();
    }

    //unknown command and exit message
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    private void exitMessage() {
        view.displayExitBanner();
    }

    //edit a DVD from library
    private void editDVD() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDChoice();
        DVD currentDVD = dao.getDVD(title);
        if (currentDVD == null) {
            view.displayNullDVD();
        } else {
            view.displayDVD(currentDVD);
            int editMenuSelection;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = getEditMenuSelection();

                switch (editMenuSelection) {
                    case 1: editReleaseDate(title);
                        break;
                    case 2: editRating(title);
                        break;
                    case 3: editDirectorName(title);
                        break;
                    case 4: editStudioName(title);
                        break;
                    case 5: editPersonalNote(title);
                        break;
                    case 6: keepGoing = false;
                        break;
                    default: unknownCommand();
                }
                if (keepGoing == false) {
                    break;
                }
            }
        }
    }
    private int getEditMenuSelection(){
        return view.printEditMenu();
    }
    private void editReleaseDate(String title) throws DVDLibraryDaoException {
        view.displayEditReleaseDateBanner();
        String newReleaseDate = view.getNewReleaseDate();
        dao.editReleaseDate(title, newReleaseDate);
        view.displayEditDVDSuccess();
    }
    private void editRating(String title) throws DVDLibraryDaoException {
        view.displayEditRatingBanner();
        String newRating = view.getNewRating();
        dao.editRating(title, newRating);
        view.displayEditDVDSuccess();
    }
    private void editDirectorName(String title) throws DVDLibraryDaoException {
        view.displayEditDirectorNameBanner();
        String newDirectorName = view.getNewDirectorName();
        dao.editDirectorName(title, newDirectorName);
        view.displayEditDVDSuccess();
    }
    private void editPersonalNote(String title) throws DVDLibraryDaoException {
        view.displayEditPersonalNote();
        String newPersonalNote = view.getNewPersonalNote();
        dao.editPersonalNote(title, newPersonalNote);
        view.displayEditDVDSuccess();
    }
    private void editStudioName(String title) throws DVDLibraryDaoException {
        view.displayEditStudio();
        String newStudioName = view.getNewStudio();
        dao.editStudio(title, newStudioName);
        view.displayEditDVDSuccess();
    }
}
