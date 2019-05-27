package com.example.baseadapterlistviewfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextWatcher {


    EditText editText;
    ListView listView;

    String[] name = {"Apple","Sachitha","Man","Ann","Sachitha"};
    String[] age = {"10","20","30","40","10"};
    ArrayList<SingleRow> myList;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        listView = findViewById(R.id.list);

        editText.addTextChangedListener(this);


        myList = new ArrayList<>();
        SingleRow singleRow;

        for(int i = 0; i < name.length;i++){
            singleRow = new SingleRow(name[i],age[i]);

            myList.add(singleRow);
        }

        myAdapter = new MyAdapter(this,myList);

        listView.setAdapter(myAdapter);
    }


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        this.myAdapter.getFilter().filter(s);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
