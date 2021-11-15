package se.lexicon;

import se.lexicon.io.IOManager;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IOManager ioManager = new IOManager();
        File source = new File("source/01_Functional Interfaces and Lambda Expressions.pdf");
        File destination = new File("destination/01_Functional Interfaces and Lambda Expressions-copy.pdf");
        ioManager.bufferCopy(source, destination);
    }
}
