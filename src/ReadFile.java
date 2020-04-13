import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

public class ReadFile {

    private ThreadPoolExecutor ex;

    public ReadFile(ThreadPoolExecutor ex) {
        this.ex = ex;
    }

    public void read(final String path) {
        ex.execute(() -> {
            synchronized (this) {
            File file = new File(path);
            if (!file.isFile()) {
                System.out.println("Это не файл " + file.getName());
                return;
            }
                System.out.println("Файл " + file.getName() + " имеет размер " + file.length() + " bytes");
                String substring = path.indexOf('.') >= 0 ? path.substring(path.indexOf('.')) : null;
                System.out.println("Файл " + file.getName() + " имеет расширение " + substring);
            }
        });
    }
}
