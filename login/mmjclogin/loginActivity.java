package com.vu.mmjclogin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;

public class loginActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mUName, mPassword;
    private Button mButton;
    private CheckBox mCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mUName = (EditText) findViewById(R.id.etUsername);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mButton = (Button) findViewById(R.id.LButton);
        mCheckbox = (CheckBox) findViewById(R.id.checkbox);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save the checkbox preference
                if(mCheckbox.isChecked()){
                    //set a checkbox
                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    //save the name
                    String UName = mUName.getText().toString();
                    mEditor.putString(getString(R.string.UName), UName);
                    mEditor.commit();

                    String IUName = mUName.getText().toString();
                    mEditor.putString(getString(R.string.IUName), IUName);
                    mEditor.commit();

                    //save the password
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password), password);
                    mEditor.commit();

                    String Ipassword = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.Ipassword), Ipassword);
                    mEditor.commit();

                }else{
                    //set a checkbox
                    mEditor.putString(getString(R.string.checkbox), "False");
                    mEditor.commit();

                    //save the name
                    mEditor.putString(getString(R.string.UName), "");
                    mEditor.commit();

                    String IUName = mUName.getText().toString();
                    mEditor.putString(getString(R.string.IUName), IUName);
                    mEditor.commit();

                    //save the password
                    mEditor.putString(getString(R.string.password), "");
                    mEditor.commit();

                    String Ipassword = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.Ipassword), Ipassword);
                    mEditor.commit();
                }
            }
        });
    }

    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String UName = mPreferences.getString(getString(R.string.UName), "");
        String password = mPreferences.getString(getString(R.string.password), "");

        mUName.setText(UName);
        mPassword.setText(password);

        if(checkbox.equals("True")) {
            mCheckbox.setChecked(true);
        }else{
            mCheckbox.setChecked(false);
        }
    }
}