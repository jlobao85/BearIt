package org.academiadecodigo.bootcamp;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Player player = new Player("Name");
        Cenario cenario = new Cenario();
        game.start(cenario, player);

    }
}
