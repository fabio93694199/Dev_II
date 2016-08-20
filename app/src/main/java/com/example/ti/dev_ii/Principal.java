package com.example.ti.dev_ii;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Principal extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    Toolbar painel;
    private GoogleApiClient client;
    TabLayout abas;
    ViewPager paginaDasAbas;
    AdaptadorDePaginas adaptadorDePaginas;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove título desta Activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_principal);
        // GERADO AUTOMATICAMENTE PARA IMPLEMENTAR A API QUE DARÁ SUPORTE AO LAYOUT //
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio para mais informaçoes.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        /////////////////////////////////// PAINEL ///////////////////////////////////
        painel = (Toolbar) findViewById(R.id.IDpainel);
        setSupportActionBar(painel);
        /////////////////////////////////// ABAS /////////////////////////////////////
        abas = (TabLayout) findViewById(R.id.IDabas);
        /////////////////////////////// PAGINA DAS ABAS //////////////////////////////
        paginaDasAbas = (ViewPager) findViewById(R.id.IDviewPager);
        //////////////////////////// ADAPTAR AS PAGINAS //////////////////////////////
        adaptadorDePaginas = new AdaptadorDePaginas(getSupportFragmentManager());
        adaptadorDePaginas.addPaginas(new Pagina1(),"Primeira");
        adaptadorDePaginas.addPaginas(new Pagina2(),"Segunda");
        adaptadorDePaginas.addPaginas(new Pagina3(),"Terceira");
        //adaptadorDePaginas.addPaginas(new ItemFragment(),"test");
        //adaptadorDePaginas.addPaginas(new Teste(),"test");
        paginaDasAbas.setAdapter(adaptadorDePaginas);
        abas.setupWithViewPager(paginaDasAbas);
        //////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Principal Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ti.dev_ii/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Principal Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ti.dev_ii/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
