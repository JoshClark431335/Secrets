package com.example.josh.secrets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    private Journal myJournal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void AddEntry(View v){
        EditText txtEntry = (EditText) findViewById(R.id.txtEntry1);
        EditText txtDate = (EditText) findViewById(R.id.txtDate1);

        String entryText = txtEntry.getText().toString();
        Long date = Long.parseLong(txtDate.getText().toString());

        if (entryText.equals(""))
            return;

        JournalEntry entry = new JournalEntry(date, entryText);

        //myJournal.addEntry(entry);
    }
}
