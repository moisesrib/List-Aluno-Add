package com.soy.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.soy.agenda.DAO.AlunoDAO;
import com.soy.agenda.R;

public class ListaAlunosActivity extends AppCompatActivity {

    private final AlunoDAO dao = new AlunoDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        setTitle("Lista de Alunos");

        extracted();
    }

    private void extracted() {
        FloatingActionButton botaoNovo = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        extracted(dao);
    }

    private void extracted(AlunoDAO dao) {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
