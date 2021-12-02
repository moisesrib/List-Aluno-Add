package com.soy.agenda.model;

public class Aluno {
    private final String nome;
    private final String telefone;
    private final String email;
    private final String date;

    public Aluno(String nome, String telefone, String email, String date) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.date = date;
    }
    @Override
    public String toString() {
        return nome;
    }
}