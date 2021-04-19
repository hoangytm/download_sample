package hoangytm.com.download_sample;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class BusinessService {
    public void export(OutputStream os) {
        File initialFile = new File("C:\\Users\\Dell\\Desktop\\sample06.pdf");
        try {
            InputStream targetStream = new FileInputStream(initialFile);
            FileUtil.writeFile(targetStream,os);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
