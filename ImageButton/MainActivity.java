package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.ImageButton;
import android.view.View;

public class MainActivity extends Activity 
{
    private int img = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		final ImageButton iconButton = findViewById(R.id.icon_button);

        iconButton.setOnClickListener(new View.OnClickListener()
		{
				@Override
				public void onClick(View v)
				{
					if(img == 1)
					{
						iconButton.setImageResource(R.drawable.img2);
						img++;
					}
					
					else
					{
						iconButton.setImageResource(R.drawable.img1);
						img--;
					}
				}
		});
    }
}
