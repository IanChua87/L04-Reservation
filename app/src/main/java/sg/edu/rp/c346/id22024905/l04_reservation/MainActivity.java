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

import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tvGrpSize;
    TextView tvArea;
    TextView tvTime;
    TextView tvDate;
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
        tvGrpSize = findViewById(R.id.textViewGrpSize);
        tvArea = findViewById(R.id.textViewArea);
        tvTime = findViewById(R.id.textViewTime);
        tvDate = findViewById(R.id.textViewDate);



        btnCfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameInput = etName.getText().toString();
                String stringPhone = etPhone.getText().toString();
                String stringGrpSize = etGrpSize.getText().toString();

                int hour = tp.getHour();
                int min = tp.getMinute();
                String formTime = String.format("%02d:%02d", hour, min);
                int month = dp.getMonth();
                int dom = dp.getDayOfMonth();
                int year = dp.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dom);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formDate = dateFormat.format(calendar.getTime());
                String displayMsg = "";
                String areaMsg = "";
                String timeDateMsg = "";

                if(!nameInput.isEmpty() && !stringPhone.isEmpty() && !stringGrpSize.isEmpty() && (rdSmoking.isChecked() || rdNotSmoking.isChecked())){
                   displayMsg += "Name: " + nameInput + "\n" + "Phone: " + stringPhone + "\n";
                   Toast.makeText(MainActivity.this, displayMsg, Toast.LENGTH_LONG).show();
                   if(rdSmoking.isChecked()){
                       areaMsg += "Area: Smoking area";
                   } else {
                       areaMsg += "Area: Non-smoking area";
                   }

//                   areaMsg += "Group size: " + stringGrpSize + "\n";
//                   Toast.makeText(MainActivity.this, areaMsg, Toast.LENGTH_LONG).show();
//                   timeDateMsg += "Time: " + formTime + "\n" + "Date: " + formDate;
//                   Toast.makeText(MainActivity.this, timeDateMsg, Toast.LENGTH_LONG).show();
                    tvGrpSize.setText("Group size: " + stringGrpSize);
                    tvArea.setText("" + areaMsg);
                    tvTime.setText("Time: " + formTime);
                    tvDate.setText("Date: " + formDate);
               }
                else{
                   Toast.makeText(MainActivity.this, "Error! Not all fields are filled", Toast.LENGTH_SHORT).show();
                    tvGrpSize.setText("");
                    tvArea.setText("");
                    tvTime.setText("");
                    tvDate.setText("");
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
                tvGrpSize.setText("");
                tvArea.setText("");
                tvTime.setText("");
                tvDate.setText("");
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay >= 8 && hourOfDay < 21){
                    Toast.makeText(MainActivity.this, "Reservation time: " + hourOfDay, Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(MainActivity.this, "Reservation time is only between 8AM and 8:59PM", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}