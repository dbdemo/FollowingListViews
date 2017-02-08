package com.example.administrator.headlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.headListView_List);
        String [] arr_data = {"数据1","数据2","数据3","数据4","数据1","数据2","数据3","数据4","数据1","数据2","数据3","数据4","数据1","数据2","数据3","数据4","数据1","数据2","数据3","数据4","数据1","数据2","数据3","数据4"};
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        listView.setAdapter(arr_adapter);
    }
}
