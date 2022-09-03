package com.course.composition;

public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;
    public PC(Case theCase,Monitor monitor,Motherboard motherboard){
        this.theCase=theCase;
        this.monitor=monitor;
        this.motherboard=motherboard;
    }

    public void powerUp(){
        getCase().pressPowerButton();
        drawLogo();
        loadProgram();
    }
    private void drawLogo(){
        getMonitor().drawPixelAt(1200,50,"yellow");
    }
    private void loadProgram(){
        getMotherboard().loadProgram("windows 1.2");
    }
    private Case getCase(){
        return theCase;
    }
    private Monitor getMonitor(){
        return monitor;
    }
    private Motherboard getMotherboard(){
        return motherboard;
    }
}
