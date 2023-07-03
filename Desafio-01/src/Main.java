import br.com.leuxa.desafio01.models.Musicas;

public class Main {
    public static void main(String[] args) {
        Musicas musica = new Musicas();
        musica.setNomeDaBanda("NX Zero");
        musica.setTemDvd(false);
        musica.setCurtidas(5);
        musica.setClassificacao(47.5);
        musica.setDuracao(2);
        musica.setTotalDeReproducoes(170000);
        musica.setTitulo("Espero que esteja feliz");

        System.out.println(musica.getNomeDaBanda());
        System.out.println(musica.getTitulo());
        System.out.println(musica.getClassificacao());
        System.out.println(musica.getCurtidas());

        musica.reproduzir();
        musica.curtir();
    }
}