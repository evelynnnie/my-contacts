package controller;

import java.util.ArrayList;
import model.Contato;
import exceptions.ContatoNaoEncontradoException;

public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<>();
    
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }
    
    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
            return;
        }
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }
    
    public Contato buscarPorNome(String nomeBuscado) throws ContatoNaoEncontradoException {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nomeBuscado)) {
                return contato;
            }
        }
        throw new ContatoNaoEncontradoException("O contato '" + nomeBuscado + "' nao foi encontrado.");
    }
    
    public void removerContato(String nomeBuscado) {
        boolean removido = contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nomeBuscado));
    
        if (removido) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato nao encontrado.");
        }
    }
}