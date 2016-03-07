package net.infobosccoma.paisos.views.impl.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

import net.infobosccoma.paisos.R;
import net.infobosccoma.paisos.models.business.entities.Pais;
import net.infobosccoma.paisos.models.persistence.daos.impl.PaisosSQliteDAO;
import net.infobosccoma.paisos.models.persistence.daos.interfaces.PaisosDAO;
import net.infobosccoma.paisos.presenters.impl.DetailViewPresenterImpl;
import net.infobosccoma.paisos.presenters.interfaces.IDetailViewPresenter;
import net.infobosccoma.paisos.views.interfaces.IDetailView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DetailActivity extends AppCompatActivity implements IDetailView {

    private TextView txtName;
    private TextView txtArea;
    private TextView txtPopulation;
    private TextView txtCapital;
    private ImageView bandera;
    //private MediaPlayerControl reproductor;

    private IDetailViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        txtName = (TextView) findViewById(R.id.detail_txtview_name);
        txtArea = (TextView) findViewById(R.id.detail_txtview_area);
        txtPopulation = (TextView) findViewById(R.id.detail_txtview_population);
        bandera = (ImageView) findViewById(R.id.imageView);
        txtCapital = (TextView) findViewById(R.id.detail_txtview_capital);

        presenter = new DetailViewPresenterImpl();
        presenter.onCreate(this, getPaisFromIntent(getIntent()));

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }*/


    @Override
    public void setImage(String codiBandera) {
        //descarregarImatge(codiBandera);

        //CODI VELL IMATGES EN CARPETA ASSETS

        AssetManager assetManager = getAssets();
        String arxiu = codiBandera + ".jpg";
        InputStream istr = null;
        try {
            istr = assetManager.open(arxiu);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                arxiu = "no.jpg";
                istr = assetManager.open(arxiu);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        bandera.setImageBitmap(bitmap);
        //FI CODI VELL
/*
        CODI INTERNET
        try {
            Bitmap imatge = BitmapFactory.decodeStream((InputStream)new URL("http://developer.android.com/assets/images/dac_logo.png").getContent());
            bandera.setImageBitmap(imatge);
            Toast.makeText(getBaseContext(), urlBandera, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "ERROR! :(", Toast.LENGTH_LONG).show();
        } FI CODI INTERNET

        bandera.setImageBitmap(BitmapFactory.decodeFile(getAssets().open("Catalunya.jpg")));

        bandera.setImageDrawable(getResources().getDrawable(R.drawable.catalunya, getTheme()));
        per si tinguessim un ImageView, per exemple...*/
    }

    /*private class TascaDescarrega extends AsyncTask<String, Void, Bitmap> {
        private Bitmap loadImageFromNetwork(String imageURL) {
            try {
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageURL).getContent());
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        L'ASYNCH-TASK DELS COLLONS, NO HI HA MANERES DE FER-HO FUNCIONAR SENSE APRETAR UN BOTÓ PER DESCARREGAR L'IMATGE!

        @Override
        protected Bitmap doInBackground(String... urls) {
            return loadImageFromNetwork(urls[0]);
        }

        protected void onPostExecute(Bitmap result) {
            bandera.setImageBitmap(result);
        }
    }

    private Bitmap loadImageFromNetwork(String imageURL) {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imageURL).getContent());
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void descarregarImatge(String codiBandera) {
        new TascaDescarrega().execute("http://developer.android.com/assets/images/dac_logo.png");
    }*/

    @Override
    public void setName(String text) {
        txtName.setText(text);
    }

    @Override
    public void setArea(int area) {
        txtArea.setText(String.valueOf(area));
    }

    @Override
    public void setPopulation(int population) {
        txtPopulation.setText(String.valueOf(population));
    }

    @Override
    public void setCapital(String capital) {
        txtCapital.setText(String.valueOf(capital));
    }

    private Pais getPaisFromIntent(Intent intent) {
        return (Pais) Parcels.unwrap(intent.getParcelableExtra("PAIS"));
    }
/*
    @Override
    public void setHimne(String codiBandera) {
        reproductor.start();
    }
*/
    public void esborrarPais (View v) {
        PaisosDAO paisosDAO = new PaisosSQliteDAO(getBaseContext());
        paisosDAO.delete(getPaisFromIntent(getIntent()));
        Toast.makeText(this, "Pais esborrat correctament.", Toast.LENGTH_SHORT).show();
        finish();
    }

}
