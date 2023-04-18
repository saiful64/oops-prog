import java.io.File;
import java.util.Arrays;

public class PrintFileName {
    public static void main(String[] args) {
        String path = "C:/Users/asus/Desktop/OOps";
        File file = new File(path);

        File arr[] = file.listFiles();
        Arrays.sort(arr);

        for (File e : arr) {
            if (e.isFile())
                System.out.println("This is my file" + e.getName());
            else if (e.isDirectory())
                System.out.println("This is my directory");
            else
                System.out.println("Not known");
        }

    }
}
