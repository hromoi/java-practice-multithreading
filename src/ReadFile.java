import java.io.File;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;

public class ReadFile {

    private ThreadPoolExecutor ex;
    private Semaphore sm;

    public ReadFile(ThreadPoolExecutor ex, Semaphore sm) {
        this.ex = ex;
        this.sm = sm;
    }

    public void read(final String path) {
        ex.execute(() -> {
//            synchronized (this) {
            try {
                sm.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            File file = new File(path);
            System.out.println(this);
            if (!file.isFile()) {
                System.out.println("Это не файл " + file.getName());
                return;
            }
            System.out.println("Файл " + file.getName() + " имеет размер " + file.length() + " bytes");
            String substring = path.indexOf('.') >= 0 ? path.substring(path.indexOf('.')) : null;
            System.out.println("Файл " + file.getName() + " имеет расширение " + substring);
            sm.release();
//            }
        });
    }
}
