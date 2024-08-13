package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class OperacoesNoBancoDeDados {
	
	//Atributo
	private Connection conexao;
	
	public OperacoesNoBancoDeDados() {
		
		//O nosso atributo conexao vai receber um nova conexão com o Banco de Dados
		this.conexao = new ConectarAoBancoDeDados().getConnection();
		
	}
	
	public void Cadastrar(DadosAgenda objeto) {
		
		try {
			
			//insert - Inserir
			//tabela_cadastro - tabela do banco de dados
			//values - Valores
			String informacoesSql = "insert into tabela_cadastro(nome, telefone, email, endereco, nascimento, filhos)"
					+ "values(?, ?, ?, ?, ?, ?)";
			
				//Preparando / Tratando a execução dos comando SQL
				PreparedStatement gravarInformacao = conexao.prepareStatement(informacoesSql);
				gravarInformacao.setString(1, objeto.getNome());
				gravarInformacao.setString(2, objeto.getTelefone());
				gravarInformacao.setString(3, objeto.getEmail());
				gravarInformacao.setString(4, objeto.getEndereco());
				gravarInformacao.setString(5, objeto.getNascimento());
				gravarInformacao.setString(6, objeto.getFilhos());
				
				//Executa os comando SQL
				gravarInformacao.execute();
				
				//fecha
				gravarInformacao.close();
				
				JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso!");
				
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar os dados!");
			
		}
		
		
	}
	
	//Metodo para listar todos os registros da agenda
	public List<DadosAgenda> listarItens(){
		
		
		try {
			
			List<DadosAgenda> lista = new ArrayList<>();
			
			//Select - Selecione
			//from - De / Da
			String sqlBancoDados = "Select * from tabela_cadastro";
			
			//Preparando / Tratando a execução dos comando SQL
			PreparedStatement lerInformacao = conexao.prepareStatement(sqlBancoDados);
			
			//A variável resultado vai receber o resultado da execução da Quero
			ResultSet resultado = lerInformacao.executeQuery();
			
			//while - Enquanto
			while(resultado.next()) {
				
				DadosAgenda linha = new DadosAgenda();
				linha.setId(resultado.getInt("id"));
				linha.setNome(resultado.getString("nome"));
				linha.setTelefone(resultado.getString("telefone"));
				linha.setEmail(resultado.getString("email"));
				linha.setEndereco(resultado.getString("endereco"));
				linha.setNascimento(resultado.getString("nascimento"));
				linha.setFilhos(resultado.getString("filhos"));
				
				lista.add(linha);
				
			}
			
			return lista;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao carregar os Dados: " + e);
		}
		
		return null;
	}
	
	public List<DadosAgenda> FiltrarDados(String nome){
		
		try {
			
			List<DadosAgenda> lista = new ArrayList<>();
			
			//Select - Selecione
			//from - De / Da
			//where - Onde
			//like - Valor aproximado
			String sqlBancoDados = "Select * from tabela_cadastro where nome like ?";
			
			//Preparando / Tratando a execução dos comando SQL
			PreparedStatement lerInformacao = conexao.prepareStatement(sqlBancoDados);
			
			lerInformacao.setString(1, nome);
			
			//A variável resultado vai receber o resultado da execução da Quero
			ResultSet resultado = lerInformacao.executeQuery();
			
			//while - Enquanto
			while(resultado.next()) {
				
				DadosAgenda linha = new DadosAgenda();
				linha.setId(resultado.getInt("id"));
				linha.setNome(resultado.getString("nome"));
				linha.setTelefone(resultado.getString("telefone"));
				linha.setEmail(resultado.getString("email"));
				linha.setEndereco(resultado.getString("endereco"));
				linha.setNascimento(resultado.getString("nascimento"));
				linha.setFilhos(resultado.getString("filhos"));
				
				lista.add(linha);
				
			}
			
			return lista;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao carregar os Dados: " + e);
		}
		
		return null;
	}
	
	public void Alterar(DadosAgenda objeto) {
		
		try {
			
			//update - Atualizar
			//set - Definir campos
			//tabela_cadastro - tabela do banco de dados
			//where - onde
			String informacoesSql = "update tabela_cadastro set nome=?, telefone=?, email=?, endereco=?, nascimento=?, filhos=?"
					+ "where id=?";
			
				//Preparando / Tratando a execução dos comando SQL
				PreparedStatement gravarInformacao = conexao.prepareStatement(informacoesSql);
				gravarInformacao.setString(1, objeto.getNome());
				gravarInformacao.setString(2, objeto.getTelefone());
				gravarInformacao.setString(3, objeto.getEmail());
				gravarInformacao.setString(4, objeto.getEndereco());
				gravarInformacao.setString(5, objeto.getNascimento());
				gravarInformacao.setString(6, objeto.getFilhos());
				gravarInformacao.setInt(7, objeto.getId());
				
				//Executa os comando SQL
				gravarInformacao.execute();
				
				//fecha
				gravarInformacao.close();
				
				JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
				
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao alterar os dados!");
			
		}
		
	}
	
	public void Excluir(DadosAgenda objeto) {
		
		try {
			
			//delete - Deleta / Excluir
			//From - de / da
			//where - onde
			String informacoesSql = "delete from tabela_cadastro where id = ?";
			
				//Preparando / Tratando a execução dos comando SQL
				PreparedStatement excluirInformacao = conexao.prepareStatement(informacoesSql);
				excluirInformacao.setInt(1, objeto.getId());
				
				//Executa os comando SQL
				excluirInformacao.execute();
				
				//fecha
				excluirInformacao.close();
				
				JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
				
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao excluir os registro!");
			
		}
		
	}

}
