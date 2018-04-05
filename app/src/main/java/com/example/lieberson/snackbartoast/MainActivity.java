package com.example.lieberson.snackbartoast;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View relativeLayout = findViewById(R.id.activity_main);

        fab = findViewById(R.id.fabId);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                final Snackbar snackbar = Snackbar.make(v, "Item Excluido", Snackbar.LENGTH_LONG);
                snackbar.setAction("Fechar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        snackbar.dismiss(); //para fechar a snackbar

                        Toast.makeText(MainActivity.this, "SnackBar Fechada", Toast.LENGTH_SHORT).show();
                    }
                });

                /*Customizando a Snackbar*/
                View snackView = snackbar.getView();
                snackView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark, null));
                /*Trocando a cor do texto da snackbar*/
                TextView snackActionView = snackView.findViewById(android.support.design.R.id.snackbar_action);
                snackActionView.setTextColor(getResources().getColor(android.R.color.white, null));

                snackbar.show();

            }
        });
    }
}
