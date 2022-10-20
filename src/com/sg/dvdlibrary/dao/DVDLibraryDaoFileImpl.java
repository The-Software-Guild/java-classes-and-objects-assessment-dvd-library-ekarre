package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl  implements DVDLibraryDao {

    public static String LIBRARY_FILE;
    //create a Map (below) to be able to look up DVDs by their title with the title being the key
    private Map<String, DVD> dvds = new HashMap<>();
    public static final String DELIMITER = "::";

    public DVDLibraryDaoFileImpl () {
        LIBRARY_FILE = "library.txt";
    }
    private DVD unmarshallDVD(String DVDAsText) {
        //DVDAsText is expecting a line read in from our file
        //Split line on DELIMITER leaving us with array of Strings stored in DVDTokens
        String[] DVDTokens = DVDAsText.split(DELIMITER);
        String title = DVDTokens[0];
        //Create new DVD object
        DVD DVDFromFile = new DVD(title);
        //Add remaining "tokens" into DVD object by using "set"
        DVDFromFile.setReleaseDate(DVDTokens[1]);
        DVDFromFile.setItsRated(DVDTokens[2]);
        DVDFromFile.setDirectorName(DVDTokens[3]);
        DVDFromFile.setStudio(DVDTokens[4]);
        DVDFromFile.setPersonalNote(DVDTokens[5]);
        return DVDFromFile;
    }
    //create method to load library
    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("Could not load library data into memory", e);
        }
        //holds most recent line read from file
        String currentLine;
        //holds most recent DVD unmarshalled
        DVD currentDVD;
        //Go through DVD_FILE line by line, decoding each line into DVD object by calling unmarshallDVD method
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            //unmarshall the line into a DVD
            currentDVD = unmarshallDVD(currentLine);
            //put currentDVD into map using title as key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }
    //create method to marshall DVD
    private String marshallDVD(DVD aDVD) {
        String DVDAsText = aDVD.getTitle() + DELIMITER;
        DVDAsText += aDVD.getReleaseDate()+ DELIMITER;
        DVDAsText += aDVD.getItsRated() + DELIMITER;
        DVDAsText += aDVD.getDirectorName() + DELIMITER;
        DVDAsText += aDVD.getStudio() + DELIMITER;
        DVDAsText += aDVD.getPersonalNote() + DELIMITER;
        return DVDAsText;
    }
    //create method to write to library
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
            //catch IOException and translate it into a DaoException
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save DVD data", e);
        }
        //write out DVD objects to library file
        String DVDAsText;
        List<DVD> DVDList = this.getAllDVDs();
        for (DVD currentDVD : DVDList) {
            //turn DVD into a string
            DVDAsText = marshallDVD(currentDVD);
            //write DVD object to file
            out.println(DVDAsText);
            //force PrintWriter to write line to file
            out.flush();
        }
        out.close();
    }

    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        //to add a DVD, we declare a new variable (prevDVD), and use the variable "dvds" + put(parameters) and then return "prevDVD"
        DVD prevDVD = dvds.put(title, dvd);
        writeLibrary();
        return prevDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        //loadLibrary();
        //to list all DVDs, we return a new ArrayList with the parameter collection DVD to convert the collection into a list of DVD objects
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        //ask the map for the DVD object by using the title
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        //ask the map to remove the DVD by using the title
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editReleaseDate(String title, String newReleaseDate) throws DVDLibraryDaoException {
        DVD currentDVD = dvds.get(title);
        currentDVD.setReleaseDate(newReleaseDate);
        return currentDVD;
    }

    @Override
    public DVD editRating(String title, String newRating) throws DVDLibraryDaoException {
        DVD currentDVD = dvds.get(title);
        currentDVD.setItsRated(newRating);
        return currentDVD;
    }

    @Override
    public DVD editDirectorName(String title, String newDirectorName) throws DVDLibraryDaoException {
        DVD currentDVD = dvds.get(title);
        currentDVD.setDirectorName(newDirectorName);
        return currentDVD;
    }

    @Override
    public DVD editPersonalNote(String title, String newPersonalNote) throws DVDLibraryDaoException {
        DVD currentDVD = dvds.get(title);
        currentDVD.setPersonalNote(newPersonalNote);
        return currentDVD;
    }

    @Override
    public DVD editStudio(String title, String newStudioName) throws DVDLibraryDaoException {
        DVD currentDVD = dvds.get(title);
        currentDVD.setStudio(newStudioName);
        return currentDVD;
    }
}

