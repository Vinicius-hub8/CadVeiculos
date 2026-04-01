import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();

void main(){
    IO.println("Bem Vindo ao Sistema CadVeiculos");
    String menu = """
            MENU DE OPÇÔES 
            1-  Cadastrar Veiculos; 
            2-  Lista Veiculos; 
            3-  Remover Veiculo;
            0-  Sair  
            """;
int opcao; 
do { 
    IO.println(menu);
    opcao = input.scanInt("Digite sua opção desejada: ");
    switch (opcao) {
        case 1 -> {
            IO.readln("Pressione Enter para Continuar:");
        }
        case 2 -> {
            IO.readln("Pressione Enter para Continuar: ");
        }
        case 3 -> {
            IO.readln("Precione Enter para Continuar: ");
        }
        case 0 -> { 
            IO.println("Visite Sempre");
        }
        default -> {
            IO.println("Opção Invalida");
            IO.readln("Precione Enter para Continuar");
        }
    }
} while (opcao != 0);   
}

void cadastrar(){
    String veiculo = IO.readln("Digite o nome do novo veiculo  ");
    veiculo = veiculo.trim();
    if (veiculo.isEmpty())
        IO.println("Nome do veiculo invalido!");
    else 
        veiculos.add(veiculo);
}


