import java.util.Scanner;

public class Simulador {
	private static final int max = 20;
	private static int nveiculos = 0;
	private static Veiculo[] veiculos = new Veiculo[max];
	private static boolean[] ocupados = new boolean[max];

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); // Funcao para leitura de dados
		String s;

		char opcao; // Variavel para selecionar as opções do simulador
		
		do { // Inciando MENU de Opções (interativo)
			System.out.println("(a) Incluir veiculo"); // OK
			System.out.println("(b) Remover um veiculo"); // OK
			System.out.println("(c) Abastecer veiculo"); // OK -- testar
			System.out.println("(d) Movimentar veiculo"); // OK
			System.out.println("(e) Movimentar veiculos por tipo"); // OK
			System.out.println("(f) Imprimir dados de veiculos por tipo"); // OK
			System.out.println("(g) Imprimir pista de corrida"); // OK
			System.out.println("(h) Esvaziar pneus de um veiculo"); // OK 
			System.out.println("(i) Calibrar pneus de um veiculo"); // OK
			System.out.println("(j) Sair da aplicacao"); // OK

			System.out.print("Opcao: ");
			s = teclado.next();
    		opcao = s.charAt(0); // convertendo string para char

			switch(opcao) {		
				case 'a': // INCLUIR VEICULO
				{
					System.out.println("");
					if(nveiculos < max) {
						char nome;
						boolean validar;
						mostraVeiculos();
						do{
							System.out.println("Bicicleta (B) | Motocicleta (M) | Carro Popular (C) | Ferrari (F)");
							System.out.print("Informe o tipo de veiculo para ser adicionado: ");

							nome = teclado.next().charAt(0); 
							validar = validaNome(nome);
						}while(validar == false);

						adicionaVeiculo(nome);
					} else {
						System.out.println("Nao e possivel inserir mais veiculos !!!");
					}
					break;	
				}
				
				case 'b': // REMOVER VEICULO
				{
					if(nveiculos != 0) {
						String escolha;
						boolean validar;

						mostraVeiculos();
						escolha = teclado.nextLine();
						do{
							System.out.print("Informe o ID do veiculo a ser removido (exemplo: B1): ");
							escolha = teclado.nextLine();

							validar = validaVeiculo(escolha);
						}while(validar == false);

						int indice = retornaIndice(escolha);
						System.out.println("Veiculo (" + veiculos[indice].getid() + ") Removido com sucesso ...");
						ocupados[indice] = false; // Desocupando lugar no vetor ocupados ...
						veiculos[indice] = null; // Apontando Objeto veiculo para null (deletando)
						nveiculos--;
					} else {
						System.out.println("");
						System.out.println("Nao ha veiculos !!!");
					}
					break;	
				}
			
				case 'c': // ABASTECER VEICULO
				{
					System.out.println("");
					if(nveiculos == 0) {
						System.out.println("Nao ha veiculos !!!");
					} else if(verificaVeiculoMotorizado() == true) { // Só vai entrar se Existe Veiculo motorizado
						String escolha;
						mostraVeiculos();
						System.out.print("Informe o ID de um veiculo motorizado abaixo: ");
						escolha = teclado.nextLine();
						escolha = teclado.nextLine();
						while(escolha.charAt(0) == 'B' || validaVeiculo(escolha) == false) { // Se usuario informar um veiculo não motorizado ou um veiculo motorizado que não exista
							System.out.println("Veiculo nao é motorizado ou não existe na pista !!!");
							System.out.print("Faca outra escolha: ");
							escolha = teclado.nextLine();
						}

						System.out.print("Informe a quantidade de litros de combustivel para colocar em " + escolha + " (ex: 1,22): "); // colocamos um ex pois o input do float deve ser com "virgula"
						float litros = teclado.nextFloat();

						abastaceVeiculo(escolha, litros);
					}
					break;
				}
				
				case 'd': // MOVIMENTAR VEICULO
				{
					System.out.println("");
					if(nveiculos != 0) {
						String escolha;
						boolean validar;

						mostraVeiculos();
						escolha = teclado.nextLine();
						do{
							System.out.print("Informe o ID do veiculo a ser movido (exemplo: B1): ");
							escolha = teclado.nextLine();

							validar = validaVeiculo(escolha);
						}while(validar == false);

						movimentaVeiculo(escolha);

					} else {
						System.out.println("Nao ha veiculos !!!");
					}

					break;	
				}
				
				case 'e': // MOVIMENTAR VEICULO POR TIPO
				{
					System.out.println("");
						if(nveiculos != 0) {
						char nome;
						boolean validar;
						mostraVeiculos();
						do{
							System.out.println("Bicicleta (B) | Motocicleta (M) | Carro Popular (C) | Ferrari (F)");
							System.out.print("Informe o tipo de veiculo para mover todos: ");

							nome = teclado.next().charAt(0); 

							validar = validaNome(nome);
						}while(validar == false);

						movimentaVeiculoTipo(nome);
					} else {
						System.out.println("Nao ha veiculos !!!");
					}
					break;	
				}
				
				case 'f': // IMPRIMIR DADOS DE VEICULO POR TIPO
				{
					if(nveiculos != 0) {
						boolean validar;
						char nome;
						do{
								System.out.println("Bicicleta (B) | Motocicleta (M) | Carro Popular (C) | Ferrari (F)");
								System.out.print("Informe o tipo de veiculo para ser mostrado: ");

								nome = teclado.next().charAt(0); 
								validar = validaNome(nome);
							}while(validar == false);
						System.out.println("");
						mostraVeiculosTipo(nome);
					} else {
						System.out.println("");
						System.out.println("Nao ha veiculos !!!");
					}
					break;	
				}
				
				case 'g': // IMPRIMIR PISTA DE CORRIDA
				{
					System.out.println("");
					if(nveiculos == 0) {
						System.out.println("Nao ha veiculos !!!");
					} else {
						imprimirPista();
					}
					break;	
				}
				
				case 'h': // ESVAZIAR PNEUS DE UM VEICULO
				{
					if(nveiculos != 0) {
						String escolha;
						boolean validar;

						mostraVeiculos();
						escolha = teclado.nextLine();
						do{
							System.out.print("Informe o ID do veiculo para esvaziar os Pneus: ");
							escolha = teclado.nextLine();

							validar = validaVeiculo(escolha);
						}while(validar == false);
						
						calibraPneu(escolha, false); // false porque é para Esvaziar Pneu
					} else {
						System.out.println("");
						System.out.println("Nao ha veiculos !!!");
					}
					break;	
				}
				
				case 'i': // CALIBRAR PNEUS DE UM VEICULO
				{
					if(nveiculos != 0) {
						String escolha;
						boolean validar;

						mostraVeiculos();
						escolha = teclado.nextLine();
						do{
							System.out.print("Informe o ID do veiculo para calibrar os Pneus: ");
							escolha = teclado.nextLine();

							validar = validaVeiculo(escolha);
						}while(validar == false);
						
						calibraPneu(escolha, true); // true porque é para Calibrar Pneu
					} else {
						System.out.println("");
						System.out.println("Nao ha veiculos !!!");
					}
					
					break;					
				}
	
				case 'j': // SAIR DA APLICAÇÃO
				{
					break;
				}
				
				default: // caso opção for diferente do intervalo [a-j]
				{
					System.out.println("Esta opcao e invalida !!!");
				}
			}
			System.out.println("");
		}while(opcao != 'j');
	}

	private static boolean validaNome(char name) {
		if(name == 'B' || name == 'M' || name == 'C' || name == 'F') {
			return true; // nome valido ...
		} else {
			return false; // nome invalido ...
		}
	}

	private static String geraID(char tipo) {
		if(nveiculos == 0) { // se estiver vazio é so criar o primeiro ...
			return (tipo + "1");
		}

		int i=0;
		while(ocupados[i] != false) { // vai percorrer o vetor ocupados até achar um false ... o tipo + (indice + 1) desse vetor sera o NICK do Veiculo
			i++;
		}
		return (tipo + Integer.toString(i+1));
	}

	private static void adicionaVeiculo(char tipo) {
		String name = geraID(tipo);

		int i=0;
		while(ocupados[i] != false) {
			i++;
		}
		// Vai percorrer o vetor ocupados até achar o primeiro "false" ... o indice que ele parar vai ser a posicao de um novo Veiculo
 
		switch(tipo) {
			case 'B': // CRIANDO OBJETO Bicicleta
			{
				veiculos[i] = new Bicicleta(name);
				break;
			}

			case 'M': // CRIANDO OBJETO Motocicleta
			{
				veiculos[i] = new Motocicleta(name); 
				break;
			}

			case 'C': // CRIANDO OBJETO CarroPopular
			{
				veiculos[i] = new CarroPopular(name);
 				break;
			}

			case 'F': // CRIANDO OBJETO Ferrari
			{
				veiculos[i] = new Ferrari(name);
				break;
			}
		}
		ocupados[i] = true; // Como foi adicionado um novo Objeto ... setar aquela posição como ocupada (true)
		nveiculos++;
	}

	private static void mostraVeiculos() {
		System.out.println("-- Veiculos --");
		VeiculoMotorizado vm; // para imprimir o combustivel

		for(int i=0 ; i<max ; i++) {
			if(veiculos[i] != null) {
				if(veiculos[i].getid().charAt(0) != 'B') { // imprimir classe dos veiculos que possuem motor ...
					System.out.print(veiculos[i]);
					vm = (VeiculoMotorizado)veiculos[i];
					System.out.println(" | Combustivel: " + vm.getcombustivel());
				} else {
					System.out.println(veiculos[i]); // imprimir somente classe Bicicleta ..
				}
			}
		}
		System.out.println("------------------------------------------------------------");
	}

	private static void mostraVeiculosTipo(char tipo) {

		if(nveiculos != 0) {
			System.out.println("-- Veiculos --");
			VeiculoMotorizado vm; // para imprimir o combustivel
			int cont=0;
			for(int i=0; i<max ; i++) {
				if(veiculos[i] != null && veiculos[i].getid().charAt(0) == tipo) {
					if(tipo != 'B') { // imprimir classe dos veiculos que possuem motor ...
						System.out.print(veiculos[i]);
						vm = (VeiculoMotorizado)veiculos[i];
						System.out.println(" | Combustivel: " + vm.getcombustivel());
					} else {
						System.out.println(veiculos[i]); // imprimir somente classe Bicicleta ..
					}
					cont++;
				}
			}
			if(cont == 0) {
				System.out.println("Ainda não possui veiculos desse tipo ...");
			}
		} else {
			System.out.println("Nao ha veiculos !!!");
		}
	}

	private static boolean verificaVeiculoMotorizado() {
		if(nveiculos != 0) {
			for(int i=0 ; i<max ; i++) {
				if(veiculos[i] != null && veiculos[i].getid().charAt(0) != 'B') {
					return true; // retorna true se o veiculo está no vetor e é motorizado
				}
			}
		}
		System.out.println("Não ha veiculo motorizado !!!");
		return false; // retorna false se o veiculo NÂO está no vetor
	}

	private static boolean validaVeiculo(String nome) {
		for (int i=0 ; i<max ; i++) {
			if(veiculos[i] != null && veiculos[i].getid().equals(nome) == true) {
				return true;
			}
		}
		return false;
	}

	private static int retornaIndice(String nome) {
		for (int i=0 ; i<max ; i++) {
			if(veiculos[i] != null && veiculos[i].getid().equals(nome) == true) {
				return i;
			}
		}
		return -1;
	}

	private static void calibraPneu(String nome, boolean b) {
		int indice = retornaIndice(nome);

		if(veiculos[indice].getCalibragem(0) == false && b == false) {
			System.out.println("Os pneus ja estão vazios ...");
		} else if(veiculos[indice].getCalibragem(0) == true && b == true) {
			System.out.println("Os pneus ja estão calibrados ...");
		} else {
			System.out.println("");
			if(b == false) {
				System.out.println("Esvaziando Pneus ...");
			} else {
				System.out.println("Calibrando Pneus ...");
			}

			for(int i=0 ; i<veiculos[indice].getquantRodas() ; i++) {
				veiculos[indice].setCalibragem(i, b);
				System.out.println(veiculos[indice].statusPneu(i));
			}
		}
	}

	private static void abastaceVeiculo(String nome, float l) {
		int indice = retornaIndice(nome);
		VeiculoMotorizado vm = (VeiculoMotorizado)veiculos[indice];
		vm.abastecer(l);
		System.out.println("O veiculo " + nome + " foi abastecido com sucesso ...");
		System.out.println("Combustivel no tanque: " + vm.getcombustivel());
	}

	private static void imprimirPista() {
		for(int i=0 ; i<max ; i++) {
			if(veiculos[i] != null) {
				veiculos[i].imprimirTrajetoria();
			}
		}
	}

	private static void movimentaVeiculo(String nome) {
		int indice = retornaIndice(nome);

		System.out.println("");
		veiculos[indice].mover();
		System.out.println("");
		veiculos[indice].imprimirTrajetoria();
	}

	private static void movimentaVeiculoTipo(char type) {
		boolean cont = false;

		for(int i=0 ; i<max ; i++) {
			if(veiculos[i] != null && veiculos[i].getid().charAt(0) == type) {
				veiculos[i].mover();
				cont = true;
			}
		}

		if(cont == true) {
			System.out.println("");
			imprimirPista();
		} else {
			System.out.println("");
			System.out.println("Nao foi movido nenhum veiculo deste tipo ...");
		}
	}
}