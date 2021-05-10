package deposito;

public class Produto {
	// ATRIBUTOS
	private String nome;
	private double preco;
//================================
	
 // CONSTRUTOR
	public Produto(String nome) {
		this.setNome(nome);
	}
//=================================
	// GETTERS E SETTERS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (!nome.equals("")) { // Se nome for diferente de 'vazio' ele altera, se não continua o mesmo valor
			this.nome = nome;
		}
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) { // Se o Preço for mair que 1
		if(preco >= 1) {				// Ele retorna o valor atribuido a preco
			this.preco = preco;
		}
	}

		
}
