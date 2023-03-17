package com.example.turonloversmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
            items = new ArrayList<>();
            itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.itemText, items);
            listView.setAdapter(itemsAdapter);
            setUpListViewListener();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Remove the item fro  m the list and update the adapter
                items.remove(i);
                itemsAdapter.notifyDataSetChanged();

                // Show a toast to indicate that the item has been deleted
                Context context = getApplicationContext();
                CharSequence text = "Item deleted";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, text, duration).show();

                // Return true to indicate that the long press event has been handled
                return true;
            }
        });
    }



    private void addItem(View view) {
        EditText input = findViewById(R.id.editTextTextPersonName);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            items.add(itemText);
            itemsAdapter.notifyDataSetChanged();
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"Please Enter a Text...",Toast.LENGTH_LONG).show();
        }
    }

}