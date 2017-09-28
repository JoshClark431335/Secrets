package com.example.josh.secrets;

/**
 * @author Josh Clark
 */

public class JournalEntry {
    private long id;
    private long entryDate;
    private String entryText;

    /**
     * Creates a new JournalEntry with the given id and text
     * @param newID the timestamp of the new entry
     * @param newEntryText the text associated with this entry
     */
    public JournalEntry(long newID, String newEntryText){
        setID(newID);
        setEntryText(newEntryText);
    }

    public void setID(long newID){
        id = newID;
    }

    public long getID(){
        return id;
    }

    public void setEntryDate(long newEntryDate){
        entryDate = newEntryDate;
    }

    public long getEntryDate(){
        return entryDate;
    }

    public void setEntryText(String newEntryText){
        entryText = newEntryText;
    }

    public String getEntryText(){
        return entryText;
    }
}
