package com.example.bboyc.todolist;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    ArrayAdapter<String> arrayAdapter2;
    ArrayList<String> array2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView) findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.list_todo);
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        textView.setText(title);
        arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array2);
        listView.setAdapter(arrayAdapter2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                final EditText input = new EditText(Main2Activity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
//                input.getAction(ACTION_DOWN);

                builder.setView(input)

                        .setMessage("New Task")

                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {


                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                array2.add(input.getText().toString());
                                arrayAdapter2.notifyDataSetChanged();

                            }
                        })

                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                Dialog dialog = builder.create();
                dialog.show();

            }
        });
    }

}
