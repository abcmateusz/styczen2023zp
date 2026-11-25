
package com.example.styczen2023zp;

import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nowyElement = findViewById(R.id.nowyElement);
        Button dodajBtn = findViewById(R.id.dodajBtn);
        ListView listaView = findViewById(R.id.Lista);

        ArrayList<String> lista = new ArrayList<>();

        lista.add("Zakupy: chleb, masło, ser");
        lista.add("Do zrobienia: obiad, umyć podłogi");
        lista.add("Weekend: kino, spacer z psem");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                lista
        );

        listaView.setAdapter(adapter);

        dodajBtn.setOnClickListener(v -> {

            String tekst = nowyElement.getText().toString();

            if (!tekst.trim().isEmpty()) {
                lista.add(tekst);
                adapter.notifyDataSetChanged();
                nowyElement.setText("");
            }

        });
    }
}
