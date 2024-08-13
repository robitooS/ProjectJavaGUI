package TelasJFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.DadosAgenda;
import Classes.OperacoesNoBancoDeDados;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Pesquisa extends JFrame {

	private JPanel contentPane;
	private JTextField txtConsulta;
	private JTextField txtQuantidadeItens;
	private JTable tabelaAgenda;
	private JButton btnExcluir;
	private JButton btnExportar;
	
	Alterar enviaTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisa frame = new Pesquisa();
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
	public Pesquisa() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				carregarItens();
				
			}
		});
		
		setTitle("Pesquisa");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//Point - Representa o local no espaço de coordenadas x e y
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		int largura = 800;
		int altura = 500;
		
		//Centralizar no meio da tela
		setBounds(centro.x - largura / 2, centro.y - altura / 2, 904, 554);
		
		setContentPane(contentPane);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(694, 9, 186, 41);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cadastro abreTela = new Cadastro();
				abreTela.setVisible(true);
				
			}
		});
		contentPane.setLayout(null);
		btnNovo.setIcon(new ImageIcon(Pesquisa.class.getResource("/Imagens/novo.png")));
		btnNovo.setMnemonic('N');
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNovo);
		
		JLabel lblNewLabel = new JLabel("Digite algo para pesquisar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 317, 33);
		contentPane.add(lblNewLabel);
		
		txtConsulta = new JTextField();
		txtConsulta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				String nome = "%" + txtConsulta.getText() + "%";
				
				OperacoesNoBancoDeDados itens = new OperacoesNoBancoDeDados();
				List<DadosAgenda> itensLista = itens.FiltrarDados(nome);
				
				
				DefaultTableModel dados = (DefaultTableModel) tabelaAgenda.getModel();
				
				//Limpa os dados da tabela
				dados.setNumRows(0);
				
				//for - para
				for(DadosAgenda linha : itensLista) {
					
					dados.addRow(new Object[] {
						
							linha.getId(),
							linha.getNome(),
							linha.getTelefone(),
							linha.getEmail(),
							linha.getEndereco(),
							linha.getNascimento(),
							linha.getFilhos()
							
					});
					
				}
				
				contarLinhasTabela();
				
			}
		});
		txtConsulta.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtConsulta.setBounds(10, 42, 580, 41);
		contentPane.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		txtQuantidadeItens = new JTextField();
		txtQuantidadeItens.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtQuantidadeItens.setBounds(10, 101, 403, 33);
		contentPane.add(txtQuantidadeItens);
		txtQuantidadeItens.setColumns(10);
		txtQuantidadeItens.setBorder(new LineBorder(Color.white, 1));
		txtQuantidadeItens.setBackground(new Color(255, 255, 255));
		txtQuantidadeItens.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 870, 306);
		contentPane.add(scrollPane);
		
		tabelaAgenda = new JTable();
		tabelaAgenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				//if - se
				if(e.getClickCount() == 2) { //Se der um duplo clique
					
					//Criando objeto que vai passar os dados da lista para a tabela
					DefaultTableModel model = (DefaultTableModel) tabelaAgenda.getModel();
					
					//Seleciona o número da linha
					int selecionaNumeroLinha = tabelaAgenda.getSelectedRow();
					
					if(enviaTexto == null){
						
						enviaTexto = new Alterar();
						enviaTexto.setVisible(true);
						enviaTexto.recebendo(model.getValueAt(selecionaNumeroLinha, 0).toString(),
								model.getValueAt(selecionaNumeroLinha, 1).toString(),
								model.getValueAt(selecionaNumeroLinha, 2).toString(),
								model.getValueAt(selecionaNumeroLinha, 3).toString(),
								model.getValueAt(selecionaNumeroLinha, 4).toString(),
								model.getValueAt(selecionaNumeroLinha, 5).toString(),
								model.getValueAt(selecionaNumeroLinha, 6).toString());
						
					}else {
						
						//Passa uma consta
						enviaTexto.setState(Alterar.NORMAL);
						enviaTexto.setVisible(true);
						
						enviaTexto.recebendo(model.getValueAt(selecionaNumeroLinha, 0).toString(),
								model.getValueAt(selecionaNumeroLinha, 1).toString(),
								model.getValueAt(selecionaNumeroLinha, 2).toString(),
								model.getValueAt(selecionaNumeroLinha, 3).toString(),
								model.getValueAt(selecionaNumeroLinha, 4).toString(),
								model.getValueAt(selecionaNumeroLinha, 5).toString(),
								model.getValueAt(selecionaNumeroLinha, 6).toString());
												
					}
					
				}
				
			}
		});
		tabelaAgenda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		scrollPane.setViewportView(tabelaAgenda);
		tabelaAgenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Telefone", "Email", "Endere\u00E7o", "Nascimento", "Filhos"
			}
		));
		
		//Aumentando a largura da linha
		tabelaAgenda.setRowHeight(50);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Criando objeto que vai passar os dados da lista para a tabela
				DefaultTableModel dados = (DefaultTableModel) tabelaAgenda.getModel();
				
				try {
					
					//Seleciona o número da linha
					int selecionaNumeroLinha = tabelaAgenda.getSelectedRow();
					
					DadosAgenda objeto = new DadosAgenda();
					
					int id = Integer.parseInt(dados.getValueAt(selecionaNumeroLinha, 0).toString());
					objeto.setId(id);
					
					OperacoesNoBancoDeDados excluirDados = new OperacoesNoBancoDeDados();
					excluirDados.Excluir(objeto);
					
					//Recarrega as informações da lista
					carregarItens();
					
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "Não há nenhum registro selecionado!");
					
				}
				
			}
		});
		btnExcluir.setIcon(new ImageIcon(Pesquisa.class.getResource("/Imagens/excluir.png")));
		btnExcluir.setMnemonic('E');
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluir.setBounds(694, 60, 186, 41);
		contentPane.add(btnExcluir);
		
		btnExportar = new JButton("Exportar");
		btnExportar.setIcon(new ImageIcon(Pesquisa.class.getResource("/Imagens/excel.png")));
		btnExportar.setMnemonic('E');
		btnExportar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExportar.setBounds(694, 111, 186, 41);
		contentPane.add(btnExportar);
		
		//Desabilitando a seleção da célula quando der um duplo clique
		tabelaAgenda.setDefaultEditor(Object.class, null);
		
		
		carregarItens();
		
		
	}
	
	//Metodo para carregar as informacoes
	public void carregarItens() {
		
		//Instanciando para ter acesso a classe
		OperacoesNoBancoDeDados itens = new OperacoesNoBancoDeDados();
		List<DadosAgenda> itensLista = itens.listarItens();
		
		//Criando objeto que vai passar os dados da lista para a tabela
		DefaultTableModel dados = (DefaultTableModel) tabelaAgenda.getModel();
		
		//Limpar os dados da tabela
		dados.setNumRows(0);
		
		//for - para
		for(DadosAgenda  linha : itensLista) {
			
			dados.addRow(new Object[] {
					
					linha.getId(),
					linha.getNome(),
					linha.getTelefone(),
					linha.getEmail(),
					linha.getEndereco(),
					linha.getNascimento(),
					linha.getFilhos()
					
			});
			
		}
		
		tabelaAgenda.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		//Ajustando a largura das colunas
		tabelaAgenda.getColumnModel().getColumn(0).setPreferredWidth(50); //Id
		tabelaAgenda.getColumnModel().getColumn(1).setPreferredWidth(200); //Nome
		tabelaAgenda.getColumnModel().getColumn(2).setPreferredWidth(200); //Telefone
		tabelaAgenda.getColumnModel().getColumn(3).setPreferredWidth(300); //Email
		tabelaAgenda.getColumnModel().getColumn(4).setPreferredWidth(200); //Endereco
		tabelaAgenda.getColumnModel().getColumn(5).setPreferredWidth(150); //Nascimento
		tabelaAgenda.getColumnModel().getColumn(6).setPreferredWidth(100); //Sexo
		
		contarLinhasTabela();
		
	}
	
	public void contarLinhasTabela() {
		
		int qtdLinhas = 0;
		
		qtdLinhas = tabelaAgenda.getRowCount();
		
		txtQuantidadeItens.setText("Total de registros: " + Integer.toString(qtdLinhas));
		
	}
}
