package Main;
import Agenda.Agenda;
import Contato.Contato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContatosGUI extends JFrame implements ActionListener {
	private Agenda agenda;
	private JTextField nomeField, telefoneField, nascimentoField, emailField, celularField;
	private JTextArea listaContatosArea;

	public ContatosGUI() {
		super("Agenda de Contatos");
        agenda = new Agenda();

        // Configurar o layout
        setLayout(new BorderLayout());

        // Painel de entrada de dados
        JPanel entradaPanel = new JPanel(new GridLayout(5, 2));
        entradaPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        entradaPanel.add(nomeField);
        entradaPanel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        entradaPanel.add(telefoneField);
        entradaPanel.add(new JLabel("Nascimento:"));
        nascimentoField = new JTextField();
        entradaPanel.add(nascimentoField);
        entradaPanel.add(new JLabel("E-mail:"));
        emailField = new JTextField();
        entradaPanel.add(emailField);
        entradaPanel.add(new JLabel("Celular:"));
        celularField = new JTextField();
        entradaPanel.add(celularField);

        // Botões
        JPanel botoesPanel = new JPanel();
        JButton adicionarButton = new JButton("Adicionar Contato");
        JButton excluirButton = new JButton("Excluir Contato");
        JButton pesquisarButton = new JButton("Pesquisar Contato");
        JButton listarButton = new JButton("Listar Contatos");

        adicionarButton.addActionListener(this);
        excluirButton.addActionListener(this);
        pesquisarButton.addActionListener(this);
        listarButton.addActionListener(this);

        botoesPanel.add(adicionarButton);
        botoesPanel.add(excluirButton);
        botoesPanel.add(pesquisarButton);
        botoesPanel.add(listarButton);

        // Área de exibição de contatos
        listaContatosArea = new JTextArea(15, 40);
        listaContatosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaContatosArea);

        // Adicionar componentes à janela
        add(entradaPanel, BorderLayout.NORTH);
        add(botoesPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("Adicionar Contato")) {
	        // Obter dados do campo de entrada
	        String nome = nomeField.getText();
	        String telefone = telefoneField.getText();
	        String nascimento = nascimentoField.getText();
	        String email = emailField.getText();
	        String celular = celularField.getText();

	        // Criar um novo contato
	        Contato novoContato = new Contato(nome, telefone, nascimento, email, celular);

	        // Adicionar o contato à agenda
	        agenda.adicionarContato(novoContato);

	        // Limpar campos de entrada
	        nomeField.setText("");
	        telefoneField.setText("");
	        nascimentoField.setText("");
	        emailField.setText("");
	        celularField.setText("");
	    } else if (e.getActionCommand().equals("Excluir Contato")) {
	        // Obter o nome do contato a ser excluído
	        String nomeExcluir = nomeField.getText();

	        // Excluir o contato da agenda
	        agenda.excluirContato(nomeExcluir);

	        // Limpar campo de entrada
	        nomeField.setText("");
	    } else if (e.getActionCommand().equals("Pesquisar Contato")) {
	        // Obter o nome do contato a ser pesquisado
	        String nomePesquisar = nomeField.getText();

	        // Pesquisar o contato na agenda
	        Contato contatoEncontrado = agenda.pesquisarContato(nomePesquisar);

	        // Exibir o contato encontrado (ou mensagem de erro) na área de texto
	        if (contatoEncontrado != null) {
	            listaContatosArea.setText("Contato encontrado:\n" +
	                    "Nome: " + contatoEncontrado.getNome() + "\n" +
	                    "Telefone: " + contatoEncontrado.getTelefone() + "\n" +
	                    "Nascimento: " + contatoEncontrado.getNascimento() + "\n" +
	                    "E-mail: " + contatoEncontrado.getEmail() + "\n" +
	                    "Celular: " + contatoEncontrado.getCelular());
	        } else {
	            listaContatosArea.setText("Contato não encontrado na agenda.");
	        }
	    } else if (e.getActionCommand().equals("Listar Contatos")) {
	        // Limpar a área de texto
	        listaContatosArea.setText("");
	        Contato contatoAux = null;
	        for (int i = 0; i < agenda.criarListaDeContatos().size(); i++) {
	            listaContatosArea.setText("Contato encontrado:\n" +
	                    "Nome: " + agenda.criarListaDeContatos().get(i).getNome() + "\n" +
	                    "Telefone: " + agenda.criarListaDeContatos().get(i).getTelefone() + "\n" +
	                    "Nascimento: " + agenda.criarListaDeContatos().get(i).getNascimento() + "\n" +
	                    "E-mail: " + agenda.criarListaDeContatos().get(i).getEmail() + "\n" +
	                    "Celular: " + agenda.criarListaDeContatos().get(i).getCelular());	
	        }
	    }
	}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ContatosGUI());
    }
}
