package deposito;

import java.util.Scanner;

public class TESTE_DEPOSITO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int resp;
		int resp_bebida;
		String resp_ver;
		int resp_remover;
		int resp_remover2;
		
		// PRODUTOS JÁ CADASTRADOS
		Cerveja c = new Cerveja("Skol");
		c.setPreco(2.50);
		Cerveja c1 = new Cerveja("Antartica");
		c1.setPreco(6.50);
		Cerveja c2 = new Cerveja("Brahma");
		c2.setPreco(4.50);
		Cerveja c3 = new Cerveja("Glacial");
		c3.setPreco(4.10);
		Refrigerante r = new Refrigerante("Cola-Cola");
		r.setPreco(7.50);
		Refrigerante r1 = new Refrigerante("Guarana");
		r1.setPreco(6.50);
		Refrigerante r2 = new Refrigerante("Fanta");
		r2.setPreco(5.50);
		
//=================================================
		Deposito d = new Deposito(8); // Limite de Estoque
		d.cadastrarProduto(c);
		d.cadastrarProduto(c1);
		d.cadastrarProduto(c2);
		d.cadastrarProduto(c3);
		d.cadastrarProduto(r);
		d.cadastrarProduto(r1);
		d.cadastrarProduto(r2);
//====================================================
		
		
		// PROGRAMA PRINCIPAL 
		System.out.println("<=ESTOQUE DE PRDUTOS=>");
		System.out.println("<=======MENU=========>");
		System.out.println("1º)   Cadastrar      |");
		System.out.println("2º)   Remover        |");
		System.out.println("<====================>");
		
		System.out.print("Opção: "); // Perguntando se deseja cadastrar ou não
		resp = input.nextInt(); // Pegando a resposta e passando tudo para minusculo
		
		if(resp == 1) { // Se a resposta for sim ele mostra quais tipos de produtos você pode cadastrar
			System.out.println("<=====CADASTRAR=====>");
			System.out.println("|1°) Cerveja	    |");
			System.out.println("|2°) Refrigerante   |");
			System.out.println("<===================>");
			System.out.print("Opção: "); // Escolhe a opção 
			resp_bebida = input.nextInt(); // Armazenado a opção
			
			if(resp_bebida == 1) { // Se for 1, será cadastrado uma cerveja
				System.out.print("Nome [Exem: Skol]: ");
				Cerveja c4 = new Cerveja(input.next());
				System.out.print("Preço [Exem: 6,50]: ");
				c4.setPreco(input.nextDouble());
				d.cadastrarProduto(c4); // E ela vai ser cadastrada 
				
			}else if(resp_bebida == 2) { // Se for 2, vai ser um refrigerante
				System.out.print("Nome [Exem: Coca-Cola] : ");
				Refrigerante r3 = new Refrigerante(input.next());
				System.out.print("Preço [Exem: 5,50]: ");
				r3.setPreco(input.nextDouble());
				d.cadastrarProduto(r3);// E vai ser cadastrado
				
			}else {
				System.out.println("[ERRO] OPÇÃO INVÁLIDA");// Caso não seja nenhuma das opções, aparece está mensagem
			}
			
		}else if(resp == 2) { // Caso ele escolha a segunda opção irá remover algum dos produtos já cadastrados
			d.mostra_Produtos(); // Lista de produtos
			System.out.println("<=====REMOVER======>");
			System.out.println("|1°) Cerveja	    |");
			System.out.println("|2°) Refrigerante   |");
			System.out.println("<===================>");
			
			System.out.print("Opção: "); 
			resp_remover = input.nextInt();// Pega a opção que escolheu 
			
			if(resp_remover == 1) { // Se for 1 escolheu a cerveja
				System.out.print("Número do PRODUTO !: "); // Diz o numero do produto para remover
				resp_remover2 = input.nextInt();
				
				if(resp_remover2 == 1) { // Entra em outro em outra estrutura para remover a opção desejada
					d.remove_Produto(c);
					System.out.println("Produto [" +c.getNome()+"] Removido !");
					
				}else if(resp_remover2 == 2) {
					d.remove_Produto(c1);
					System.out.println("Produto [" +c1.getNome()+"] Removido !");
					
				}else if(resp_remover2 == 3) {
					d.remove_Produto(c2);
					System.out.println("Produto [" +c2.getNome()+"] Removido !");
					
				}else if(resp_remover2 == 4) {
					d.remove_Produto(c3);
					System.out.println("Produto [" +c3.getNome()+"] Removido !");
					
				}else {
					System.out.println("[ERRO] Número de Produto INVÁLIDO !");
				}
				
			}else if(resp_remover == 2) { // Se a opção for 2, será refrigerante
				System.out.print("Número do PRODUTO !: ");
				resp_remover2 = input.nextInt(); // Será exlcuido conforme o número digitado
				
				if(resp_remover2 == 1) {
					d.remove_Produto(r);
					System.out.println("Produto [" +r.getNome()+"] Removido !");
					
				}else if(resp_remover2 == 2) {
					d.remove_Produto(r1);
					System.out.println("Produto [" +r1.getNome()+"] Removido !");
					
				}else if(resp_remover2 == 3) {
					d.remove_Produto(r2);
					System.out.println("Produto [" +r2.getNome()+"] Removido !");	
					
				}else {
					System.out.println("[ERRO] Número de Porduto INVÁLIDO !");
				}
				
			}else {
				System.out.println("[ERRO] OPÇÃO INVÁLIDA");
			}
				
		}else{// Fechando a estrutura de escolha (IF) a principal
			System.out.println("[ERROR] OPÇÃO INVÁLIDA !");
			
		}
		
		System.out.println(""); // Dar o espço entre as onformções que vão aparecer na tela
		
		System.out.print("Deseja ver os produtos CADASTRADOS ?: "); // Pergunta se o deseja ver o cadastro
		resp_ver = input.next().toLowerCase();
		
		if(resp_ver.equals("sim")) {
			d.mostra_Produtos();
		}else {
			System.out.println("Programa FINALIZADO !");
		}
		
		input.close(); // Fechando o Input
	}

}
