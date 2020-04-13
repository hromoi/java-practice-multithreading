import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ReadFile rf = new ReadFile(ex);
        ArrayList<String> listFilePath = new ArrayList<>();
        listFilePath.add("/Users/user/IdeaProjects/multithreading/src/test");
        listFilePath.add("/Users/user/IdeaProjects/multithreading/src/test1.txt");
        listFilePath.add("/Users/user/IdeaProjects/multithreading/src/test2.txt");
        listFilePath.add("/Users/user/IdeaProjects/multithreading/src/test3.txt");
        for (String path : listFilePath) {
            rf.read(path);
        }
        ex.shutdown();
    }
}
