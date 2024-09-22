package com.mycompany.myapp5;

import android.app.*;
import android.os.*;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Find the LinearLayout by its ID
        LinearLayout firstHorizontalLayout = findViewById(R.id.first_horizontal_layout);

        // Create a new ImageView
        ImageView newImageView = new ImageView(this);

        // Set the image for the new ImageView
        newImageView.setImageResource(R.drawable.image1); // Replace with your image

        // Set layout parameters for the new ImageView
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.MATCH_PARENT,
			LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(8, 8, 8, 8); // Set margins if needed
        newImageView.setLayoutParams(layoutParams);

        // Add the new ImageView to the LinearLayout
        firstHorizontalLayout.addView(newImageView);
    }
}
