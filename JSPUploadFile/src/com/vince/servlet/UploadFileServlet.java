package com.vince.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFileServlet
 */
@WebServlet("/UploadFileServlet")
public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//创建文件项工厂对象
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//创建解析请求数据的组件
		ServletFileUpload upload=new ServletFileUpload(factory);
		try {
			//解析数据
			List<FileItem> list=upload.parseRequest(request);
			for(int i=0;i<list.size();i++){
				FileItem item=list.get(i);
				if(item.isFormField()){//是字符串
					if("desc".equals(item.getFieldName())){
						System.out.println("文件描述:"+new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
					}
				}else{//是文件
					String fileName=item.getName();
					String ext=fileName.substring(fileName.lastIndexOf("."));
					String newFileName=UUID.randomUUID().toString();
					String newFilePath=request.getServletContext().getRealPath("/upload")+"/"+newFileName+ext;
					System.out.println(newFilePath);
					try {
						item.write(new File(newFilePath));
						response.getWriter().println("上传文件成功!");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
