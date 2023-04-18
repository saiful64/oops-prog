import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        File file = new File("File1.txt");
        File opFile = new File("File1-copy.txt");


        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream(file);
            fout = new FileOutputStream(opFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int i=0;
        try {
            while((i = fin.read()) != -1){
                fout.write(i);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
