package com.codeholics.pharmbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;

public class desc_activity extends AppCompatActivity {
    TextView description;
    String tv;
    ArrayList<database> a;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_activity);


        description = (TextView) findViewById(R.id.textView);
        Intent intent1 = new Intent();
        if (intent1.hasExtra("descrption")) ;
        {
            db = getIntent().getParcelableExtra("descrption");
            tv = db.getDescription();


            description.setText(tv);

        }

    }


    @Override
    protected void onStart() {
        super.onStart();
    }


}
