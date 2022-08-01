
package br.com.projetoescola.model;

public class Aluno {
   private int idAluno;
   private String nomeAluno;
   private Turma turma;
   private String telefoneAluno;

    public Aluno(int idAluno, String nomeAluno, Turma turma, String telefoneAluno) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.turma = turma;
        this.telefoneAluno = telefoneAluno;
    }

    public Aluno() {
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public void setTurma(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTelefoneAluno() {
        return telefoneAluno;
    }

    public void setTelefoneAluno(String telefoneAluno) {
        this.telefoneAluno = telefoneAluno;
    }
   
}
