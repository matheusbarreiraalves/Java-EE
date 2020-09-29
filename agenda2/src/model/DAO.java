package model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	/*** Conexão com o banco de dados ***/
	// parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Dba@123456";

	// método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/*** CRUD ***/
	/* CRUD - Create */
	public void novoContato(JavaBeans contato) {
		// criar a query(comando sql)
		String create = "insert into tbclientes (nomecliente,cpf,telefone,sexo) values (?,?,?,?)";
		try {
			// abrir a conexão com o banco
			Connection con = conectar();
			// preparar a query
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parâmetros(?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getNomecliente());
			pst.setString(2, contato.getCpf());
			pst.setString(3, contato.getTelefone());
			pst.setString(4, contato.getSexo());
			// executar a query (comando sql)
			pst.executeUpdate();
			// IMPORTANTE!!! fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD - Read */
	//método com retorno usando o ArrayList ligado ao JavaBeans
	public ArrayList<JavaBeans> listarContatos() {
		//Criar um vetor dinâmico para receber as variáveis, que serão armazenadas em JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		//query
		String read = "select * from tbclientes order by nomecliente";
		try {
			//abrir a conexão
			Connection con = conectar();
			//Preparar a query
			PreparedStatement pst = con.prepareStatement(read);
			//Executar a query, armazenando o conteúdo no objeto rs
			ResultSet rs = pst.executeQuery(); //2
			//Laço de repetição que será executado enquanto houver contatos
			while (rs.next()) {
				//teste de recebimento
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				//System.out.println(rs.getString(3));
				//System.out.println(rs.getString(4));
				//System.out.println(rs.getString(5));
				//criar variáveis locais para receber os contatos //3
				String idcliente = rs.getString(1);
				String nomecliente = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);
				String sexo = rs.getString(5);
				//"popular" (preencher) o vetor //4
				contatos.add(new JavaBeans(idcliente,nomecliente,cpf,telefone,sexo));
			}
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/* CRUD - Update */
	// Update 1 - Método para selecionar o contato
	public void listarContato(JavaBeans contato) {
		// query
		String update1 = "select * from tbclientes where idcliente=?";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(update1);
			// Substituir o parâmetro (?) pelo conteúdo id (JavaBeans)
			pst.setString(1, contato.getIdcliente()); // (4)
			// Executar a query, armazenando o conteúdo no objeto rs
			ResultSet rs = pst.executeQuery(); // (5)
			// Laço de repetição que será executado enquanto houver contatos
			while (rs.next()) {
				// teste de recebimento (6)
				// System.out.println(rs.getString(1));
				// System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
				// System.out.println(rs.getString(4));
				// setar as variáveis JavaBeans com o select (banco de dados)(6)(7)
				contato.setIdcliente(rs.getString(1));
				contato.setNomecliente(rs.getString(2));
				contato.setCpf(rs.getString(3));
				contato.setTelefone(rs.getString(4));	
				contato.setSexo(rs.getString(5));	
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Update 2 - Método para alterar o contato
	public void alterarContato(JavaBeans contato) {
		// query
		String update2 = "update tbclientes set nomecliente=?,cpf=?,telefone=?,sexo=? where idcliente=?";
		try {
			// abrir a conexão
			Connection con = conectar();
			// Preparar a query
			PreparedStatement pst = con.prepareStatement(update2);
			// substituir os parâmetros(?) pelo conteúdo JavaBeans (14)
			pst.setString(1, contato.getNomecliente());
			pst.setString(2, contato.getCpf());
			pst.setString(3, contato.getTelefone());
			pst.setString(4, contato.getSexo());
			pst.setString(5, contato.getIdcliente());
			//executar a query
			pst.executeUpdate(); //(15)
			//fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	/* CRUD - Delete */
	public void deletarContato(JavaBeans contato) {
		//query
		String delete = "delete from tbclientes where idcliente=?";
		try {
			//abrir a conexão
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			// substituir o parâmetro ? pelo conteúdo JavaBeans
			pst.setString(1, contato.getIdcliente()); //(4)
			// executar a query ("deletar o contato")
			pst.executeUpdate(); //(5)
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}