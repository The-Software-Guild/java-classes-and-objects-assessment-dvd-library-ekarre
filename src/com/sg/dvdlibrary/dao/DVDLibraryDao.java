package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

public interface DVDLibraryDao {

    /*add DVD to library and associate it with given title
    if there is a DVD with that title, it will return that DVD.
     */
    DVD addDVD (String title, DVD dvd) throws DVDLibraryDaoException;

    //return a list of all DVDs in the library
    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    //display a single DVD by title
    //return a DVD associated with the title
    DVD getDVD(String title) throws DVDLibraryDaoException;

    //remove a DVD from library by title
    DVD removeDVD(String title) throws DVDLibraryDaoException;

    DVD editReleaseDate(String title, String newReleaseDate) throws DVDLibraryDaoException;

    DVD editRating(String title, String newRating) throws DVDLibraryDaoException;

    DVD editDirectorName(String title, String newDirectorName) throws DVDLibraryDaoException;

    DVD editPersonalNote(String title, String newPersonalNote) throws DVDLibraryDaoException;

    DVD editStudio(String title, String newStudioName) throws DVDLibraryDaoException;

}

