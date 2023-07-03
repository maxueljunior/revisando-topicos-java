public class Main {
    /**
     * @author Maxuel
     * Maxuel está fazendo algo
     *
     */

    public static void main(String[] args) {
        try {
            System.out.println("Ini do main");
            metodo1();
            System.out.println("Fim do main");
        }catch (MinhaExcecaoUnchecked ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void metodo1(){
        System.out.println("Ini do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2(){
        System.out.println("Ini do metodo2");
        throw new MinhaExcecaoUnchecked("Erro de metodo unchecked");
        //throw new MinhaExcecao("Erro de metodo");
    }
}