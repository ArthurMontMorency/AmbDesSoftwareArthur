package Agenda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Contato.Contato;

public class Agenda {
    private Map<String, Contato> contatos;

    public Agenda() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(Contato contato) {
        if (contatos.containsKey(contato.getNome())) {
            System.out.println("O contato já existe na agenda.");
        } else {
            contatos.put(contato.getNome(), contato);
            System.out.println("Contato adicionado com sucesso.");
        }
    }

    public void excluirContato(String nome) {
        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato não encontrado na agenda.");
        }
    }

    public Contato pesquisarContato(String nome) {
        if (contatos.containsKey(nome)) {
            return contatos.get(nome);
        } else {
            System.out.println("Contato não encontrado na agenda.");
            return null;
        }
    }

    public ArrayList<Contato> criarListaDeContatos() {
        ArrayList<Contato> listaDeContatos = new ArrayList<>(contatos.values());
        return listaDeContatos;
    }
}

