package com.shijw.back.readResourcesFile;
 
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 
@RestController
public class TestController {
 
    @RequestMapping("testFile")
    public String testFile() throws IOException {
        // ClassPathResource类的构造方法接收路径名称，自动去classpath路径下找文件
        ClassPathResource classPathResource = new ClassPathResource("test.txt");
         
        // 获得File对象，当然也可以获取输入流对象
        File file = classPathResource.getFile();
         
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
         
        return content.toString();
    }
}