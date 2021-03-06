package id.sch.smktelkom_mlg.project.xirpl109182736.amigo;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Cake;

public class DetailActivityCake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cake);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Cake cake = (Cake) getIntent().getSerializableExtra(MainActivityCake.CAKE);
        setTitle(cake.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(cake.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.desc_cake);
        tvDeskripsi.setText(cake.deskripsi);
        TextView tvBahan = (TextView) findViewById(R.id.bahan_cake);
        tvBahan.setText(cake.bahan);
        TextView tvCara = (TextView) findViewById(R.id.cara_cake);
        tvCara.setText(cake.cara);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
