package com.damarie.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView textViewItem1 = findViewById(R.id.menu_item_1);
        String menuItem1 = textViewItem1.getText().toString();
        Log.v("Main Activity", menuItem1);

        // Find second menu item TextView and print the text to the logs
        TextView textViewItem2 = findViewById(R.id.menu_item_2);
        String menuItem2 = textViewItem1.getText().toString();
        Log.v("Main Activity", menuItem2);

        // Find third menu item TextView and print the text to the logs
        TextView textViewItem3 = findViewById(R.id.menu_item_3);
        String menuItem3 = textViewItem3.getText().toString();
        Log.v("Main Activity", menuItem3);

    }
}
