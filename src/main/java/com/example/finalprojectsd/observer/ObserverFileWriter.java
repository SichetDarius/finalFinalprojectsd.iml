package com.example.finalprojectsd.observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ObserverFileWriter implements IObserverFileWriter {
    @Override
    public void writeToFile(String s) throws IOException {
        File file = new File("C://Users//40745//Desktop//finalprojectsd//src//main//resources//input.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(s);
        fileWriter.close();
    }
}
