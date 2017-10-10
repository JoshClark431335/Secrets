package com.example.josh.secrets;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
    private Journal myJournal;
    private TextView dateDisplay;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dateDisplay = (TextView) findViewById(R.id.txtDate1);
        Calendar c = Calendar.getInstance();
        mYear   = c.get(Calendar.YEAR);
        mMonth  = c.get(Calendar.MONTH);
        mDay    = c.get(Calendar.DAY_OF_MONTH);
        dateDisplay.setText((mMonth +1) + "/" + mDay + "/" + mYear);
        myJournal = IOManager.loadJournal(this);
    }

    public void onDateClick1(View v){
        DatePickerDialog datePickerDialog;

        datePickerDialog = new DatePickerDialog(AddActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                        dateDisplay.setText((monthOfYear +1) + "/" + dayOfMonth + "/" + year);
                        mYear   = year;
                        mMonth  = monthOfYear;
                        mDay    = dayOfMonth;
                    }
                }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }

    public void onSaveClick(View v){
        EditText txtEntry = (EditText) findViewById(R.id.txtEntry1);
        String entryText = txtEntry.getText().toString();
        if (entryText.equals(""))
            return;

        JournalEntry entry = new JournalEntry(System.currentTimeMillis(), entryText);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, mYear);
        c.set(Calendar.MONTH, mMonth);
        c.set(Calendar.DAY_OF_MONTH, mDay);
        entry.setEntryDate(c.getTimeInMillis());

        myJournal.addEntry(entry);
        IOManager.saveJournal(this, myJournal);
        finish();
    }

    public void onCancelClick(View v){
        EditText txtEntry = (EditText) findViewById(R.id.txtEntry1);
        String entryText = txtEntry.getText().toString();
        if (entryText.equals(""))
            finish();

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(R.string.strCancelAdd);
        //builder1.setCancelable(true);

        builder1.setPositiveButton(
                R.string.strYes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                R.string.strNo,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder1.create();
        alert.show();
    }
}
