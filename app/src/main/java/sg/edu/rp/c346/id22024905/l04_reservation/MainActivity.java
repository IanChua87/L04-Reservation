package sg.edu.rp.c346.id22024905.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etGrpSize;
    RadioGroup rdSmokingGrp;
    RadioButton rdSmoking;
    RadioButton rdNotSmoking;
    TimePicker tp;
    DatePicker dp;
    Button btnCfm;
    Button btnReset;
    TextView dpText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editName);
        etPhone = findViewById(R.id.editPhoneNumber);
        etGrpSize = findViewById(R.id.editTextGrpSize);
        rdSmokingGrp = findViewById(R.id.rdSmokingOrNotSMokingGrp);
        rdSmoking = findViewById(R.id.radioButtonSmoking);
        rdNotSmoking = findViewById(R.id.radioButtonNonSmoking);
        tp = findViewById(R.id.timePicker);
        dp = findViewById(R.id.datePicker);
        btnCfm = findViewById(R.id.buttonConfirm);
        btnReset = findViewById(R.id.buttonReset);
        dpText = findViewById(R.id.displayText);

        btnCfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = etName.getText().toString();
                String stringPhone = etPhone.getText().toString();
                String stringGrpSize = etGrpSize.getText().toString();

                int hour = tp.getHour();
                int min = tp.getMinute();
                String formTime = String.format("%02d:%02d", hour, min);
                if(! nameInput.isEmpty()  && ! stringPhone.isEmpty() && ! stringGrpSize.isEmpty() && (rdSmoking.isChecked() || rdNotSmoking.isChecked())){
                    Toast.makeText(MainActivity.this, "Name: " + nameInput, Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(getApplicationContext(), "You haven't entered a field, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etPhone.setText("");
                etGrpSize.setText("");
                rdSmoking.setChecked(false);
                tp.setHour(19);
                tp.setMinute(30);
                dp.updateDate(2020, 5, 01);
            }
        });
    }


}