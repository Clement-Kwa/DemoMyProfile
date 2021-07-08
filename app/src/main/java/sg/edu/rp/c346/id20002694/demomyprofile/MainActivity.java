package sg.edu.rp.c346.id20002694.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGPA = findViewById(R.id.etGPA);



    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String msg = prefs.getString("name", "Enter Name");
        etName.setText(msg);

        SharedPreferences prefsB = getPreferences(MODE_PRIVATE);
        Float msgB = prefs.getFloat("gpa", 1.23f);
        etGPA.setText(Float.toString(msgB));
    }


    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        SharedPreferences pref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = pref.edit();
        prefEdit.putString("name", strName);
        prefEdit.commit();


        float gpaValue = Float.parseFloat(etGPA.getText().toString())  ;
        SharedPreferences prefB =getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEditB = pref.edit();
        prefEditB.putFloat("gpa", gpaValue);
        prefEditB.commit();

    }

}