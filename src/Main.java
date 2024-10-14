import dominio.Bootcamp;
import dominio.Curso;
import dominio.Dev;
import dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoJava = new Curso("Curso de java", "Curso básico de java 22.", 40);
        Curso cursoPhp = new Curso("Curso de PHP", "Curso básico de PHP moderno.", 40);
        Mentoria mentoriaJava = new Mentoria("Mentoria sobre Java.", "Mentoria sobre a linguagem de programação java.", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Java Developer.", "Descrição Bootcamp java developer.");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoPhp);
        bootcamp.getConteudos().add(mentoriaJava);

        Dev devDiogo = new Dev("Diogo");
        devDiogo.inscrever(bootcamp);
        devDiogo.progredir();
        devDiogo.progredir();
        Dev devJoao = new Dev("João");
        devJoao.inscrever(bootcamp);
        devJoao.progredir();

        System.out.println("Conteúdos inscritos" + devDiogo.getConteudoInscritos());
        System.out.println("Conteúdos inscritos" + devDiogo.getConteudosConcluidos());
        System.out.println("----------------");
        System.out.println("Conteúdos inscritos" + devJoao.getConteudoInscritos());
        System.out.println("Conteúdos inscritos" + devJoao.getConteudosConcluidos());
        System.out.println("-----------");
        System.out.println("XP Diogo: " + devDiogo.calcularTotalXP());
        System.out.println("XP João: " + devJoao.calcularTotalXP());
    }
}
