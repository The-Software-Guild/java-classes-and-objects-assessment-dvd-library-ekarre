package com.sg.dvdlibrary.dao;

public class DVDLibraryDaoException extends Exception{
    //use when something is wrong but isn't caused by another exception
    public DVDLibraryDaoException(String message) {
        super(message);
    }
    //use when something is wrong that is caused by another exception in underlying implementation
    /*Catch implementation-specific exception
    In catch block, create new Exception and pass in new message and exception that caused original problem
    Throw out newly-created Exception
     */
    public DVDLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
