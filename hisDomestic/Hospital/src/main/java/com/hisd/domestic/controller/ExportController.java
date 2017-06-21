package com.hisd.domestic.controller;

import java.awt.Color;
import java.awt.Insets;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;
import org.zefer.pd4ml.PD4PageMark;

import com.lowagie.text.DocumentException;
@Controller
public class ExportController {
	@Value("#{projectProperties['doc_upload_path']}")
	private String docUploadPath;
	@RequestMapping(value = "/exportDataFromPage", method = RequestMethod.POST)
    public void generatePDF(HttpServletRequest request, HttpServletResponse response) {
    	try {
        	int generateType =  StringUtils.hasLength(request.getParameter("txtGenerateType")) ? Integer.parseInt(request.getParameter("txtGenerateType")) : 0;
        	String pdfBuffer =  request.getParameter("pdfBuffer");
        	//setFileDefaultData(request); 
            String fileName = request.getParameter("fileName");
            
            if (StringUtils.hasLength(pdfBuffer) && StringUtils.hasLength(fileName)) {
            	reportGeneration(pdfBuffer, fileName, (docUploadPath), generateType, response, request);
            } else {
            	response.sendRedirect(request.getHeader("referer"));
            }
        } catch (Exception e) {
//            exceptionHandlerService.writeLog(e);
        }
    }
	private void reportGeneration(String pdfBuffer, String fileName, String path, int generateType, HttpServletResponse response, HttpServletRequest request) throws IOException, DocumentException, ServletException {
    	pdfBuffer = pdfBuffer.replace("<br>", "<br/>").replace("&nbsp;", " ").replace(" & ", "&amp;").replace("colSpan", "colspan").replace("=\"\"","").replace("BR", "br/");
        
    	File destFolder = new File(path + File.separator + "temp");
        if (destFolder.exists() == false) {
            destFolder.mkdirs();
        }
        if(fileName == null || fileName.isEmpty() || fileName.indexOf("undefined") != -1){
        	fileName = "dataExported";
        }
        fileName = fileName.trim();
        String filePath = path + File.separator + "temp" + File.separator + fileName;
        File file = new File(filePath);
    	ServletOutputStream outputStream = response.getOutputStream();
    	FileOutputStream fos = new FileOutputStream(file);
    	//String cssPath1 = "eProcurement";
        /*if(request.getRequestURL().indexOf(request.getContextPath()) != -1){
        	cssPath1 = request.getRequestURL().substring(0,request.getRequestURL().indexOf(request.getContextPath())+request.getContextPath().length());
        }*/
        StringBuilder htmls = generateFinalData(generateType,pdfBuffer);
        Document htmlParseTagCompleteString = Jsoup.parse(htmls.toString());     
        String finalData= htmlParseTagCompleteString.toString();
        finalData = finalData.replace("&", "&amp;");
        try{
        	if(generateType == 0) {
            	response.setContentType("application/pdf");
           		response.setContentType("application/octet-stream");
    	        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".pdf\"");
                PD4ML pd4mlRender = new PD4ML();
                pd4mlRender.useServletContext(request.getServletContext());
                //pd4mlRender.enableDebugInfo();
              /*  pd4mlRender.addStyle("@media pdf {.col-md-2 {width: 16.66666667%;position: relative;min-height: 1px;padding-right: 15px;padding-left: 15px;float: left;} .col-md-4{width: 33.33333333%;position: relative;min-height: 1px;padding-right: 15px;padding-left: 15px;float: left;}.form-group {\r\n" + 
                        "    float: left;  width: 100%; margin-bottom: 15px;\r\n" + 
                        "}.table {    width: 100%;    max-width: 100%;    margin-bottom: 20px;}.table th {text-align: left;} .dt-button {display:none;} }", true);*/
                pd4mlRender.addStyle(request.getServletContext().getRealPath("/resources/template1/css/style.css"), true);
                pd4mlRender.addStyle(request.getServletContext().getRealPath("/resources/css/bootstrap.min.css"), true);
                pd4mlRender.addStyle(request.getServletContext().getRealPath("/resources/hospital/css/print.css"), true);
                pd4mlRender.adjustHtmlWidth();   
                pd4mlRender.setHtmlWidth(800);
                pd4mlRender.setPageSize(PD4Constants.A4);
                pd4mlRender.setPageInsets(new Insets(20, 15, 25, 15));
                //pd4mlRender.enableSmartTableBreaks(true);
                
                PD4PageMark footer = new PD4PageMark(); // page number is displayed in pdf footer
                footer.setAreaHeight(20);
                footer.setFontSize(12);
                footer.setColor(Color.darkGray);
                footer.setPageNumberTemplate("Page $[page] of $[total]");
                footer.setPageNumberAlignment(PD4PageMark.RIGHT_ALIGN);
                pd4mlRender.setPageFooter(footer);
                finalData = finalData.replaceAll("word-break", "word-wrap");
                InputStream stream = new ByteArrayInputStream(finalData.getBytes(Charset.forName("UTF-8"))); 
                InputStreamReader isr = new InputStreamReader(stream, "UTF-8");
                //pd4mlRender.useTTF(fontPath, true);
                //pd4mlRender.render(isr,outputStream);
                pd4mlRender.render(isr,fos);
                FileInputStream fis= new FileInputStream(file);
                int i;
                while((i=fis.read())!= -1){
                	outputStream.write(i);
                }
                fis.close();
                deleteIfExist(file); 
            } else if(generateType == 2) {
               response.setContentType("text/html;charset=UTF-8");
               response.setCharacterEncoding("UTF-8");
               response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".html\"");
               outputStream.write(htmls.toString().getBytes());
           } else if(generateType == 3) {
               response.setContentType("application/vnd.ms-word");
               response.setCharacterEncoding("UTF-8");
               response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".doc\"");
               outputStream.write(finalData.getBytes());
           } else if(generateType == 4) {
               response.setContentType("application/vnd.ms-excel");
               response.setCharacterEncoding("UTF-8");
               response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + ".xls\"");
               finalData = removeSpecialChars(finalData); 
               outputStream.write(finalData.getBytes());
           } 
        }catch(Exception e){
//        	exceptionHandlerService.writeLog(e);
        }finally{
        	if(fos!=null){
        		fos.close();
        	}
        }
    
    }
	 public StringBuilder generateFinalData( int generateType, String pdfBuffer){		
	        StringBuilder htmls = new StringBuilder();
	        htmls.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
	        htmls.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
	        htmls.append("<head>");
	        htmls.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			if(generateType == 3) {
		        htmls.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		    } else { 
		        htmls.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
		    }
			htmls.append("</head>");
	        htmls.append("<body>").append(pdfBuffer).append("</body></html>");
	        return htmls; 
		}
	 
	   private void deleteIfExist(File file) {
	    	try {
	    		if (file.exists()){
	    			file.delete();
	    		}
	    	}catch(Exception e) {
//	    		exceptionHandlerService.writeLog(e);
	    	}
	    }
	   
	   public static String removeSpecialChars(String str) {
			 return str.replaceAll("(?s)&amp;lt;.*?&amp;gt;", " ");
		}

}
