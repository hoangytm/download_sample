package hoangytm.com.download_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/sample")
public class Controller {

    @Autowired
    private DownloadService downloadService;
    @Autowired
    private BusinessService businessService;

    @GetMapping
    public void vanBanTheoSoReport(
            HttpServletResponse resonse
    ) throws IOException {
        String fileName = String.format("vanBanTheoSoReport_%s.pdf", new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date()));
        downloadService.downloadFile(resonse, fileName, "application/pdf", os -> businessService.export(os));
    }

}
