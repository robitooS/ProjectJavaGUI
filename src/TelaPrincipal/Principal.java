package TelaPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Classes.ConectarAoBancoDeDados;
import TelasJFrame.Pesquisa;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal {

	private JFrame frmAgendaDeContatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmAgendaDeContatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgendaDeContatos = new JFrame();
		frmAgendaDeContatos.setTitle("Agenda de Contatos");
		frmAgendaDeContatos.setSize(800, 600);
		
		frmAgendaDeContatos.getContentPane().setLayout(null);
		
		JButton btnTestarConexaoBD = new JButton("Testar Conex\u00E3o com BD");
		btnTestarConexaoBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ConectarAoBancoDeDados().getConnection();
				 
				
				
			}
		});
		btnTestarConexaoBD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTestarConexaoBD.setBounds(491, 468, 266, 49);
		frmAgendaDeContatos.getContentPane().add(btnTestarConexaoBD);
		
		JTextArea txtrInstruesParaUso = new JTextArea();
		txtrInstruesParaUso.setEditable(false);
		txtrInstruesParaUso.setText("Instru\u00E7\u00F5es para uso da aplica\u00E7\u00E3o: \r\n1. Clique em \"Testar Conex\u00E3o com BD\" para estabelecer\r\na conex\u00E3o com o banco de dados. Em caso de erro, \r\naparecer\u00E1 uma mensagem de aviso, caso apare\u00E7a \r\nverifique as credenciais de conectividade com o banco de dados e tente novamente,\r\ncaso nao apare\u00E7a nenhum erro siga em frente com as instru\u00E7\u00F5es;\r\n\r\n2. Caso a conex\u00E3o seja estabelecida com sucesso, \r\nclique em \"Arquivo\" localizado no canto superior esquerdo\r\ne \"Contatos\" posteriormente;\r\n\r\n3. Se necess\u00E1rio alterar o cadastro de um contato,\r\nd\u00EA dois cliques no contato desejado, altere o que for necess\u00E1rio\r\ne clique em \"Alterar\"; \r\n\r\n4. Para encerrar a aplica\u00E7\u00E3o, clique em \"Ajuda\"\r\ne posteriormente \"Sair\"; ");
		txtrInstruesParaUso.setBounds(10, 11, 764, 427);
		frmAgendaDeContatos.getContentPane().add(txtrInstruesParaUso);
		
		JMenuBar menuBar = new JMenuBar();
		frmAgendaDeContatos.setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/arquivo.png")));
		menuBar.add(menuArquivo);
		
		JMenuItem subMenuContatos = new JMenuItem("Contatos");
		subMenuContatos.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/pesquisa.png")));
		subMenuContatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instanciando para ter acesso a tela
				Pesquisa telaPesquisa = new Pesquisa();
				
				//Deixando a tela de pesquisa visivel
				telaPesquisa.setVisible(true);
				
			}
		});
		menuArquivo.add(subMenuContatos);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/ajuda.png")));
		menuBar.add(menuAjuda);
		
		JMenuItem subMenuSair = new JMenuItem("Sair");
		subMenuSair.setIcon(new ImageIcon(Principal.class.getResource("/Imagens/sair.png")));
		subMenuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Fecho o formulário
				//Fecho o sistema
				frmAgendaDeContatos.dispose();
				
			}
		});
		menuAjuda.add(subMenuSair);
	}
}
