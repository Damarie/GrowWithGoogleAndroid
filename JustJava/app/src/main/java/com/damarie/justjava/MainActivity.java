package com.damarie.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 *  This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        CheckBox hasWhippedCream = findViewById(R.id.whipped_cream);
        CheckBox hasChocolate = findViewById(R.id.chocolate);
        EditText userName = findViewById(R.id.user_name);
        String usernameText = userName.getText().toString();
        int price = calculatePrice();

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.coffee_email_subject));
        String orderSummary = createOrderSummary(usernameText, price, hasWhippedCream.isChecked(), hasChocolate.isChecked());

        emailIntent.putExtra(Intent.EXTRA_TEXT, orderSummary);
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        }
    }

    /**
     * Create summary of order
     *
     * @param price calculated total cost
     * @param hasWhippedCream value of whipped cream checkbox
     * @param hasChocolate value of chocolate checkbox
     * @return text summary
     */
    private String createOrderSummary(String usernameText, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String orderSummary = getString(R.string.order_summary_name, usernameText);
        orderSummary += "\n" + getString(R.string.add_whipped_cream, hasWhippedCream);
        orderSummary += "\n" + getString(R.string.add_chocolate, hasChocolate);
        orderSummary += "\n" + getString(R.string.quantity_label, quantity);
        orderSummary += "\n" + getString(R.string.total_cost) + NumberFormat.getCurrencyInstance().format(price);
        orderSummary += "\n" + getString(R.string.thank_you);
        return orderSummary;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        CheckBox whippedCream = findViewById(R.id.whipped_cream);
        CheckBox chocolate = findViewById(R.id.chocolate);
        if (whippedCream.isChecked()) {
            price = price + quantity;
        }
        if (chocolate.isChecked()) {
            price = price + (quantity*2);
        }
        return price;
    }

    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, getString(R.string.too_many_alert), Toast.LENGTH_SHORT).show();
        } else {
            quantity += 1;
            displayQuantity(quantity);
        }

    }

    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, getString(R.string.too_few_alert), Toast.LENGTH_SHORT).show();
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }
}
