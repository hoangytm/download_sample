package hoangytm.com.download_sample;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Override
    public void downloadFile(
            HttpServletResponse response, String fileName, String mediaType, IDownloadProcessor processor) throws IOException {
        downloadFile(response, fileName, mediaType, processor, "inline");
    }

    @Override
    public void downloadFile(
            HttpServletResponse response, String fileName, String mediaType, IDownloadProcessor processor, String viewType) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, viewType + ";filename=" + encodeFileName(fileName));
        response.setContentType(mediaType);
        processor.do_(response.getOutputStream());
    }

    private String encodeFileName(String fileName) {
        String encodedFileName;
        try {
            encodedFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return encodedFileName;
    }

    public interface IDownloadProcessor {
        void do_(OutputStream os) throws IOException;
    }
}