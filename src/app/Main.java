package app;

import java.util.Scanner;
import controller.Agenda;
import model.Contato;
import model.ContatoComercial; 
import exceptions.ContatoNaoEncontradoException;
import java.util.InputMismatchException; 
import utils.ValidadorEmail;

public class Main {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Agenda agenda = new Agenda();
            int opcao = 0;
            
            while(opcao != 5){
                try {
                    System.out.println("\n===== AGENDA DE CONTATOS =====");
                    System.out.println("1. Adicionar novo contato");
                    System.out.println("2. Listar contatos");
                    System.out.println("3. Buscar por nome");
                    System.out.println("4. Remover contato");
                    System.out.println("5. Sair");
                    
                    System.out.print("Escolha uma opcao: ");
                    opcao = scan.nextInt();
                    scan.nextLine(); 
                    
                    switch (opcao){
                        case 1:
                            System.out.print("Nome: ");
                            String nome = scan.nextLine();

                            System.out.print("Telefone: ");
                            String telefone = scan.nextLine();

                            String email = "";
                            while (true) {
                                System.out.print("E-mail: ");
                                email = scan.nextLine();

                                if (ValidadorEmail.validar(email)) {
                                    break; 
                                } else {
                                    System.out.println("Formato de e-mail inválido! Tente novamente (ex: nome@email.com).");
                                }
                            }

                            System.out.print("O contato é comercial? (S/N): ");
                            String tipo = scan.nextLine();

                            if (tipo.equalsIgnoreCase("S")) {
                                System.out.print("Empresa: ");
                                String empresa = scan.nextLine();
                                ContatoComercial comercial = new ContatoComercial(nome, telefone, email, empresa);
                                agenda.adicionarContato(comercial);
                            } else {
                                Contato contato = new Contato(nome, telefone, email);
                                agenda.adicionarContato(contato);
                            }

                            System.out.println("Contato adicionado com sucesso!");
                            break;
                            
                        case 2:
                            agenda.listarContatos();
                            break;
                            
                        case 3:
                            System.out.print("Digite o nome do contato: ");
                            String nomeBuscado = scan.nextLine();
                            try {
                                Contato encontrado = agenda.buscarPorNome(nomeBuscado);
                                System.out.println(encontrado);
                            } catch (ContatoNaoEncontradoException e) {
                                System.out.println(e.getMessage()); 
                            }
                            break;
                            
                        case 4:
                            System.out.print("Digite o nome do contato: ");
                            String nomeRemover = scan.nextLine();
                            agenda.removerContato(nomeRemover);
                            break;
                            
                        case 5:
                            System.out.println("Encerrando sistema...");
                            break;
                            
                        default:
                            System.out.println("Opcao invalida! Digite um numero de 1 a 5.");
                            break; 
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, digite um numero.");
                    scan.nextLine(); 
                    opcao = 0; 
                }
            }
        }
    }
}