package org.androidtpwn.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView labelUserName;
    EditText txtUserName;
    Button InputButton;

    RadioGroup radGender;
    RadioButton radMan;
    RadioButton radWoman;

    CheckBox chkSMS;
    CheckBox chkEMAIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelUserName=(TextView)findViewById(R.id.textView);
        txtUserName=(EditText)findViewById(R.id.name);

        radGender=(RadioGroup)findViewById(R.id.gender);
        radMan=(RadioButton)findViewById(R.id.man);
        radWoman=(RadioButton)findViewById(R.id.woman);

        chkSMS=(CheckBox)findViewById(R.id.SMS);
        chkEMAIL=(CheckBox)findViewById(R.id.email);

       InputButton=(Button)findViewById(R.id.button);
       InputButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v) {
               String userName = txtUserName.getText().toString();
               Intent intent = new Intent(getApplication(), NewActivity.class);
               intent.putExtra("txtUserName", userName);

               int radioId=radGender.getCheckedRadioButtonId();
               
               if(radMan.isChecked())
                   intent.putExtra("Gender"," 남");

               if(radWoman.isChecked())
                   intent.putExtra("Gender"," 여");

               if(chkSMS.isChecked())
                   intent.putExtra("Check"," SMS");

               if(chkEMAIL.isChecked())
                   intent.putExtra("Check"," e-mail");

               startActivity(intent);
           }
       });
    }
}
