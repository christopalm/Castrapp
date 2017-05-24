package com.example.christopher.castrapp_1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import adapter.FeedListAdapter;
import data.FeedItem;

public class vac_Act extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<FeedItem> feedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vac_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        System.out.println("TAMANIO_CASTRA: " + main_Act.listaCastraciones.size());

        feedItems = new ArrayList<FeedItem>();
        listAdapter = new FeedListAdapter(this, feedItems);
        llenarViews();

        listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(listAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_castracion) {
            Intent actividadCastraciones = new Intent(this, main_Act.class);
            startActivity(actividadCastraciones);
            finish();
        } else if (id == R.id.nav_salud) {
            Intent actividadVacunaciones = new Intent(this, vac_Act.class);
            startActivity(actividadVacunaciones);
            finish();
        } else if (id == R.id.nav_adopta) {
            Intent actividadAdopciones = new Intent(this, adop_Act.class);
            startActivity(actividadAdopciones);
            finish();
        } else if (id == R.id.nav_general) {

        } else if (id == R.id.nav_consejo) {

        } else if (id == R.id.nav_grupos) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void llenarViews(){
        if(main_Act.listaVacunaciones.size()==0){
            TextView text1 = (TextView) findViewById(R.id.textView2);

            text1.setText("Lo sentimos, no existen jornadas de salud");

            Calendar cal = new GregorianCalendar();
            Date date = cal.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            //long time_Time_Actual = parsedDate.getTime() + TimeZone.getTimeZone("America/Guatemala").getRawOffset();

            String formattedDate = Long.toString(date.getTime());
            System.out.println(formattedDate);

            FeedItem feed = new FeedItem("000", "No encontradas", "https://www.facebook.com/rsrc.php/v3/yz/r/YYyCT7UcAGY.png", "Lo sentimos no se encontraron publicaciones de Jornadas de Salud en este momento, visite nuestro página en Facebook de Castrapp", "https://image.freepik.com/iconos-gratis/cara-triste-en-la-pagina-del-calendario_318-58090.jpg", formattedDate, "https://www.facebook.com/castrapp");
            feedItems.add(feed);
            listAdapter.notifyDataSetChanged();
        }
        else{
            for(int i=0; i<=main_Act.listaVacunaciones.size()-1; i++){
                FeedItem feedActual = main_Act.listaVacunaciones.get(i);

                feedItems.add(feedActual);
                listAdapter.notifyDataSetChanged();
            }
        }

    }
}
