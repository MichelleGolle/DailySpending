package com.example.michellegolle.dailyspending;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AmountsDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_AMOUNT };

    public AmountsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Amount createAmount(String amount) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_AMOUNT, amount);
        long insertId = database.insert(MySQLiteHelper.TABLE_AMOUNTS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_AMOUNTS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Amount newAmount = cursorToAmount(cursor);
        cursor.close();
        return newAmount;
    }

    public void deleteAmount(Amount amount) {
        long id = amount.getId();
        System.out.println("Amount deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_AMOUNTS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Amount> getAllAmounts() {
        List<Amount> amounts = new ArrayList<Amount>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_AMOUNTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Amount amount = cursorToAmount(cursor);
            amounts.add(amount);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return amounts;
    }

    private Amount cursorToAmount(Cursor cursor) {
        Amount amount = new Amount();
        amount.setId(cursor.getLong(0));
        amount.setAmount(cursor.getString(1));
        return amount;
    }
}