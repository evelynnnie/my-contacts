# MyContacts

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

## 📌 Contexto Institucional e Acadêmico
Este projeto foi desenvolvido como parte das atividades práticas de consolidação técnica da **Trilha de Desenvolvimento Java** dentro do programa **Capacita IREDE**. 

O **Capacita IREDE** é um programa de Capacitação e Residência Tecnológica financiado e promovido pelo **Ministério da Ciência, Tecnologia e Inovação (MCTI)** do Governo Federal, executado e coordenado pelo **IREDE** — instituição de referência em transformação digital e pesquisa no Nordeste. O programa visa impulsionar a carreira de jovens talentos no estado do Ceará, alinhando fundamentos teóricos sólidos com as exigências mais modernas do mercado digital.

---

## 💻 Sobre o Projeto: MyContacts
O **MyContacts** é uma aplicação desktop baseada em console projetada para o gerenciamento dinâmico de uma agenda de contatos em memória. O objetivo do sistema é aplicar de forma rigorosa os pilares da **Programação Orientada a Objetos (POO)** e criar uma arquitetura de código robusta, modular e resiliente a falhas.

### 🚀 Funcionalidades Principais
* **CRUD de Contatos:** Inserção, listagem abrangente, busca textual e remoção de registros de contatos.
* **Polimorfismo e Herança:** Cadastro inteligente capaz de diferenciar contatos convencionais de contatos comerciais (incluindo o atributo corporativo `empresa`).
* **Validação por Expressões Regulares (Regex):** Motor utilitário para checagem semântica de e-mails, garantindo integridade dos dados inseridos antes da instanciação do objeto.
* **Tratamento de Exceções Customizado:** Robustez contra erros de entrada no console (`InputMismatchException`) e tratamento automatizado para regras de negócio através de exceções personalizadas.

---

## 🗂️ Arquitetura do Sistema e Organização de Pacotes

A aplicação foi estruturada seguindo o padrão de separação de responsabilidades em pacotes isolados, garantindo alta coesão e baixo acoplamento:

```text
mycontacts/
├── app/
│   └── Main.java       # Interface do Usuário (UI), controle de fluxo e captura de dados.
├── controller/
│   └── Agenda.java     # Camada de controle. Gerencia o ArrayList e regras de negócio da agenda.
├── model/
│   ├── Contato.java    # Classe base (Superclasse) com atributos encapsulados.
│   └── ContatoComercial.java # Subclasse especializada que estende a classe Contato.
├── exceptions/
│   └── ContatoNaoEncontradoException.java # Exceção customizada (Checked) para erros de busca.
└── utils/
    └── ValidadorEmail.java # Utilitário estático com motor de Pattern Matching para e-mails.

```

---

## 🛠️ Conceitos de Programação Aplicados

* **Encapsulamento:** Restrição do acesso direto aos dados dos objetos através de atributos privados (`private`) expostos unicamente via métodos acessores (`getters` e `setters`).
* **Herança:** Extensão de tipos permitindo reutilização de código de forma hierárquica (`ContatoComercial extends Contato`).
* **Polimorfismo:** Sobrescrita de métodos herdados (`@Override`), permitindo que a lista genérica imprima comportamentos diferentes ao invocar o método `toString()`.
* **Java Collections Framework:** Uso de estruturas dinâmicas parametrizadas (`ArrayList<Contato>`) para manipulação de coleções de objetos.

---

## 📦 Como Executar a Aplicação

### Pré-requisitos

* Java Development Kit (JDK) 11 ou superior instalado.
* Git instalado para versionamento.

### Execução via Terminal:

1. Clone o repositório ou navegue até a pasta do projeto.
2. Compile os códigos-fonte da aplicação:
```bash
javac -d bin src/model/*.java src/exceptions/*.java src/utils/*.java src/controller/*.java src/app/Main.java

```


3. Execute o programa através da classe principal:
```bash
java -cp bin app.Main

```
