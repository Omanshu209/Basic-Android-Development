package com.mycompany.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.net.Uri;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;
import android.view.View;

public class MainActivity extends Activity
{

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        videoView = findViewById(R.id.videoView);
        final Button button = findViewById(R.id.button);

        // Path to the video file
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.vid;
        Uri videoUri = Uri.parse(videoPath);

        // Set the video URI to the VideoView
        videoView.setVideoURI(videoUri);

        // Add media controls (play, pause, etc.)
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Play and pause video on button click
        button.setOnClickListener(new View.OnClickListener()
		{
				@Override
				public void onClick(View v)
				{
					if(button.getText().equals("Play"))
					{
						videoView.start();
						button.setText("Pause");
					}
					
					else
					{
						videoView.pause();
						button.setText("Play");
					}
				}
		});
    }
}
