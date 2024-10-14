package dominio;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.LinkedHashSet;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudoInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome){
        this.nome = nome;
    }

    public void inscrever(Bootcamp bootcamp){
        conteudoInscritos.addAll(bootcamp.getConteudos());
        // Adicionando a própria instância.
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        // Optinal lida com valores nulos, caso haja um.
        // Pegara o primeiro conteudo encontrado na lista.
        Optional<Conteudo> conteudo = conteudoInscritos.stream().findFirst();
        // Verifica se o conteúdo está presente.
        if(conteudo.isPresent()){
            conteudosConcluidos.add(conteudo.get());
            conteudoInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está inscrito em nenhum conteúdo!");
        }
    }

    public double calcularTotalXP(){
        // Usando stream para calcular o XP da lista.
        return conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudoInscritos() {
        return conteudoInscritos;
    }

    public void setConteudoInscritos(Set<Conteudo> conteudoInscritos) {
        this.conteudoInscritos = conteudoInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    // Definindo valores únicos:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudoInscritos, dev.conteudoInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudoInscritos, conteudosConcluidos);
    }
}
