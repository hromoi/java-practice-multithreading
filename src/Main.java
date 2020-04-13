import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Semaphore sm = new Semaphore(1);
        ReadFile rf = new ReadFile(ex, sm);
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
