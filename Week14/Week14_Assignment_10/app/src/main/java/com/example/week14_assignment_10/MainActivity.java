package com.example.week14_assignment_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 전화번호부");

        final ArrayList<String> nameList=new ArrayList<>();
        final ArrayList<String> numList=new ArrayList<>();
        ListView list=findViewById(R.id.listView);

        CustomAdapter adapter=new CustomAdapter(this);
        list.setAdapter(adapter);

        final EditText edtname=findViewById(R.id.edtName);
        final EditText edtnum=findViewById(R.id.edtName);
        Button btnAdd=findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameList.add(edtname.getText().toString());
                numList.add(edtnum.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                nameList.remove(position);
                numList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    private class CustomAdapter extends BaseAdapter{
        Context context;
        ArrayList<String> nameList;
        ArrayList<String> numList;

        public CustomAdapter(Context context){
            this.context=context;
            nameList=new ArrayList<>();
            numList=new ArrayList<>();
        }

        public int getCount(){
            return nameList.size();
        }

        public Object getItem(int i){
            return null;
        }

        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView=View.inflate(context, R.layout.item, null);
            TextView name=itemView.findViewById(R.id.name);
            TextView number=itemView.findViewById(R.id.number);

            name.setText(nameList[position] );
        }
    }
}