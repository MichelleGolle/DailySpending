package com.example.michellegolle.dailyspending;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class DisplayMonthActivity extends AppCompatActivity {
    private AmountsDataSource datasource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_month);

        datasource = new AmountsDataSource(this);
        datasource.open();

        // get a reference for the TableLayout
        TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);

        // create a new TableRow
        TableRow header = new TableRow(this);
        // create a new TextView
        TextView date = new TextView(this);
        date.setText("Date");
        // add the TextView and the CheckBox to the new TableRow
        header.addView(date);
        // create a new TextView
        TextView amountText = new TextView(this);
        amountText.setText("Amount");
        // add the TextView and the CheckBox to the new TableRow
        header.addView(amountText);
        // create a new TextView
        TextView category = new TextView(this);
        category.setText("Category");
        // add the TextView and the CheckBox to the new TableRow
        header.addView(category);
        // create a new TextView
        TextView note = new TextView(this);
        note.setText("Note");
        // add the TextView and the CheckBox to the new TableRow
        header.addView(note);
        // add the TableRow to the TableLayout
        table.addView(header, new TableLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));

        List<Amount> values = datasource.getAllAmounts();
//        List<Amount> currentMonthValues = allValues.removeIf(v -> !v.isCurrentMonth);

        for (Amount amount : values)
        {
            // create a new TableRow
            TableRow row = new TableRow(this);
            // create a new TextView
            TextView t1 = new TextView(this);
            t1.setText(amount.getDate());
            // add the TextView and the CheckBox to the new TableRow
            row.addView(t1);
            // create a new TextView
            TextView t2 = new TextView(this);
            t2.setText(amount.getAmount());
            // add the TextView and the CheckBox to the new TableRow
            row.addView(t2);
            // create a new TextView
            TextView t3 = new TextView(this);
            t3.setText(amount.getCategory());
            // add the TextView and the CheckBox to the new TableRow
            row.addView(t3);
            // create a new TextView
            TextView t4 = new TextView(this);
            t4.setText(amount.getNote());
            // add the TextView and the CheckBox to the new TableRow
            row.addView(t4);
            // add the TableRow to the TableLayout
            table.addView(row,new TableLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
        }





    }
}
