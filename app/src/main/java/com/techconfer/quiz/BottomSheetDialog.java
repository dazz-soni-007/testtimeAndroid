package com.techconfer.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.techconfer.quiz.Activities.Dashboard;
import com.techconfer.quiz.Activities.HomeActivity;

public class BottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener {
    EditText otpedtext, phonedtext;
    TextView phonetext, otptext, resendtext;
    Button sendotp,loginbtn;
    String phoneNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_otp,
                container, false);
        phonedtext = v.findViewById(R.id.phoneNoeditText);
        otpedtext = v.findViewById(R.id.otpeditText);
        phonetext = v.findViewById(R.id.phnotextView);
        otptext = v.findViewById(R.id.otptextView);
        sendotp=v.findViewById(R.id.sendotp);
        loginbtn=v.findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(this);
        sendotp.setOnClickListener(this);
        resendtext = v.findViewById(R.id.resendTxtView);
        hideOtpField();

        return v;
    }


    private void hideOtpField() {
        otpedtext.setVisibility(View.INVISIBLE);
        otptext.setVisibility(View.INVISIBLE);
        resendtext.setVisibility(View.INVISIBLE);
        loginbtn.setVisibility(View.INVISIBLE);
        resendtext.setOnClickListener(null);
    }

    private void showOTPField() {
        otpedtext.setVisibility(View.VISIBLE);
        otptext.setVisibility(View.VISIBLE);
        sendotp.setVisibility(View.INVISIBLE);
        loginbtn.setVisibility(View.VISIBLE);
        resendtext.setVisibility(View.VISIBLE);
        resendtext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendotp:
                phoneNumber=phonedtext.getText().toString();
                if(phoneNumber.length()==10){
               showOTPField();
                } else{

                    Toast.makeText(getContext(), "Please enter your phone number!", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.loginbtn:

                startActivity(new Intent(getContext(), Dashboard.class));

        }

    }

}
