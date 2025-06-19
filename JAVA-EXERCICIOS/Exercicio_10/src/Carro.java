public class Carro {

    private boolean ligado;
    private int velocidade;
    private int marcha;


    public void  ligar(){
        if (!ligado) {
            this.ligado = true;
            System.out.println("Carro ligado!");
        }else {
            System.out.println("O carro já está ligado!");
        }
    }
    public void  desligar(){
        if (!ligado){
         System.out.println("O carro já está desligado");
        }else if(marcha==0 && velocidade==0) {
            this.ligado = false;
        }else {
            System.out.println("Para desligar, o carro precisa estar em ponto morto(marcha 0) e velocidade 0 ");
        }
    }
    public void  acelerar(){
        if (!ligado){
            System.out.println("O carro encontra-se desligado, ligue-o primeiro!");
            return;
        }else {
            podeAcelerar();
        }
    }
    public void  diminuirVelocidade(){
        if (!ligado){
            System.out.println("O carro encontra-se desligado, ligue-o primeiro!");
            return;
        }else {
            podeReduzir();
        }
    }
    public void virar(){
        if (!ligado){
            System.out.println("O carro encontra-se desligado, ligue-o primeiro!");
            return;
        } else if (velocidade>0 && velocidade<=40) {
            System.out.println("Curva realizada com sucesso!");
        }else {
            System.out.println("Diminua a velocidade para realizar a curva!");
        }
    }
    public void  trocarMarcha(){
        if (!ligado){
            System.out.println("O carro encontra-se desligado, ligue-o primeiro!");
            return;
        }else{
            podeTrocarMarcha();
        }
    }
    public void  verificarVelocidade(){
        if (!ligado){
            System.out.println("O carro encontra-se desligado, ligue-o primeiro!");
            return;
        } else {
           System.out.println("Velocidade atual: "+velocidade+"Km/h   || Marcha atual: "+marcha);
        }
    }
    public void  podeAcelerar(){
        if (marcha == 0) {
            System.out.println("Ponto morto. O carro não pode acelerar, engate a primeira marcha!");
            return;
        }
        if (velocidade >= 120) {
            System.out.println("Velocidade máxima (120km/h) atingida!");
            return;
        }
        if (marcha == 1 && velocidade < 20) {
            velocidade += 1;
            System.out.println("Acelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 2 && velocidade < 40) {
            velocidade += 1;
            System.out.println("Acelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 3 && velocidade < 60) {
            velocidade += 1;
            System.out.println("Acelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 4 && velocidade < 80) {
            velocidade += 1;
            System.out.println("Acelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 5 && velocidade < 100) {
            velocidade += 1;
            System.out.println("Acelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 6 && velocidade < 120) {
            velocidade += 1;
            System.out.println("Acelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else {
            // Se chegou aqui, é porque a velocidade está no limite da marcha atual ou acima do esperado para ela
            System.out.println("Velocidade no limite para a marcha atual (" + marcha + "). Considere trocar de marcha para continuar acelerando!");
        }
    }
    public void podeReduzir(){
        if (velocidade <= 0) {
            System.out.println("Velocidade mínima (0km/h) atingida!");
            return;
        }
        if (marcha == 1 && velocidade > 1) { // Pode reduzir até 0 na 1ª marcha
            velocidade -= 1;
            System.out.println("Desacelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 2 && velocidade > 21) { // Reduz na 2ª marcha, mas não abaixo de 21
            velocidade -= 1;
            System.out.println("Desacelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 3 && velocidade > 41) { // Reduz na 3ª, não abaixo de 41
            velocidade -= 1;
            System.out.println("Desacelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 4 && velocidade > 61) { // Reduz na 4ª, não abaixo de 61
            velocidade -= 1;
            System.out.println("Desacelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 5 && velocidade > 81) { // Reduz na 5ª, não abaixo de 81
            velocidade -= 1;
            System.out.println("Desacelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else if (marcha == 6 && velocidade > 101) { // Reduz na 6ª, não abaixo de 101
            velocidade -= 1;
            System.out.println("Desacelerando... Velocidade: " + velocidade + "km/h (Marcha: " + marcha + ")");
        } else {
            // Se chegou aqui, a velocidade está no limite mínimo para a marcha atual ou abaixo do esperado para ela
            System.out.println("Velocidade muito baixa para a marcha atual (" + marcha + "). Considere reduzir a marcha!");
        }
    }
    public void  podeTrocarMarcha(){
        int novaMarcha= 0;
        if (marcha==0 && velocidade==0){
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=1;
        } else if (marcha==1 && velocidade==1) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=0;
        }else if (marcha==1 && velocidade==20) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=2;
        }else if (marcha==2 && velocidade==21) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=1;
        }else if (marcha==2 && velocidade==40) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=3;
        }else if (marcha==3 && velocidade==41) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=2;
        }else if (marcha==3 && velocidade==60) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=4;
        }else if (marcha==4 && velocidade==61) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=3;
        }else if (marcha==4 && velocidade==80) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=5;
        }else if (marcha==5 && velocidade==81) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=4;
        }else if (marcha==5 && velocidade==100) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=6;
        }else if (marcha==6 && velocidade==101) {
            System.out.println("Troca de marcha bem sucedida!");
            novaMarcha=5;
        }else if (marcha==6 && velocidade==120) {
            System.out.println("Última marcha!");
        }else {
            System.out.println("Não foi possível trocar a marcha tente aumentar ou reduzir sua velocidade!");
            return;
        }
        marcha=novaMarcha;
    }
}
