package sg.edu.ep.c346.id20029318.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView DBS;
    TextView OCBC;
    TextView UOB;

    String wordClicked = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.txtDBS);
        OCBC =findViewById(R.id.txtOCBC);
        UOB =findViewById(R.id.txtUOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);

        DBS.setTextColor(getResources().getColor(android.R.color.black)); //set all to originally black
        OCBC.setTextColor(getResources().getColor(android.R.color.black));
        UOB.setTextColor(getResources().getColor(android.R.color.black));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu); //whether chinese/english, still change to default english
        if (v == DBS){
            wordClicked = "DBS";
        }
        else if (v == OCBC) {
            wordClicked = "OCBC";
        }
        else if (v == UOB) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String siteDBS = getString(R.string.siteDBS);
        String siteOCBC = getString(R.string.siteOCBC);
        String siteUOB = getString(R.string.siteUOB);
        String phDBS = getString(R.string.phDBS);
        String phOCBC = getString(R.string.phOCBC);
        String phUOB = getString(R.string.phUOB);
        // …
        if (wordClicked.equalsIgnoreCase("DBS")){
            if (item.getItemId() == R.id.WebSelect){
                Intent intentSite = new Intent(Intent.ACTION_VIEW, Uri.parse(siteDBS)); //direct to site address
                startActivity(intentSite);
                return true;
            }
            else if (item.getItemId() == R.id.ContactSelect) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phDBS)); //direct to their phone number
                startActivity(intentCall);
                return true;
            }
            else if (item.getItemId() == R.id.FavSelect) {
                if (DBS.getCurrentTextColor() == getResources().getColor(R.color.mahRed)) { //if red unfav to black
                    DBS.setTextColor(getResources().getColor(android.R.color.black));
                }
                else {
                    DBS.setTextColor(getResources().getColor(R.color.mahRed)); //or else favourite it to red
                }
            }
        }
        else if (wordClicked.equalsIgnoreCase("OCBC")){
            if (item.getItemId()==R.id.WebSelect){
                Intent intentSite = new Intent(Intent.ACTION_VIEW, Uri.parse(siteOCBC)); //direct to site address
                startActivity(intentSite);
            }
            else if (item.getItemId() == R.id.ContactSelect) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phOCBC)); //direct to their phone number
                startActivity(intentCall);
            }
            else if (item.getItemId() == R.id.FavSelect) {
                if (OCBC.getCurrentTextColor() == getResources().getColor(android.R.color.black)) { //if black to red
                    OCBC.setTextColor(getResources().getColor(R.color.mahRed));
                }
                else {
                    OCBC.setTextColor(getResources().getColor(android.R.color.black)); //or else red to black
                }
            }
        }
        else if (wordClicked.equalsIgnoreCase("UOB")){
            if (item.getItemId()==R.id.WebSelect){
                Intent intentSite = new Intent(Intent.ACTION_VIEW, Uri.parse(siteUOB)); //direct to site address
                startActivity(intentSite);
            }
            else if (item.getItemId() == R.id.ContactSelect) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phUOB)); //direct to their phone number
                startActivity(intentCall);
            }
            else if (item.getItemId() == R.id.FavSelect) {
                if (UOB.getCurrentTextColor() == getResources().getColor(android.R.color.black)) { //if black to red
                    UOB.setTextColor(getResources().getColor(R.color.mahRed));
                }
                else {
                    UOB.setTextColor(getResources().getColor(android.R.color.black)); //or else red to black
                }
            }
        }

        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_lang,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        int id = item.getItemId();

        String eDBS = getString(R.string.txtDBS);
        String eOCBC = getString(R.string.txtOCBC);
        String eUOB = getString(R.string.txtUOB);

        String cDBS = getString(R.string.chin_DBS);
        String cOCBC = getString(R.string.chin_OCBC);
        String cUOB = getString(R.string.chin_UOB);


        if (id == R.id.ChinSelect) { //choose chinese change all to chinese
            DBS.setText(cDBS);
            OCBC.setText(cOCBC);
            UOB.setText(cUOB);

        }
        else if (id == R.id.EngSelect) { // all changed to english
            DBS.setText(eDBS);
            OCBC.setText(eOCBC);
            UOB.setText(eUOB);
        }
        return  super.onOptionsItemSelected(item);
    }
}