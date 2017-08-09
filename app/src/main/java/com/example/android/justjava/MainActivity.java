package com.example.android.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void incrementQty(View view) {
        quantity = quantity +1;
        displayQuantity(quantity);
    }
    public void decrementQty(View view){
        quantity = quantity -1;
        displayQuantity(quantity);
    }
    public void submitOrder(View view){
        int price = quantity * 5;
        String priceMessage = "What could a banana cost, Michael?";
        priceMessage = priceMessage + "\n $" +price+ " dollars?";
        displayMessage(priceMessage);
        //displayPrice(quantity * 4);
        calculatePrice(quantity, price);
    }
    /**
     * Calculates the price of the order.
     * @param pricePerCup is price per unit/cup
     * @param quantity is the number of cups of coffee ordered
     */
    private void calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}