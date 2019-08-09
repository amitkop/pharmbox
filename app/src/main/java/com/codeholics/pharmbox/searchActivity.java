package com.codeholics.pharmbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class searchActivity extends Activity {


    DatabaseReference ref;
    ArrayList<database> list;
    RecyclerView recyclerView;
    SearchView searchView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ref = FirebaseDatabase.getInstance().getReference().child("Database");
        recyclerView=(RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        searchView=(SearchView)findViewById(R.id.searchView);
        adapter=new MyAdapter(this,list);



    }





    @Override
    protected void onStart() {
        super.onStart();
        if (ref != null) {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    list=new ArrayList<>();
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        database db =ds.getValue(database.class);
                        list.add(db);
                    }
                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(searchActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        if(searchView!=null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return true;
                }
            });
        }
    }

    private void search(String str) {
        ArrayList<database> mylist= new ArrayList<>();

        for (database object : list) {
            if (object.getMedicine().toLowerCase().contains(str.toLowerCase())||object.getDisease().toLowerCase().contains(str.toLowerCase())) {
                mylist.add(object);

            }

        }

        MyAdapter adpater = new MyAdapter(this,mylist);
        recyclerView.setAdapter(adpater);
    }



}
