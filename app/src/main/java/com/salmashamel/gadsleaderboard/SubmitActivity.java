package com.salmashamel.gadsleaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.salmashamel.gadsleaderboard.UI.SubmitViewModel;

public class SubmitActivity extends AppCompatActivity {

    private static final String TAG = "SubmitActivity";

    private Button btnSubmit;
    private Toolbar toolbar;
    private EditText edEmail;
    private EditText edFirstName;
    private EditText edLastName;
    private EditText edGithubLink;

    private SubmitViewModel mSubmitViewModel;

    private String email;
    private String firstName;
    private String lastName;
    private String githubLink;
    private Boolean submitFlag;

//    private AlertDialog.Builder alertSuccess;
//    private AlertDialog.Builder alertFail;

//    private View viewSuccess;
//    private View viewFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        toolbar = findViewById(R.id.toolbar);
        btnSubmit = findViewById(R.id.btnSubmit);
        edEmail = findViewById(R.id.edEmail);
        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edLastName);
        edGithubLink = findViewById(R.id.edGithubLink);

        mSubmitViewModel = ViewModelProviders.of(this).get(SubmitViewModel.class);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getDataFromUser()){
                    AlertDialog.Builder alertCheck = new AlertDialog.Builder(SubmitActivity.this);
                    LayoutInflater factoryCheck = LayoutInflater.from(SubmitActivity.this);
                    View viewCheck = factoryCheck.inflate(R.layout.submission_check, null);
                    alertCheck.setView(viewCheck);
                    alertCheck.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            mSubmitViewModel.submitProject(email, firstName, lastName, githubLink).observe(SubmitActivity.this, new Observer<Boolean>() {
                                @Override
                                public void onChanged(Boolean submitDone) {
                                    Log.d(TAG, "onChanged: received data" );
                                    submitFlag = submitDone;
                                    if(submitFlag){
                                        AlertDialog.Builder alertSuccess = new AlertDialog.Builder(SubmitActivity.this);
                                        LayoutInflater factorySuccess = LayoutInflater.from(SubmitActivity.this);
                                        View viewSuccess = factorySuccess.inflate(R.layout.submission_successful, null);
                                        alertSuccess.setView(viewSuccess);

                                        AlertDialog alert = alertSuccess.create();

                                        if (alert.isShowing()) {
                                            alert.dismiss();
                                        }
                                        alertSuccess.show();
                                    }
                                    else{
                                        AlertDialog.Builder alertFail = new AlertDialog.Builder(SubmitActivity.this);
                                        LayoutInflater factoryFail = LayoutInflater.from(SubmitActivity.this);
                                        View viewFail = factoryFail.inflate(R.layout.submission_fail, null);
                                        alertFail.setView(viewFail);

                                        AlertDialog alert = alertFail.create();

                                        if (alert.isShowing()) {
                                            alert.dismiss();
                                        }

                                        alertFail.show();
                                    }
                                }
                            });
                        }
                    });
                    alertCheck.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertCheck.show();
                }

            }
        });

//        alertSuccess = new AlertDialog.Builder(this);
//        LayoutInflater factorySuccess = LayoutInflater.from(SubmitActivity.this);
//        viewSuccess = factorySuccess.inflate(R.layout.submission_successful, null);
//        alertSuccess.setView(viewSuccess);
//        alertSuccess.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dlg, int sumthin) {
//                dlg.dismiss();
//            }
//        });
//
//        alertFail = new AlertDialog.Builder(this);
//        LayoutInflater factoryFail = LayoutInflater.from(SubmitActivity.this);
//        viewFail = factoryFail.inflate(R.layout.submission_fail, null);
//        alertFail.setView(viewFail);
//        alertFail.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dlg, int sumthin) {
//                dlg.dismiss();
//            }
//        });


    }

    private Boolean getDataFromUser(){

        Boolean result = false;
        try{
            email = edEmail.getText().toString();
            firstName = edFirstName.getText().toString();
            lastName = edFirstName.getText().toString();
            githubLink = edGithubLink.getText().toString();

            result = true;
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(),"Please enter the missing Fields!",Toast.LENGTH_SHORT).show();
            result = false;
        }

        return result;

    }
}