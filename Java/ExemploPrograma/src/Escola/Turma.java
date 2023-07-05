package Escola;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String identificador;
    private String horario;
    private Professor professorResponsavel;
    private List<Aluno> alunosMatriculados;
    private Curso curso;

    public Turma(String identificador, String horario, Professor professorResponsavel, Curso curso) {
        this.identificador = identificador;
        this.horario = horario;
        this.professorResponsavel = professorResponsavel;
        this.curso = curso;
        this.alunosMatriculados = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}