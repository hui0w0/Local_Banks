package sg.edu.rp.c346.id21016163.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btndbs;
    Button btnocbc;
    Button btnuob;
    String wordclicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndbs = findViewById(R.id.buttonDBS);
        btnocbc = findViewById(R.id.buttonOCBC);
        btnuob = findViewById(R.id.buttonUOB);


        registerForContextMenu(btndbs);
        registerForContextMenu(btnocbc);
        registerForContextMenu(btnuob);

    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if(v == btndbs){
            wordclicked = "DBS";
        }
        else if(v == btnocbc){
            wordclicked = "OCBC";
        }
        else if(v == btnuob){
            wordclicked = "UOB";
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if(wordclicked == "DBS") {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.dbs.com"));
                startActivity(intent);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: " + "18001111111"));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
        }
        else if(wordclicked == "OCBC") {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
                startActivity(intent);

                return true; //menu item successfully handled

            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: " + "18003633333"));
                startActivity(intent);

                return true;  //menu item successfully handled
            }
        }
            else if(wordclicked == "UOB") {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("http://www.uob.com"));
                    startActivity(intent);

                    return true; //menu item successfully handled

                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    Intent intent = new Intent(Intent. ACTION_DIAL, Uri.parse("tel: " + "18002222121"));
                    startActivity(intent);

                    return true;  //menu item successfully handled
                }
            }


        return super.onContextItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            btndbs.setText("DBS");
            btnocbc.setText("OCBC");
            btnuob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            btndbs.setText("星展银行");
            btnocbc.setText("华侨银行");
            btnuob.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}