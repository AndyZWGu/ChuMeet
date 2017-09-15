package com.member.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class FileUploadUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public FileUploadUtil() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//doPost(request,response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//Servlet3.0����part���淽��n���ς�
		Collection<Part> filePart = request.getParts();
		System.out.println("FilePart's Size="+filePart.size());
		for(Part part:filePart){
			if(getFileNameFromPart(part)!=null&&part.getContentType()!=null){
				//���빦��
				String fileName=getFileNameFromPart(part);//����������
				//�~��yԇ InputStream �c byte[] (�͌���model��VO�A���ʂ�)
				InputStream in = part.getInputStream();//λԪ�M����
				byte[] memAvatar = new byte[in.available()];//�L��
				in.read(memAvatar);//��������byte[]
				in.close();
			}
		}
		
		
		
		
	}
	// ȡ���ς��ęn�����Q (���APIδ�ṩmethod,���Ա������׫��)
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		System.out.println("header=" + header); // �yԇ��
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		System.out.println("filename=" + filename); // �yԇ��
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}
	
}
