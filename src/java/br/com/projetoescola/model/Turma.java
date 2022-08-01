
package br.com.projetoescola.model;

public class Turma {
    private int idTurma;
    private String siglaTurma;
    private String periodoTurma;

    public Turma(int idTurma, String siglaTurma, String periodoTurma) {
        this.idTurma = idTurma;
        this.siglaTurma = siglaTurma;
        this.periodoTurma = periodoTurma;
    }
    
    public Turma() {
    }

    public Turma(int idTurma) {
        this.idTurma = idTurma;
    }

    public Turma(int idTurma, String siglaTurma) {
        this.idTurma = idTurma;
        this.siglaTurma = siglaTurma;
    }
    
    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getSiglaTurma() {
        return siglaTurma;
    }

    public void setSiglaTurma(String siglaTurma) {
        this.siglaTurma = siglaTurma;
    }

    public String getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(String periodoTurma) {
        this.periodoTurma = periodoTurma;
    }
    
    
}
