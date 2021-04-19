package hoangytm.com.download_sample;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DownloadService {
    void downloadFile(HttpServletResponse response, String fileName, String mediaType,
                      DownloadServiceImpl.IDownloadProcessor processor) throws IOException;

    void downloadFile(
            HttpServletResponse response, String fileName, String mediaType, DownloadServiceImpl.IDownloadProcessor processor, String viewType) throws IOException;
}
