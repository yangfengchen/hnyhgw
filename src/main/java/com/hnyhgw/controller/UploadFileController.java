package com.hnyhgw.controller;

import com.hnyhgw.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value="attachment")
public class UploadFileController extends AbstractBaseController{

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping("uploadFile")
    @ResponseBody
    public Map<String, String> receiveImage(@RequestPart("upload") MultipartFile file, HttpServletRequest request) {
        return attachmentService.ckEditorUploadImage(file, request);
    }

}
