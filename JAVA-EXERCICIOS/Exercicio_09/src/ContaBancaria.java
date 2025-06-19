import java.util.Scanner;

public class ContaBancaria {
    private final static Scanner scanner = new Scanner(System.in);
    public String name;
    private  String conta;
    private  String agencia;
    private double saldo;
    private double cheque_especial;
    private double valorChequeEspecialUsado;
    private double deposito;
    private double saque;
    private double boleto;

    public void criarConta(){
        double primeiroDeposito;

        System.out.println("Seja bem-vindo");
        System.out.println("==================");
        System.out.println("Insira seu nome :");
        var registrarNome = scanner.next();
        this.name = registrarNome;
        System.out.println("Sua conta foi criada com sucesso,veja seus dados abaixo:");
        this.conta=GeradorNumerosFormatados.gerarNumeroConta();
        this.agencia = GeradorNumerosFormatados.gerarNumeroAgencia();
        System.out.println(registrarNome+": \n Conta: "+conta+ "\n Agência: "+agencia);

        System.out.println("=========================");

        System.out.println("Realize seu primeiro depósito para ter acesso a sua conta");
        System.out.println("Digite o valor do depósito");
        primeiroDeposito = scanner.nextDouble();
        this.saldo = primeiroDeposito;
        if (primeiroDeposito<=500){
            cheque_especial = 50;
        }else {
            cheque_especial = primeiroDeposito/2.0;
        }
        acessarConta();
    }
    public void acessarConta(){
        boolean verificador = false;
        do {
            System.out.println("Login");
            System.out.println("============");
            System.out.println("Informe seu nome");
            var nameToVerify = scanner.next();
            System.out.println("Digite o número da sua conta");
            var contaToVerify = scanner.next();
            System.out.println("Digite o número da sua agência");
            var agenciaToVerify = scanner.next();
            if (nameToVerify.equalsIgnoreCase(this.name) && contaToVerify.equals(this.conta) && agenciaToVerify.equals(this.agencia)){
                verificador = true;

            }else{
                System.out.println("Informações inválidas tente novamete");
            }
        }while(!verificador);
        Main.menu();
    }

    public String getConta() {
        return conta;
    }
    public String getAgencia() {
        return agencia;
    }
    public double getSaldo() {
        return saldo;
    }
    public double getCheque_especial() {
        return cheque_especial;
    }
    public double getValorChequeEspecialUsado() {
        return valorChequeEspecialUsado;
    }



    public void depositando(){
        System.out.println("Informe o valor do depósito:");
        this.deposito = scanner.nextDouble();
        double taxaChequeEspecial = this.valorChequeEspecialUsado * 0.20;
        double valorParaCobrir = this.valorChequeEspecialUsado + taxaChequeEspecial;
        if (this.valorChequeEspecialUsado > 0) {
            System.out.println("Você utilizou R$" + String.format("%.2f", this.valorChequeEspecialUsado) + " do seu cheque especial.");
            System.out.println("Será cobrada uma taxa de 20%: R$" + String.format("%.2f", taxaChequeEspecial));

            // Aplica a taxa e zera o valor usado do cheque especial, se o depósito cobrir
            if (this.deposito >= valorParaCobrir) {
                this.saldo += (this.deposito - valorParaCobrir);
                this.valorChequeEspecialUsado = 0; // Zera o uso do cheque especial
                System.out.println("Cheque especial e taxa pagos com sucesso!");
            } else if (this.deposito < valorParaCobrir){
                // Se o depósito não cobrir tudo (cheque especial + taxa), ele só diminui a dívida
                valorParaCobrir -= this.deposito; // Diminui a dívida
                this.saldo = 0; // O saldo vai para zero, pois o depósito foi para cobrir a dívida
                System.out.println("Depósito utilizado para abater dívida do cheque especial. Você ainda deve R$" + String.format("%.2f", valorParaCobrir) + " do cheque especial.");
            }
        } else {
            this.saldo += this.deposito;
            System.out.println("Depósito realizado com sucesso!");
        }
        System.out.println("Saldo atual: R$"+ String.format("%.2f", this.saldo));
    }
    public void sacando(){
        System.out.println("Informe o valor do saque:");
        this.saque = scanner.nextDouble();

        if (this.saque > this.saldo) {
            double restanteParaSacar = this.saque - this.saldo;
            // Verifica se tem limite de cheque especial disponível
            if (restanteParaSacar <= (this.cheque_especial - this.valorChequeEspecialUsado)) {
                this.saldo = 0; // Zera o saldo
                this.valorChequeEspecialUsado += restanteParaSacar; // Registra o uso do cheque especial
                System.out.println("Saque realizado. Você utilizou R$" + String.format("%.2f", this.valorChequeEspecialUsado) + " do seu cheque especial.");
            } else {
                System.out.println("Saldo + limite insuficiente, não podemos concluir a transação!");
            }
        } else {
            this.saldo -= this.saque;
            System.out.println("Saque realizado com sucesso!");
        }
        System.out.println("Saldo atual: R$"+ String.format("%.2f", this.saldo));

    }
    public void pagandoBoleto(){
        System.out.println("Informe o valor do boleto:");
        this.boleto = scanner.nextDouble();
        if (this.boleto<=this.saldo){
            this.saldo -= this.boleto;
            System.out.println("Boleto pago com sucesso!");
        }else if (this.boleto>this.saldo){
            System.out.println("Saldo insuficiente vamos tentar aplicar o limite do seu cheque especial");
            double valorParaPagarComCheque = this.boleto - this.saldo;
            if (valorParaPagarComCheque <= (this.cheque_especial - this.valorChequeEspecialUsado) ){
                this.valorChequeEspecialUsado += valorParaPagarComCheque; // Registra o uso do cheque especial
                this.saldo = 0; // Zera o saldo da conta

                System.out.println("Transação concluída com sucesso sua conta agora encontra-se usando o cheque especial ");
              }else {
                  this.boleto -= this.saldo + this.cheque_especial;
                System.out.println("Saldo + limite insuficiente, não podemos concluir a transação!");
              }
        }System.out.println("Saldo atual: R$"+ String.format("%.2f", this.saldo));
    }



}

