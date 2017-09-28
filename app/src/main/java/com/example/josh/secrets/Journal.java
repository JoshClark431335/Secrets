package com.example.josh.secrets;

import java.util.ArrayList;

/**
 * @author Josh Clark
 */

public class Journal {
    private ArrayList<JournalEntry> log;

    /**
     * Initialize a new Journal
     */
    public Journal(){
        log = new ArrayList<JournalEntry>();
    }

    /**
     * Adds a new JournalEntry to log
     * @param newEntry a new Entry to be put in the log
     */
    public void addEntry(JournalEntry newEntry){
        if (newEntry != null)
            log.add(newEntry);
    }

    /**
     * Changes the existing text of a JournalEntry to the given string
     * @param id the timestamp of the entry to be changed
     * @param newText the new text to be stored in the entry
     */
    public void update(int id, String newText){
        JournalEntry e = getEntry(id);
        if (e != null) {
            e.setEntryText(newText);
        }
    }

    /**
     * removes a JournalEntry from the log
     * @param id the timestamp of the entry to be deleted
     */
    public void delete(int id){
        for (JournalEntry e : log){
            if (e.getID() == id){
                log.remove(e);
                break;
            }
        }
    }

    /**
     * Returns a JournalEntry matching the given id
     * @param id the timestamp of the entry to be retrieved
     * @return the journalEntry with the specified timestamp
     */
    public JournalEntry getEntry(long id){
        for (JournalEntry e : log){
            if (e.getID() == id){
                return e;
            }
        }
        return null;
    }

}
