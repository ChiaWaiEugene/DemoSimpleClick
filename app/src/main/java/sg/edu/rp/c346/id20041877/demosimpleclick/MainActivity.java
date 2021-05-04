package sg.edu.rp.c346.id20041877.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button buttonDisplay;
    TextView textViewDisplay;
    EditText editTextInput;
    ToggleButton tbEnabler;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDisplay = findViewById(R.id.buttonDisplay);
        textViewDisplay = findViewById(R.id.textViewDisplay);
        editTextInput = findViewById(R.id.editTextInput);
        tbEnabler = findViewById(R.id.tbEnabler);
        rgGender = findViewById(R.id.rgGender);

        buttonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc = editTextInput.getText().toString();
                if (abc.isEmpty()){
                    textViewDisplay.setText("Nothing has been entered ");
                    Toast.makeText(MainActivity.this,"Please input something", Toast.LENGTH_SHORT).show();
                }
                else {
                    int checkedRB = rgGender.getCheckedRadioButtonId();
                    if (checkedRB == R.id.rbFemale){
                        textViewDisplay.setText("She said " + abc);
                    }
                    else {
                        textViewDisplay.setText("He said " + abc);
                    }
                }

            }
        });

        tbEnabler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tbEnabler.isChecked() == true) {
                    editTextInput.setEnabled(true);;
                    editTextInput.setBackgroundColor(Color.TRANSPARENT);
                }
                else {
                    editTextInput.setEnabled(false);
                    editTextInput.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
}