package com.imooc.myo2o.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 *<p>Description:判断传入的文件类型并进行相应的处理<p>	
 * @author Administrator
 * @version 2020-10-17
 *
 */
public class FileDeal{
	
	public static  CommonsMultipartFile ftoCommonsMultipartFile(File file,String fieldName) {
		FileItemFactory factory = new DiskFileItemFactory(16,null);
		 FileItem item = factory.createItem(fieldName, "text/plain", true, file.getName());
	        int bytesRead = 0;
	        byte[] buffer = new byte[8192];
	        try {
	            FileInputStream fis = new FileInputStream(file);
	            OutputStream os = item.getOutputStream();
	            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
	                os.write(buffer, 0, bytesRead);
	            }
	            os.close();
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return new CommonsMultipartFile(item);
	}


	

}
