package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDao;
import com.sg.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        //declare UserIo variable and initialize it
        UserIO myIo = new UserIOConsoleImpl();
        //declare and instantiate myView object and pass UserIo into constructor
        DVDLibraryView myView = new DVDLibraryView(myIo);
        //declare myDao variable and initialize it with Impl reference
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        //added controller to this class and instantiated it and told it to run
        //pass in Dao and View objects into constructor
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
