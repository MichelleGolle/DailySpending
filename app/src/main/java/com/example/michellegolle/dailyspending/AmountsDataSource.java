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
            MySQLiteHelper.COLUMN_AMOUNT,
            MySQLiteHelper.COLUMN_DATE,
            MySQLiteHelper.COLUMN_CATEGORY,
            MySQLiteHelper.COLUMN_NOTE};

    public AmountsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Amount createAmount(Amount amount) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_AMOUNT, amount.getAmount());
        values.put(MySQLiteHelper.COLUMN_DATE, amount.getDate());
        values.put(MySQLiteHelper.COLUMN_NOTE, amount.getNote());
        values.put(MySQLiteHelper.COLUMN_CATEGORY, amount.getCategory());
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
        cursor.close();
        return amounts;
    }

    private Amount cursorToAmount(Cursor cursor) {
        Amount amount = new Amount();
        amount.setId(cursor.getLong(cursor.getColumnIndex("_id")));
        amount.setAmount(cursor.getString(cursor.getColumnIndex("amount")));
        amount.setDate(cursor.getString(cursor.getColumnIndex("date")));
        amount.setNote(cursor.getString(cursor.getColumnIndex("note")));
        amount.setCategory(cursor.getString(cursor.getColumnIndex("category")));
        return amount;
    }
}

