package com.mycompany.myapp3;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View;
import java.io.*;
import java.nio.charset.Charset;
//import com.mycompany.myapp3.R;
import java.util.Scanner;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button button = findViewById(R.id.button);
		final TextView textView = findViewById(R.id.textView);
		final EditText editText = findViewById(R.id.editText);
		final calc obj = new calc();
		String a = getCsVFile();
		
		textView.setText(a);
		

		button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String inputText = editText.getText().toString();  // Get the text from EditText
					textView.setText(Integer.toString(obj.calculate(inputText)));  // Set the retrieved text to TextView
				}
			});
    }
	
	public String getCsVFile()
	{
		//InputStream is = getResources().openRawResource(R.raw.csvfile);
		//Scanner reader = new Scanner(new InputStreamReader(is, Charset.forName("UTF-8")));
		final TextView textView = findViewById(R.id.textView);
		String line = "";
		try{
			//FileWriter dataWriter = new FileWriter("android.resource://" + getPackageName() + "/" + R.raw.csvfile,true);
			//dataWriter.write("kal, sunday, hai");
			//dataWriter.close();
			String path = "android.resource://" + getPackageName() + "/" + R.raw.csvfile;
			FileOutputStream fos = openFileOutput("csvfile.csv", MODE_APPEND);  // Appending to the file
			fos.write("17, 13, 12\n".getBytes());
			fos.write("32, 76, 89\n".getBytes());
			fos.close();
			}
		catch(IOException e){textView.setText(e.getMessage());}
		
		try{
			FileInputStream fis = openFileInput("csvfile.csv");
			Scanner reader = new Scanner(new InputStreamReader(fis, Charset.forName("UTF-8")));
			//reader.nextLine();
			line = reader.nextLine().split(",")[0];
		}
		catch(Exception e){
			return "-1";
		}
		
		return line;
	}
}
