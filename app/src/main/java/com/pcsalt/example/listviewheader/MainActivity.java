package com.pcsalt.example.listviewheader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.pcsalt.example.listviewheader.adapter.SectionedBaseAdapter;
import com.pcsalt.example.listviewheader.model.ListData;
import com.pcsalt.example.listviewheader.model.ListItem;
import com.pcsalt.example.listviewheader.model.ListSection;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<ListData> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        prepareContent();
        setAdapter();
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.list_view);
    }

    private void prepareContent() {
        for (int i = 0; i < 100; i++) {
            if (i == 0 || i % 7 == 0) {
                ListSection listSection = new ListSection();
                listSection.setTitle("Title: " + i);
                dataList.add(listSection);
            } else {
                ListItem listItem = new ListItem();
                listItem.setMessage(i + " % 7 == 1");
                listItem.setMessageLine2("" + (i % 7 == 1));
                dataList.add(listItem);
            }
        }
    }

    private void setAdapter() {
        SectionedBaseAdapter adapter = new SectionedBaseAdapter(MainActivity.this, dataList);
        listView.setAdapter(adapter);
    }

}
