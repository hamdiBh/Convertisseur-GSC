package isims.gsc.convertisseur;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    EditText montant;
    RadioGroup liste_choix;
    RadioButton tnd_eur;
    RadioButton eur_tnd;
    Button convertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        montant = (EditText) findViewById(R.id.montant);
        liste_choix = (RadioGroup) findViewById(R.id.liste_Choix);
        tnd_eur = (RadioButton) findViewById(R.id.tnd_eur);
        eur_tnd = (RadioButton) findViewById(R.id.eur_tnd);
        convertir = (Button) findViewById(R.id.convertir);

        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valeur = montant.getText().toString();
                double fl_valeur = Float.parseFloat(valeur);

                int choice = liste_choix.getCheckedRadioButtonId();
                double final_value=0;
                String  message="";
                if(choice == tnd_eur.getId()){
                    final_value = fl_valeur / 2.2;
                    message = fl_valeur + " Dinars = "+ final_value +"€";

                }
                if(choice == eur_tnd.getId()){
                    // to be ....
                    final_value = fl_valeur * 2.2;
                    message = fl_valeur + " € = "+ final_value +"Dinars";
                }

                Toast.makeText(
                        getApplicationContext(),
                        message,
                        Toast.LENGTH_SHORT).show();




            }
        });




    }


}
