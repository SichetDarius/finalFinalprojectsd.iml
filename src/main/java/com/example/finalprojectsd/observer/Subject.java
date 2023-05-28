package com.example.finalprojectsd.observer;

import java.io.IOException;

public abstract class Subject {
    private ObserverSend observerSend = new ObserverSend();
    private ObserverFileWriter observerFileWriter = new ObserverFileWriter();
    protected Subject() {
    }
    public void attach(ObserverSend send){
        observerSend = send;
    }
    public void attachObserverFileWriter(ObserverFileWriter send){
        observerFileWriter = send;
    }
    public void notifyObservers(int id, String s) throws IOException {
        observerFileWriter.writeToFile(s);
        observerSend.sendEmail(id, s);
    }
}
