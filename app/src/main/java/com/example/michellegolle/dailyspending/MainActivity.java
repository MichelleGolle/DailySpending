package com.example.michellegolle.dailyspending;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AmountsDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datasource = new AmountsDataSource(this);
        datasource.open();

        List<Amount> values = datasource.getAllAmounts();
        ArrayList<String> amounts = new ArrayList<String>();
        //this returns an array of strings i.e. ["5.50", "4.00"]
        for(Amount i : values) {
         amounts.add(i.getAmount());
        }

        List<BigDecimal> bdList = new ArrayList<>();
        //populate list
        for(String i : amounts) {
            bdList.add(new BigDecimal(i));
        }

        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal i : bdList) {
            sum = sum.add(i);
        }

        // Using StringBuilder for concatenating the amount with $
        StringBuilder result = new StringBuilder();
        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(result.append("$").append(sum.toString()));
    }

    public void addNewEntry(View view) {
        Intent intent = new Intent(this, NewEntryForm.class);
        startActivity(intent);
    }
}
