package TelasJFrame;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.DadosAgenda;
import Classes.OperacoesNoBancoDeDados;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alterar extends JFrame {

	private JPanel contentPane;
	private JTextField txtAlterarDados_ID;
	private JTextField txtAlterarDados_Nome;
	private JTextField txtAlterarDados_Telefone;
	private JTextField txtAlterarDados_Email;
	private JTextField txtAlterarDados_Endereco;
	private JTextField txtAlterarDados_Nascimento;
	private JComboBox cmbAltrarDados_Filhos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alterar frame = new Alterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Alterar() {
		setTitle("Alterar Dados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//Point - Representa o local no espaço de coordenadas x e y
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		int largura = 800;
		int altura = 500;
		
		//Centralizar no meio da tela
		setBounds(centro.x - largura / 2, centro.y - altura / 2, 800, 586);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(35, 31, 246, 39);
		contentPane.add(lblNewLabel);
		
		txtAlterarDados_ID = new JTextField();
		txtAlterarDados_ID.setEnabled(false);
		txtAlterarDados_ID.setEditable(false);
		txtAlterarDados_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAlterarDados_ID.setText("J\u00E1 adicionado automaticamente");
		txtAlterarDados_ID.setBounds(30, 70, 382, 39);
		contentPane.add(txtAlterarDados_ID);
		txtAlterarDados_ID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNome.setBounds(40, 142, 246, 39);
		contentPane.add(lblNome);
		
		txtAlterarDados_Nome = new JTextField();
		txtAlterarDados_Nome.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtAlterarDados_Nome.setColumns(10);
		txtAlterarDados_Nome.setBounds(35, 181, 508, 39);
		contentPane.add(txtAlterarDados_Nome);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTelefone.setBounds(35, 243, 246, 39);
		contentPane.add(lblTelefone);
		
		txtAlterarDados_Telefone = new JTextField();
		txtAlterarDados_Telefone.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtAlterarDados_Telefone.setColumns(10);
		txtAlterarDados_Telefone.setBounds(30, 282, 227, 39);
		contentPane.add(txtAlterarDados_Telefone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEmail.setBounds(281, 243, 246, 39);
		contentPane.add(lblEmail);
		
		txtAlterarDados_Email = new JTextField();
		txtAlterarDados_Email.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtAlterarDados_Email.setColumns(10);
		txtAlterarDados_Email.setBounds(276, 282, 267, 39);
		contentPane.add(txtAlterarDados_Email);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEndereo.setBounds(35, 346, 246, 39);
		contentPane.add(lblEndereo);
		
		txtAlterarDados_Endereco = new JTextField();
		txtAlterarDados_Endereco.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtAlterarDados_Endereco.setColumns(10);
		txtAlterarDados_Endereco.setBounds(30, 385, 513, 39);
		contentPane.add(txtAlterarDados_Endereco);
		
		JLabel lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNascimento.setBounds(35, 449, 246, 39);
		contentPane.add(lblNascimento);
		
		txtAlterarDados_Nascimento = new JTextField();
		txtAlterarDados_Nascimento.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtAlterarDados_Nascimento.setColumns(10);
		txtAlterarDados_Nascimento.setBounds(30, 488, 227, 39);
		contentPane.add(txtAlterarDados_Nascimento);
		
		JLabel lblNewLabel_5_1 = new JLabel("Filhos:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_5_1.setBounds(281, 449, 246, 39);
		contentPane.add(lblNewLabel_5_1);
		
		cmbAltrarDados_Filhos = new JComboBox();
		cmbAltrarDados_Filhos.setModel(new DefaultComboBoxModel(new String[] {"-", "Sim", "N\u00E3o"}));
		cmbAltrarDados_Filhos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cmbAltrarDados_Filhos.setBounds(281, 488, 273, 39);
		contentPane.add(cmbAltrarDados_Filhos);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DadosAgenda objeto = new DadosAgenda();
				objeto.setId(Integer.parseInt(txtAlterarDados_ID.getText()));
				objeto.setNome(txtAlterarDados_Nome.getText());
				objeto.setTelefone(txtAlterarDados_Telefone.getText());
				objeto.setEmail(txtAlterarDados_Email.getText());
				objeto.setEndereco(txtAlterarDados_Endereco.getText());
				objeto.setNascimento(txtAlterarDados_Nascimento.getText());
				objeto.setFilhos(cmbAltrarDados_Filhos.getSelectedItem().toString());
				
				OperacoesNoBancoDeDados salvarDados = new OperacoesNoBancoDeDados();
				salvarDados.Alterar(objeto);
				
				//fecho a tela
				dispose();
				
			}
		});
		btnAlterar.setIcon(new ImageIcon(Alterar.class.getResource("/Imagens/salvar.png")));
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnAlterar.setBounds(578, 31, 168, 50);
		contentPane.add(btnAlterar);
		
		
	}
	
	public void recebendo(String Id, String Nome, String Tel, String Email, String End, String Nasc, String Filhos) {
		
		
		txtAlterarDados_ID.setText(Id);
		txtAlterarDados_Nome.setText(Nome);
		txtAlterarDados_Telefone.setText(Tel);
		txtAlterarDados_Email.setText(Email);
		txtAlterarDados_Endereco.setText(End);
		txtAlterarDados_Nascimento.setText(Nasc);
		cmbAltrarDados_Filhos.setSelectedItem(Filhos);
		
		
		
		
		
	}
}
