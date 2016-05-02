package theboxgame.theboxgame;

public class Launcher {

    public static void main(String[] args) {
        String map
                = "11111111           \n"
                + "1  1   1           \n"
                + "1   3  1           \n"
                + "1 311 11111        \n"
                + "11 1  11  1        \n"
                + " 1 14   3 1        \n"
                + " 1 1  11  1        \n"
                + " 1 1 111 11        \n"
                + " 12   11  1        \n"
                + " 11 3     1        \n"
                + "  111111  1        \n"
                + "       1111        \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n"
                + "                   \n";
        Game game = new Game("TheBoxGame!", 400, 400, map);
        game.start();

    }
}
