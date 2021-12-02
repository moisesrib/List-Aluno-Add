package com.soy.agenda.DAO;

import com.soy.agenda.model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }
    public List<Aluno> todos(){
        return new ArrayList<>(alunos);
    }
}
