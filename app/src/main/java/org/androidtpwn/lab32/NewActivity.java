package org.androidtpwn.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        Reset=(Button)findViewById(R.id.button);

        final Intent passedIntent=getIntent();
        final String passedName=passedIntent.getStringExtra("txtUserName");
        final String passedGender=passedIntent.getStringExtra("Gender");
        final String passedCheck=passedIntent.getStringExtra("Check");

        textView1.setText("성명    : "+passedName);
        textView2.setText("성별    :"+passedGender);
        textView3.setText("수신여부:"+passedCheck);

        Reset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(getApplication(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
