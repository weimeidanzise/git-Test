package cn.itcast.controller;

import cn.itcast.domain.Userr;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class upLoadController {
    private Map<String, String> itemMap = new HashMap<>();
    //设定允许上传的文件类型
    private String[] allowType = {"image/jpeg"};

    @RequestMapping("/upload")
    public String upLoadOne(HttpServletRequest request) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //创建文件对象
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir(); //如果当前木库不存在 则创建
        }
        //实现上传的步骤
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            //判断是否为文本域
            if (item.isFormField()) {
                String textName = item.getFieldName();
                String value = item.getString("UTF-8");
                itemMap.put(textName, value);
            } else {//文件域
                String itemname = item.getName();
                String fileName = item.getString();
                //文件上传到指定位置
                item.write(new File(realPath,itemname));
                //获取上传文件的类型
                String contentType = item.getContentType();
                if (!Arrays.asList(allowType).contains(contentType)) {
                    throw new RuntimeException("上传类型不符合要求");
                }
                itemMap.put(itemname, fileName);
            }
        }
        Userr user = new Userr();
        user.setUsername(itemMap.get("username"));
        user.setAddrss(itemMap.get("address"));


        System.out.println(user);
        return "success";
    }




}
