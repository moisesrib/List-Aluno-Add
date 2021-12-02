package com.soy.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.soy.agenda.DAO.AlunoDAO;
import com.soy.agenda.R;
import com.soy.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Novo Aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private EditText campoData;
    final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        setTitle(TITLE_APPBAR);

        extracted();
        botaoSalvar();
    }

    private void botaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = getAluno();
                extracted(alunoCriado);
            }
        });
    }

    private void extracted() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        campoData = findViewById(R.id.activity_formulario_aluno_date);
    }

    private void extracted(Aluno aluno) {
        dao.salva(aluno);

        finish();
    }

    @NonNull
    private Aluno getAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        String date = campoData.getText().toString();

        Aluno alunoCriado = new Aluno(nome, telefone, email, date);
        return alunoCriado;
    }
}