package com.sample.prajakta.mytodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemName = getIntent().getStringExtra("itemName");
        pos = getIntent().getIntExtra("position",0);
        EditText etItemName = (EditText) findViewById(R.id.etEditItem);
        etItemName.setText(itemName);
    }

    public void onSave(View v) {
        EditText etItemName = (EditText) findViewById(R.id.etEditItem);
        String itemName = etItemName.getText().toString();
        Intent i = new Intent(EditItemActivity.this, TodoActivity.class);
        i.putExtra("code",20);
        i.putExtra("pos",pos);
        i.putExtra("newName",itemName);
        setResult(RESULT_OK, i);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
