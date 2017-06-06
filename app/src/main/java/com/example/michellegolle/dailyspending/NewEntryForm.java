package com.example.michellegolle.dailyspending;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;


public class NewEntryForm extends AppCompatActivity {
    public static final String EXTRA_AMOUNT = "com.example.michellegolle.dailyspending.AMOUNT";
    private AmountsDataSource datasource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry_form);
        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
    }

    public void submitNewEntry (View v) {
        datasource = new AmountsDataSource(this);
        datasource.open();
        EditText editAmount = (EditText) findViewById(R.id.editAmount);
        String amount = editAmount.getText().toString();
        datasource.createAmount(amount);
        datasource.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
