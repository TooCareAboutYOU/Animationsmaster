package com.animations.main;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.数据源
        String[] data = {"Translate Rotate","AnimatorSet","View Listener","View MotionEvent"};

        //2.适配器
        @SuppressWarnings("unchecked")
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        //3.绑定
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent=new Intent(MainActivity.this,FunctionActivity.class);
        intent.putExtra(FunctionActivity.TRANSLATE_ROTATE,position);
        startActivity(intent);
    }
}
