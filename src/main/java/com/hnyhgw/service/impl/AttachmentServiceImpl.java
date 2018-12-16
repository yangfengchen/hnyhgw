package com.hnyhgw.service.impl;

import com.hnyhgw.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private Environment env;

    private static final String CK_IMAGE_PATH = File.separator + "uploadFile";

    @Override
    public Map<String, String> ckEditorUploadImage(MultipartFile file, HttpServletRequest request) {
        if(file==null || "".equals(file.getOriginalFilename().trim())) {
            return generateResult(false, "#");
        }
        String originalName = file.getOriginalFilename();
        // generate file name
        String localFileName = System.currentTimeMillis() + "-" + originalName;
        //String projectRealPath = request.getSession().getServletContext().getRealPath("");
        String realPath = getFilepath();
        File imageDir = new File(realPath);
        if(!imageDir.exists()) {
            imageDir.mkdirs();
        }

        String localFilePath = getFilepath() + localFileName;
        try {
            file.transferTo(new File(localFilePath));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            // log here
        } catch (IOException e) {
            e.printStackTrace();
            // log here
        }
        String imageContextPath = env.getProperty("server.servlet.context-path") + "/uploadFile" + "/" + localFileName;
        // log here +
        System.out.println("received file original name: " + originalName);
        System.out.println("stored local file name: " + localFileName);
        System.out.println("file stored path: " + localFilePath);
        System.out.println("returned url: " + imageContextPath);
        // log here -
        return generateResult(true, imageContextPath);
    }

    private Map<String, String> generateResult(boolean uploaded, String relativeUrl){
        Map<String, String> result = new HashMap<String, String>();
        result.put("uploaded", uploaded + "");
        result.put("url", relativeUrl);

        return result;
    }

    private String getFilepath(){
        String projectOs = "linux";

        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            projectOs="windows";
        }
        return env.getProperty("upload."+projectOs);
    }

}
