import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;

public class teste {

	public static void main(String[] args) throws IOException {
        
		PrintStream ps = new PrintStream("file3.txt");
        
        ps.print("Vamos escrever nesse novo arquivo em Java! que legal hahaha!!!");
        ps.println();
        ps.println();
        ps.print("ddddddddVamos escrever outra linha aqui embaixo hahaha!!!");
        ps.close();
    }
}