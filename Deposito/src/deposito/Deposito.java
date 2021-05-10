package deposito;
import java.util.ArrayList;

public class Deposito {
	// ATRIBUTOS
	private ArrayList <Cerveja> cerveja;
	private ArrayList <Refrigerante> refrigerante;
	private int capacidade_produto;
//===========================================================
	
	// CONSTRUTOR
	public Deposito(int capacidade) {
		this.setCapacidade_produto(capacidade);
		this.setCerveja(new ArrayList<Cerveja>());
		this.setRefrigerante(new ArrayList<Refrigerante>());
	}
//=============================================================
	
	// SETTERS E GETTERS
	public ArrayList <Cerveja> getCerveja() {
		return cerveja;
	}
	public void setCerveja(ArrayList <Cerveja> cerveja) {
		this.cerveja = cerveja;
	}
	public ArrayList <Refrigerante> getRefrigerante() {
		return refrigerante;
	}
	public void setRefrigerante(ArrayList <Refrigerante> refrigerante) {
		this.refrigerante = refrigerante;
	}
	public int getCapacidade_produto() {
		return capacidade_produto;
	}
	public void setCapacidade_produto(int capacidade_produto) {
		if(capacidade_produto > 0) { // Se a capacidade do deposito for maior que 0, ele retorna o valor passado
			this.capacidade_produto = capacidade_produto;
		}
	}
//==========================================================================
	
	// MÉTODOS
	private boolean vetifica_capacidade_produto() { // Retorna True ou false, e vai ser usado para testar se já chegou ou não na capacidade maxima
		return this.getCerveja().size() + this.getRefrigerante().size() >= this.getCapacidade_produto();
	}
	
	private boolean produtoCerveja(Produto produto){ // Diz se o produto é uma cerveja
		return produto.getClass().getSimpleName().equals("Cerveja");
	}
	
	private boolean produtoRefrigerante(Produto produto){ // Diz se o produto é um refrigerante
		return produto.getClass().getSimpleName().equals("Refrigerante");
	}
	
	public void mostra_Produtos(){ // Lista e mostra os produtos que estão cadastrados
		System.out.println("<============================>");
		System.out.println("| PRODUTOS JÁ CADASTRADOS    |");
		 int cont = 0;
		 System.out.println("<=========CERVEJA============>");
		for (Cerveja c : this.getCerveja()) {
			System.out.printf("|%sº) %s --------- %.2f\n",(cont+1), c.getNome(), c.getPreco());
				cont++;
			 // Mostrando as cervjas que tem no estoque
			 // Mostrando os preços das cervejas
		}
		System.out.println("<========REFRIGERANTE========>");
			int cont2 = 0;
		for (Refrigerante r : this.getRefrigerante()) {
			System.out.printf("|%sº) %s --------- %.2f\n",(cont2+1),r.getNome(), r.getPreco());
			cont2++;
			 // Mostrando os refrigerantes
			 // Mostrando os Preços
		}
		System.out.println("<============================>");
	}
	
	
	public void cadastrarProduto(Produto produto){ // Verifica se tem espaço no estoque para adicionar
													// Um novo produto
		if(this.vetifica_capacidade_produto()){ // Diz se capacidade chegou ao limite 
			System.out.println("<===================================>");
			System.out.println("| Atingimos nossa Cpacidade Máxima !|");
			System.out.println("<===================================>");
			
			
		}else{ // Se a capacidade maxima não for atinginda, ele adiciona o novo produto
			if(produtoCerveja(produto)){ // que pode ser cerveja
				this.getCerveja().add((Cerveja) produto);
				
			}else{
				if (produtoRefrigerante(produto)){ // ou refrigenrante
					this.getRefrigerante().add((Refrigerante) produto);
				}
			}
		}
		
		
	}
	
	
	
	public void remove_Produto(Produto produto){  // Procura se existe o produto e se ele está cadastrado
		if(this.produtoCerveja(produto)){		// E o remove caso ele esteja cadastrado
			
			if(this.getCerveja().contains(produto)){ // Verifica se o produto existe
				this.getCerveja().remove(produto); // Remove o produto
			}else{
				System.out.println("PRODUTO NÃO ENCONTRADO !");
			}
			
		}else{
			if (this.produtoRefrigerante(produto)){ // // Procura se existe o produto e se ele está cadastrado
				if(this.getRefrigerante().contains(produto)){ // Verifica se o produto está 
					this.getRefrigerante().remove(produto); // Remove o produto
				}else{
					System.out.println("PRODUTO NÃO ENCONTRADO !");
				}
			}
			
		}
		
	}
	
//========================================================================

}
