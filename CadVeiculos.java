import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();

void main(){
    IO.println("Bem vindo ao Sistema CadVeiculos");
    String menu = """
            MENU DE OPÇÕES
            1 - Cadastrar Veículo;
            2 - Listar Veículos;
            3 - Remover Veículo;
            4 - Buscar Veículo;
            5 - Editar Veículo;
            0 - Sair
            """;
    int opcao;
    do {
        IO.println(menu);
        opcao = input.scanInt("Digite a opção desejada: ");
        switch (opcao) {
            case 1 -> {
                cadastrar();
                IO.readln("Pressione Enter para Continuar");
            }
            case 2 -> {
                listar();
                IO.readln("Pressione Enter para Continuar");
            }
            case 3 -> {
                remover();
                IO.readln("Pressione Enter para Continuar");
            }
            case 4 -> {
                buscar();
                IO.readln("Pressione Enter para Continuar");
            }
            case 5 -> {
                editar();
                IO.readln("Pressione Enter para Continuar");
            }
            case 0 -> {
                IO.println("Volte sempre!!!");
            }
            default -> {
                IO.println("Opção Inválida");
                IO.readln("Pressione Enter para Continuar");
            }
                
        }
    } while (opcao != 0);

}



void cadastrar() {
    String veiculo = IO.readln("Digite o nome do novo veículo: ");
    veiculo = veiculo.toLowerCase();
    veiculo = veiculo.trim();

    if (veiculo.isEmpty()) {
        IO.println("Nome do veículo inválido!");
        return;
    }

    if (veiculos.contains(veiculo)) {
        IO.println("Veículo já cadastrado!");
    } else {
        veiculos.add(veiculo);
        IO.println("Veículo cadastrado com sucesso!");
    }
}

void listar() {
    if (veiculos.isEmpty()) {
        IO.println("Nenhum veículo cadastrado!");
        return;
    }
    
    List<String> veiculosOrdenados = ordenarVeiculos();
    
    for (int i = 0; i < veiculosOrdenados.size(); i++) {
        IO.println((i + 1) + " - " + veiculosOrdenados.get(i));
    }
}

List<String> ordenarVeiculos() {
    List<String> copia = new ArrayList<>(veiculos);
    
    // Bubble Sort - Ordenação manual em ordem alfabética
    for (int i = 0; i < copia.size() - 1; i++) {
        for (int j = 0; j < copia.size() - 1 - i; j++) {
            if (copia.get(j).compareTo(copia.get(j + 1)) > 0) {
                // Troca os elementos
                String temp = copia.get(j);
                copia.set(j, copia.get(j + 1));
                copia.set(j + 1, temp);
            }
        }
    }
    
    return copia;
}

void remover() {
    if (veiculos.isEmpty()) {
        IO.println("Nenhum veículo cadastrado!");
        return;
    }
    
    List<String> veiculosOrdenados = ordenarVeiculos();
    
    for (int i = 0; i < veiculosOrdenados.size(); i++) {
        IO.println((i + 1) + " - " + veiculosOrdenados.get(i));
    }
    
    String menu2 = """
            OPÇÕES DE REMOÇÃO
            1 - Remover por número
            2 - Remover por nome
            """;
    IO.println(menu2);
    int opcao2 = input.scanInt("Digite a opção desejada: ");
    
    if (opcao2 == 1) {
        String input = IO.readln("Digite o número do veículo que deseja remover: ");
        try {
            int numero = Integer.parseInt(input);
            if (numero > 0 && numero <= veiculosOrdenados.size()) {
                String veiculo = veiculosOrdenados.get(numero - 1);
                if (veiculos.remove(veiculo)) {
                    IO.println("Veículo '" + veiculo + "' removido com sucesso!");
                }
            } else {
                IO.println("Número inválido!");
            }
        } catch (NumberFormatException e) {
            IO.println("Digite apenas números!");
        }
    } else if (opcao2 == 2) {
        String nome = IO.readln("Digite o nome do veículo que deseja remover: ");
        nome = nome.toLowerCase().trim();
        if (veiculos.remove(nome)) {
            IO.println("Veículo '" + nome + "' removido com sucesso!");
        } else {
            IO.println("Veículo não encontrado!");
        }
    } else {
        IO.println("Opção inválida!");
    }
}

void buscar () { 
    if (veiculos.isEmpty()) {
        IO.println("Nenhum veículo cadastrado!");
        return;
    }
    
    String nome = IO.readln("Digite o nome do veículo que deseja buscar: ");
    nome = nome.toLowerCase().trim();
    
    if (veiculos.contains(nome)) {
        int posicao = veiculos.indexOf(nome) + 1;
        IO.println("Veículo encontrado na posição " + posicao + ": " + nome);
    } else {
        IO.println("Veículo não encontrado!");
    }
}

void editar() {
    if (veiculos.isEmpty()) {
        IO.println("Nenhum veículo cadastrado!");
        return;
    }
    
    List<String> veiculosOrdenados = ordenarVeiculos();
    
    for (int i = 0; i < veiculosOrdenados.size(); i++) {
        IO.println((i + 1) + " - " + veiculosOrdenados.get(i));
    }
    
    String menu3 = """
            OPÇÕES DE EDIÇÃO
            1 - Editar por número
            2 - Editar por nome
            """;
    IO.println(menu3);
    int opcao3 = input.scanInt("Digite a opção desejada: ");
    
    int indice = -1;
    
    if (opcao3 == 1) {
        String input = IO.readln("Digite o número do veículo que deseja editar: ");
        try {
            int numero = Integer.parseInt(input);
            if (numero > 0 && numero <= veiculosOrdenados.size()) {
                String veiculo = veiculosOrdenados.get(numero - 1);
                indice = veiculos.indexOf(veiculo);
            } else {
                IO.println("Número inválido!");
                return;
            }
        } catch (NumberFormatException e) {
            IO.println("Digite apenas números!");
            return;
        }
    } else if (opcao3 == 2) {
        String nome = IO.readln("Digite o nome do veículo que deseja editar: ");
        nome = nome.toLowerCase().trim();
        indice = veiculos.indexOf(nome);
        if (indice == -1) {
            IO.println("Veículo não encontrado!");
            return;
        }
    } else {
        IO.println("Opção inválida!");
        return;
    }
    
    String novoNome = IO.readln("Digite o novo nome do veículo: ");
    novoNome = novoNome.toLowerCase().trim();
    
    if (novoNome.isEmpty()) {
        IO.println("Nome do veículo inválido!");
        return;
    }
    
    if (veiculos.contains(novoNome)) {
        IO.println("Veículo com esse nome já existe!");
        return;
    }
    
    veiculos.set(indice, novoNome);
    IO.println("Veículo editado com sucesso para: " + novoNome);
}

