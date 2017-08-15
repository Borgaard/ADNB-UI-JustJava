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
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int price = 8;
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
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.topping_whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.topping_chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        //Log.v("MainActivity", "Has chocolate: " + hasChocolate);


        displayMessage(createOrderSummary(quantity, hasWhippedCream, hasChocolate));
    }
    private String createOrderSummary(int cups, boolean addWhippedCream, boolean addChocolate){
        return "Name: Butternut Squash " +
                "\nQuantity: " +cups+ " " +
                "\nTotal: $" +calculatePrice()+
                "\nWhipped cream? " +addWhippedCream+
                "\n Chocolate? " +addChocolate;
    }










    private int calculatePrice() {
        return quantity * price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    //int price = calculatePrice();
    //String priceMessage = "What could a banana cost, Michael? \n $" + price + " dollars?";
    //displayMessage(priceMessage);
    //String priceMessage = createOrderSummary(price);
}