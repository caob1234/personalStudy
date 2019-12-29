package com.smart.reusing;

import static net.mindview.util.Print.print;

class Game {
    Game(int i) {
        print("Game constructor");
    }
}
class BoardGame extends Game{

    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}
public class Chess extends BoardGame{
    Chess(int i) {
        super(i);
        print("Chess constructor");
    }
    public static void main(String[] args){
        Chess y=new Chess(1);
    }
}
