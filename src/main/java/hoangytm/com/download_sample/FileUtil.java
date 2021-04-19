package hoangytm.com.download_sample;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.nio.file.Files;

public class FileUtil {

    public static byte[] readLocalFile(String filePath) throws IOException {
        File file = new File(filePath);
        return Files.readAllBytes(file.toPath());
    }

    public static Boolean saveLocalFile(String fileName, String filePath, InputStream is) {

        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File targetFile = new File(filePath + "/" + fileName);
            OutputStream outStream = null;
            outStream = new FileOutputStream(targetFile);
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
            IOUtils.closeQuietly(outStream);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean saveLocalFile(String fileName, String filePath, byte[] bytes) {

        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File targetFile = new File(filePath + "/" + fileName);
            OutputStream outStream = null;
            outStream = new FileOutputStream(targetFile);

            InputStream is = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            outStream.write(bytes);
            IOUtils.closeQuietly(outStream);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void writeFile(InputStream inputStream, OutputStream os) throws IOException {
        try {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        } finally {
            close(inputStream);
            close(os);
        }
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) closeable.close();
        } catch (Exception ex) {
        }
    }

}
