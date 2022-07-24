package com.gameoflife;

import static com.gameoflife.Game.scanner;

public class Simulation {

    private final GameOfLife game;

    public Simulation(int size){
        game = new GameOfLife(size);
    }
    void start(int[][] coords) {
        for (int[] coord : coords) {
            game.setLiveCell(coord[0], coord[1]);
        }
        simulate();
    }

    private void simulate() {
        listener threadobj = new listener();//create the object
        Thread thread = new Thread(threadobj);//create the thread
        thread.start();//start the thread. it runs asynchronously
        while (!threadobj.exit) {
            game.printMatrix();
            game.setNeighbours();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // throw new RuntimeException(e);
            }
            System.out.println();
        }
        threadobj.killMe = true;
    }
}
class listener implements Runnable {
    public boolean exit;    //if true then the q button has been pressed
    public boolean killMe;  //set to true to kill this thread

    @Override
    public void run() {
        while (!killMe) {
            if(scanner.hasNext("q") || scanner.hasNext("Q")) { //Should trigger when a q is pressed.
                exit = true;        //if not use 'scanner.nextLine()'

                //wait a bit for input, so less cpu is used for constant checks.
                try {
                    this.wait(10);
                } catch (IllegalMonitorStateException | InterruptedException e) {
                    // throw new RuntimeException(e);
                }
            }
        }
    }

    public listener() {
        exit = false;
        killMe = false;
    }
}