package Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public class Restaurante {
	// atributtes
	private String cnpj;
	private String nome;
	private String descricao;
	private Cardapio cardapio;
	ArrayList<Pedido> pedidos;
	ArrayList<Funcionario> funcionarios;
	ArrayList<Entregador> entregadores;
	ArrayList<Admin> administradores;
	private String telefone;
	private String email;
	private Endereco endereco;
	private boolean status;
	private String site;

	// constructor with fields
	public Restaurante(String cnpj, String nome, String descricao, Cardapio cardapio, String telefone, String email, Endereco endereco, boolean status, String site) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.descricao = descricao;
		this.cardapio = cardapio;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.status = status;
		this.site = site;

		pedidos = new ArrayList<Pedido>();
		funcionarios = new ArrayList<Funcionario>();
		entregadores = new ArrayList<Entregador>();
		administradores = new ArrayList<Admin>();
	}

	public Restaurante(){
		//TODO criar usando docmuento
	}

/* getters and setters */

	// CNPJ
  public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	// Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Descricao
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// Models.Cardapio
	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	// Pedidos
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	// Funcionarios
	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	// Entregadores
	public ArrayList<Entregador> getEntregadores() {
		return entregadores;
	}

	// Administradores
	public ArrayList<Admin> getAdministradores() {
		return administradores;
	}

	// Telefone
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// E-mail
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Endereço
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// Status
	public boolean isStatus() {
		return status;
	}

	// Site
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	/* Métodos */

	@Override
	public String toString() {
		return "Models.Restaurante [cnpj=" + cnpj + ", nome=" + nome + ", descricao=" + descricao + ", cardapio=" + cardapio
				+ ", pedidos=" + pedidos + ", funcionarios=" + funcionarios + ", entregadores=" + entregadores
				+ ", administradores=" + administradores + ", telefone=" + telefone + ", email=" + email + 
				", endereço=" + endereco + ", status=" + status + ", site=" + site + "]";
	}

/*
	Função que adiciona um funcionario ao restaurante, se o usuario responsável pela
	ação for um administrador e o restaurante estiver habilitado.
	Além disso, adiciona no arquivo "funcionarios.txt".
	
	Args:
		- funcionario: Novo funcionário a ser adicionado ao restaurante
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o funcionário foi adicionado
		- false: significa que o funcionário não foi adicionado
*/
	public boolean adicionarFuncionario(Funcionario funcionario, Usuario usuarioResponsavel) {
		if (usuarioResponsavel.getClass() != Admin.class && !isStatus() && funcionarios.contains(funcionario)) {
			return false;
		}
		
		//manipulando o arquivo referente aos funcionários
		String filename = "data/funcionarios.txt";
		try {
			Formatter output = new Formatter(filename);
			//nome, cpf, email, telefone e status
			output.format("%s %s %s %s %s %s %d\n", funcionario.getNome(), funcionario.getCpf(), funcionario.getEmail(), funcionario.getTelefone(), funcionario.isStatus());
			output.flush();
			output.close();
			funcionarios.add(funcionario);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
/*
	Função que remove um funcionario do restaurante, se o usuario responsável pela
	ação for um administrador e o restaurante estiver habilitado.
	Além disso, remove esse funcionário do arquivo "funcionarios.txt"
	
	Args:
		- funcionario: Funcionário a ser removido do restaurante
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o funcionário foi removido
		- false: significa que o funcionário não foi removido
*/
	public boolean removerFuncionario(Funcionario funcionario, Usuario usuarioResponsavel) {
		if (usuarioResponsavel.getClass() != Admin.class && !isStatus() && !funcionarios.contains(funcionario)) {
			return false;
		}
		
		//manipulando o arwuivo referente a funcionarios
		File inputFile = new File("data/funcionarios.txt");
		File tempFile = new File("funcionariosTemp.txt");
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		
			//nome, cpf, email, telefone e status do funcionario a serem removidos
			String lineToRemove = funcionario.getNome() + funcionario.getCpf() + funcionario.getEmail() + funcionario.getTelefone() + funcionario.isStatus();
			String currentLine;
			
			while((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equals(lineToRemove)) continue;
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close();
			reader.close();
			tempFile.renameTo(inputFile);
			funcionarios.remove(funcionario);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return true;
	}

/*
	Função que adiciona um entregador ao restaurante, se o usuario responsável pela
	ação for um administrador e o restaurante estiver habilitado
	
	Args:
		- entregador: Novo entregador a ser adicionado ao restaurante
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o entregador foi adicionado
		- false: significa que o entregador não foi adicionado
*/
	public boolean adicionarEntregador(Entregador entregador, Usuario usuarioResponsavel) {
		if (usuarioResponsavel.getClass() != Admin.class && !isStatus() && entregadores.contains(entregador)) {
			return false;
		}
		
		//manipulando o arquivo referente aos entregadores
		String filename = "data/entregadores.txt";
		try {
			Formatter output = new Formatter(filename);
			//nome, cpf, email, telefone e status
			output.format("%s %s %s %s %s %s %d\n", entregador.getNome(), entregador.getCpf(), entregador.getEmail(), entregador.getTelefone(), entregador.isStatus());
			output.flush();
			output.close();
			entregadores.add(entregador);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return true;
	}

/*
	Função que remove um entregador do restaurante, se o usuario responsável pela
	ação for um administrador e o restaurante estiver habilitado
	
	Args:
		- entregador: entregador a ser removido do restaurante
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o entregador foi removido
		- false: significa que o entregador não foi removido
*/
	public boolean removerEntregador(Entregador entregador, Usuario usuarioResponsavel) {
		if (usuarioResponsavel.getClass() != Admin.class  && !isStatus() && !entregadores.contains(entregador)) {
			return false;
		}

		//manipulando o arwuivo referente a entregadores
		File inputFile = new File("data/entregadores.txt");
		File tempFile = new File("entregadorTemp.txt");
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		
			//nome, cpf, email, telefone e status do entregador a serem removidos
			String lineToRemove = entregador.getNome() + entregador.getCpf() + entregador.getEmail() + entregador.getTelefone() + entregador.isStatus();
			String currentLine;
			
			while((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equals(lineToRemove)) continue;
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close();
			reader.close();
			tempFile.renameTo(inputFile);
			entregadores.remove(entregador);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
				
		return true;
	}

/*
	Função que adiciona um administrador ao restaurante, se o usuario responsável pela
	ação for um administrador e o restaurante estiver habilitado
	
	Args:
		- admin: Novo administrador a ser adicionado ao restaurante
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o administrador foi adicionado
		- false: significa que o administrador não foi adicionado
*/
	public boolean adicionarAdministrador(Admin admin, Usuario usuarioResponsavel) {
		if (usuarioResponsavel.getClass() != Admin.class && !isStatus() && administradores.contains(admin)) {
			return false;
		}
		
		//manipulando o arquivo referente aos admins
		String filename = "data/administradores.txt";
		try {
			Formatter output = new Formatter(filename);
			//nome, cpf, email, telefone e status
			output.format("%s %s %s %s %s %s %d\n", admin.getNome(), admin.getCpf(), admin.getEmail(), admin.getTelefone(), admin.isStatus());
			output.flush();
			output.close();
			administradores.add(admin);
		}catch(IOException ex) {
			ex.printStackTrace();
		}

		return true;
	}

/*
	Função que remove um administrador do restaurante, se o usuario responsável pela
	ação for um administrador e o restaurante estiver habilitado
	
	Args:
		- admin: Administrador a ser removido do restaurante
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o administrador foi removido
		- false: significa que o administrador não foi removido
*/
	public boolean removerAdministrador(Admin admin, Usuario usuarioResponsavel) {
		if (usuarioResponsavel.getClass() != Admin.class && !isStatus() && !administradores.contains(admin)) {
			return false;
		}

		
		//manipulando o arwuivo referente a admins
		File inputFile = new File("data/administradores.txt");
		File tempFile = new File("administradoresTemp.txt");
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		
			//nome, cpf, email, telefone e status do entregador a serem removidos
			String lineToRemove = admin.getNome() + admin.getCpf() + admin.getEmail() + admin.getTelefone() + admin.isStatus();
			String currentLine;
			
			while((currentLine = reader.readLine()) != null) {
				String trimmedLine = currentLine.trim();
				if(trimmedLine.equals(lineToRemove)) continue;
				writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close();
			reader.close();
			tempFile.renameTo(inputFile);
			administradores.remove(admin);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
				
		return true;
	}

/*
	Função que adiciona um pedido ao restaurante, se o restaurante estiver habilitado
	
	Args:
		- pedido: Novo pedido a ser adicionado aos pedidos do restaurante

	Returns:
		- true: significa que o pedido foi adicionado
		- false: significa que o pedido não foi adicionado
*/
	public boolean adicionarPedido(Pedido pedido) {
		if (!isStatus()) {
			return false;
		}
				
		//manipulando o arquivo referente aos pedidos
		String filename = "data/pedidos.txt";
		try {
			Formatter output = new Formatter(filename);
			//cliente, valor, metodo de pagamento, status do pedido
			output.format("%s %.2f %s\n", pedido.getCliente(), pedido.getValor(), pedido.getMetodoPagamento().getDescricao(), pedido.getStatus().getDescricao());
			output.flush();
			output.close();
			pedidos.add(pedido);
		}catch(IOException ex) {
			ex.printStackTrace();
		}

		return true;
	}

/*
	Função que adiciona um cardapio ao restaurante, se o usuario responsável pela
	ação for um administrador ou funcionário e o restaurante estiver habilitado
	
	Args:
		- cardapio: Novo cardapio a ser adicionado ao restaurante
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o cardapio foi adicionado
		- false: significa que o cardapio não foi adicionado
*/
	public boolean adicionarCardapio(Cardapio cardapio, Usuario usuarioResponsavel) {
		if ((usuarioResponsavel.getClass() != Admin.class || usuarioResponsavel.getClass() != Funcionario.class 
		|| !funcionarios.contains(usuarioResponsavel) || !administradores.contains(usuarioResponsavel)) && !isStatus()) {
			return false;
		}
		
		this.cardapio = cardapio;

		return true;
	}

/*
	Função que altera o status do restaurante, se o usuario responsável pela
	ação for um administrador
	
	Args:
		- usuarioResponsavel: Usuário que está tentando realizar a ação de adição

	Returns:
		- true: significa que o status do restaurante foi modificado
		- false: significa que o status do restaurante não foi modificado
*/
	public boolean mudarStatusRestaurante(Usuario usuarioResponsavel) {
		if (usuarioResponsavel.getClass() != Admin.class || !administradores.contains(usuarioResponsavel)) {
			return false;
		}

		this.status = !isStatus();

		return true;
	}
}
