package base;
import io.InOut;
public class Oficina {
	private static VetVeiculo arrVeiculo = new VetVeiculo();

	public static void main(String[] args) {    	

		String input = "";
		String placa= " ";
		String modelo= " ";
		String problema= " ";
		double valor= 0.0;

		while (!input.equals("0")) {
            input = InOut.leString("1- Adicionar Veiculo | 2- Pesquisar por Placa | 3- Remover por Placa | 4- Listar Todos os Veiculos | 5- Sair do Programa. Digite a opção desejada:");
			switch(input) {
			// todos os cases estão funcionando.
			
					case "1":
						// Adicionar veículo
						placa = InOut.leString("Por favor, digite o número da placa:");
						modelo = InOut.leString("Digite o modelo do veículo:");
						problema = InOut.leString("Digite o problema do veículo:");
						valor = InOut.leDouble("Digite o valor estimado do conserto:");
						
						boolean inserido = arrVeiculo.inserirVeiculo(placa, modelo, problema, valor);
						if (inserido) {
							System.out.println("Veículo adicionado com sucesso!");
						} else {
							System.out.println("Veículo com placa " + placa + " já está cadastrado.");
						}
						break;

					case "2":
						// Pesquisar veículo por placa e mostrar informações
						placa = InOut.leString("Digite a placa do veículo que deseja pesquisar:");
						int pos = arrVeiculo.pesquisaVeiculo(placa);
						
						if (pos != -1) {
							Veiculo veiculoEncontrado = arrVeiculo.getPos(pos);
							System.out.println("Veículo encontrado: " + veiculoEncontrado);
						} else {
							System.out.println("Veículo com placa " + placa + " não encontrado.");
						}
						break;

					case "3":
						// Remover veículo da oficina pela placa
						placa = InOut.leString("Digite a placa do veículo que deseja remover:");
						boolean removido = arrVeiculo.removerVeiculo(placa);
						if (removido) {
							System.out.println("Veículo removido com sucesso!");
						} else {
							System.out.println("Veículo com placa " + placa + " não encontrado.");
						}
						break;

					case "4":
						// Listar todos os veículos (somente modelo e placa)
						System.out.println("Veículos cadastrados na oficina:");
						arrVeiculo.listarVeiculos();
						break;
				case "5":
					System.exit(0); // sair do programa.
				default:
					System.out.println("Opção inválida!");


			}
		}
	}
}
