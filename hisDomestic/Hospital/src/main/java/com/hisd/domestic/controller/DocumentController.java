package com.hisd.domestic.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hisd.common.services.CommonService;
import com.hisd.common.services.ExceptionHandlerService;
import com.hisd.common.utility.CommonKeywords;
import com.hisd.common.utility.SessionBean;
import com.hisd.domestic.model.TblDocument;
import com.hisd.domestic.services.DocumentService;

@Controller
public class DocumentController {
	@Value("#{projectProperties['doc_upload_path']}")
	private String docUploadPath;
	@Value("#{projectProperties['file.allowedSize']}")
	private Long allowedSize;
	@Value("#{projectProperties['file.allowedExt']}")
	private String allowedExt;
	@Value("#{projectProperties['file.allowedExt.customize']}")
	private String allowedExtCustomize;
	@Autowired
    private MessageSource messageSource;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private ExceptionHandlerService exceptionHandlerService;
	@Autowired
    ServletContext context;
	@Autowired
	CommonService commonService;
	@Value("#{projectProperties['file_dateformate']}")
    private String file_dateformate;
	@Value("#{projectProperties['client_dateformate_hhmm']}")
    private String client_dateformate_hhmm;
	
	
	
	
	private static final int FILESIGNATURE_ZIP[] = new int[]{0x50, 0x4B, 0x03, 0x04};
	private static final int FILESIGNATURE_PDF[] = new int[]{0x25, 0x50, 0x44, 0x46};
	private static final int FILESIGNATURE_RAR[] = new int[]{0x52, 0x61, 0x72, 0x21, 0x1A, 0x07, 0x00};
	private static final int FILESIGNATURE_EXE[] = new int[]{0x4D, 0x5A};
	private static final int FILESIGNATURE_DOCX_XLSX[] =  new int[]{0x50, 0x4B, 0x03, 0x04, 0x14, 0x00, 0x06, 0x00};
	private static final int FILESIGNATURE_DOC_PPT_XLS_PPS[] = new int[]{0xD0, 0xCF, 0x11, 0xE0, 0xA1, 0xB1, 0x1A, 0xE1};
	private static final String TXT_OBJECTID ="txtobjectId";
	private static final String OBJECTID ="objectId";
	private static final String DOC_ID ="docId";
	
	@RequestMapping(value = "/etender/bidder/uploadbriefcasedocuments/{objectId}/{tenderId}", method = RequestMethod.GET)
    public String uploadBriefcaseDocuments(@PathVariable("objectId") int objectId,@PathVariable("tenderId") int tenderId, HttpServletRequest request, ModelMap modelMap) {
	try{
		long allowedsize = allowedSize;   
		modelMap.addAttribute("allowedExt", allowedExt);
		modelMap.addAttribute("allowedSize", allowedsize/1024);
	    modelMap.addAttribute("objectId", objectId);
	}catch (Exception e) {
		return exceptionHandlerService.writeLog(e);
	}
		return "etender/buyer/UploadDocuments";
    }
	
	 /**
     * @param tenderId
     * @param tabId
     * @param request
     * @param modelMap
     * @return ajax jsp
     */
/*    @RequestMapping(value = "/etender/bidder/briefcasecontent", method = RequestMethod.POST)
    public String briefcaseContent(@RequestBody String requestData,HttpServletRequest request, ModelMap modelMap) {
    	int objectId = 0;
    	int txtTabId=0;
    	int hdTenderId=0;
    	int txtLinkId=0;
        try {
        	objectId = StringUtils.hasLength(request.getParameter("hdObjectId")) ? Integer.parseInt(request.getParameter("hdObjectId")) : 0;
        	txtTabId = StringUtils.hasLength(request.getParameter("txtTabId")) ? Integer.parseInt(request.getParameter("txtTabId")) : 0;
        	hdTenderId = StringUtils.hasLength(request.getParameter("hdTenderId")) ? Integer.parseInt(request.getParameter("hdTenderId")) : 0;
        	txtLinkId = StringUtils.hasLength(request.getParameter("txtLinkId")) ? Integer.parseInt(request.getParameter("txtLinkId")) : 0;
        	    int allowedSize = 0;
        		long allowedsize = allowedSize;   
        		modelMap.addAttribute("allowedExt", allowedExt);
        		modelMap.addAttribute("allowedSize", allowedsize/1024);
        		modelMap.addAttribute("linkId", txtLinkId);	
        	    modelMap.addAttribute("objectId", objectId);
        	    modelMap.addAttribute("cStatusDoc", 1);
                modelMap.addAttribute("otherObjectId", 1);
                modelMap.addAttribute("tabId", txtTabId);
                modelMap.addAttribute("documentCheckList", getDocumentCheckListJson(hdTenderId));
    	} catch (Exception e) {
    		return exceptionHandlerService.writeLog(e);	
        } finally {
        }
        return "/etender/buyer/BriefcaseContent";
    }*/
    
    
    @RequestMapping(value = "/ajax/submitfileupload",method = RequestMethod.POST)
    public void ajaxSubmitFileUpload(HttpServletRequest request, HttpServletResponse response,HttpSession session,@RequestParam("fileToUpload") CommonsMultipartFile multipartFile){
    	 boolean isValidate = true;
         String result="";
         Integer objectId=0;
         String donloadDocPath="";
         int childId=0;
         int subChildId=0;
         int otherSubChildId=0;
         try {
        	 PrintWriter out = response.getWriter();
        	 SessionBean sessionBean= (SessionBean) session.getAttribute("sessionObject")!=null?(SessionBean) session.getAttribute("sessionObject"):new SessionBean();
        	 response.setContentType("text/html");
	             String fileDesc = null;
	             DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	             fileItemFactory.setSizeThreshold(1 * 1024 * 1024);
	             String description=StringUtils.hasLength(request.getParameter("txtDocDesc")) ? request.getParameter("txtDocDesc") : null;
	             objectId = StringUtils.hasLength(request.getParameter(TXT_OBJECTID)) ? Integer.parseInt(request.getParameter(TXT_OBJECTID)) : 0;
	        	 childId=StringUtils.hasLength(request.getParameter("txtChildId")) ? Integer.parseInt(request.getParameter("txtChildId")) : 0;
	        	 subChildId=StringUtils.hasLength(request.getParameter("txtSubChildId")) ? Integer.parseInt(request.getParameter("txtSubChildId")) : 0;
	        	 otherSubChildId=StringUtils.hasLength(request.getParameter("txtOtherSubChildId")) ? Integer.parseInt(request.getParameter("txtOtherSubChildId")) : 0;
	        	 
	             boolean fileUploadedSuccess = false;
	             File file;
	             File tmpDir;
	             Integer fileSize = 0;
	             String fileName = "";
	             long fileMaxSize = allowedSize;
	             String fileExtensions = allowedExt;//=txt,zip,pdf,jpeg,jpg,gif,bmp,png,tif,tiff,doc,xls,ppt,pps,dxf,docx,xlsx,eml
	             String fileType="";
	            	 if(description == null){
	            		 isValidate = false;
	            		 result=messageSource.getMessage("msg_tender_docbrief_empty", null, LocaleContextHolder.getLocale());
	            	 }
	                 FileItem item = multipartFile.getFileItem();
	                 if (item.isFormField()) {
	                     if (item.getFieldName().equals("txtDocDesc")) {
	                         fileDesc = item.getString();
	                         if(fileDesc == null || "".equalsIgnoreCase(fileDesc.trim())){
	                             isValidate = false;
	                         }
	                     }
	                 } else {
	                     fileSize = (int) item.getSize();
	                     if (item.getName().lastIndexOf(File.separator) != -1) {
	                         fileName = item.getName().substring(item.getName().lastIndexOf(File.separator) + 1, item.getName().length());
	                     } else {
	                         fileName = item.getName();
	                         int j = fileName.lastIndexOf('.');
	                         fileType = fileName.substring(j + 1);
	                     }
	                     if (fileName != null && !fileName.equalsIgnoreCase("")) {
	                         if(fileSize == 0){
	                        	 result=messageSource.getMessage("msg_tender_emptyfile", null, LocaleContextHolder.getLocale());
	                             isValidate = false;
	                         }
	                         if (!checkFileSize(fileSize, fileMaxSize)) {
	                        	 result= messageSource.getMessage("msg_tender_filesizeexceeds", new Object[]{fileMaxSize / (1024*1024)}, LocaleContextHolder.getLocale());
	                             isValidate = false;
	                         }
	                         if (!checkFileExn(fileName, fileExtensions)) {
	                        	 if(objectId == 6 || objectId == 7){
	                        		 result=messageSource.getMessage("msg_tender_acceptablefiletypes", new Object[]{allowedExtCustomize}, LocaleContextHolder.getLocale());
	                        	 }else{
	                        		 result=messageSource.getMessage("msg_tender_acceptablefiletypes", new Object[]{allowedExt}, LocaleContextHolder.getLocale());
	                        	 }
	                             isValidate = false;
	                         } else {
	                        	 /* if destination directory not exist then create it */
	                        	 isDirExists(docUploadPath.split(":")[0]+":\\\\", docUploadPath.substring(3, docUploadPath.length()));
	                        	 StringBuilder tmpDirPath=new StringBuilder();
	                        	 tmpDirPath.append(docUploadPath+File.separator+"Bidder"+File.separator+objectId+File.separator+objectId+File.separator+childId+File.separator+subChildId+File.separator+otherSubChildId);
		                         tmpDir = new File(tmpDirPath.toString());
		                         donloadDocPath=File.separator+"Patient"+File.separator+objectId+File.separator+objectId+File.separator+childId+File.separator+subChildId+File.separator+otherSubChildId;
	                        	
	                             if (!tmpDir.isDirectory()) {
	                            	 tmpDir.mkdirs();
	                             }
	                             file = new File(tmpDir, fileName);
	                             if (file.exists() && fileName.contains(".")) {
	                            		 String fName = fileName.substring(0,fileName.indexOf('.'));
	                            		 fileName = "";
	                            		 SimpleDateFormat newSimpleDateFormat = new SimpleDateFormat(file_dateformate);
	                            		 fileName = fName + newSimpleDateFormat.format(new Date()) + "." + fileType;
	                            		 file = new File(tmpDir, fileName);
	                             }
	                             item.write(file);
	                             if (!isValidContentType(file)) {
	                                  file.delete();
	                                  result= messageSource.getMessage("msg_tender_invalidfiletype", null, LocaleContextHolder.getLocale());
	                                  fileUploadedSuccess = false;
	                                  isValidate = false;
	                              } else {
	                                 fileUploadedSuccess = true;
	                             }
	                         }
	                     }
	                 }
	             if (isValidate) {
	                 if (fileUploadedSuccess) {
            	 		TblDocument tblDocument = new TblDocument();	
            	 		tblDocument.setFileName(fileName);
            	 		tblDocument.setPath(donloadDocPath);
            	 		tblDocument.setChildId(childId);
            	 		tblDocument.setCstatus(0);
            	 		tblDocument.setDescription(description);
            	 		tblDocument.setFileSize(fileSize);
            	 		tblDocument.setFileType(fileType);
            	 		tblDocument.setObjectId(objectId);
            	 		tblDocument.setOfficerId(Integer.parseInt(String.valueOf(sessionBean.getUserId())));
            	 		tblDocument.setSubChildId(subChildId);
            	 		tblDocument.setOtherSubChildId(otherSubChildId);
                	 	documentService.addDocument(tblDocument);
	                	out.print(result);
	                 }else{
	                	 out.print("Error:" + result);
	                 }
	             }else{
	            	 out.print("Error:" + result);
	             }
         } catch (Exception e) {
        	 exceptionHandlerService.writeLog(e);
         } finally {
         }
    }
    
        
    
    @RequestMapping(value = "/ajax/getuploadeddocs",method = RequestMethod.POST)
    public void getUploadedDocs(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        int objectId;
        int childId;
        int subChildId;
        int otherSubChildId;
        int patientid;
        JSONArray jsonArray = new JSONArray();
        SessionBean sessionBean= (SessionBean) session.getAttribute("sessionObject")!=null?(SessionBean) session.getAttribute("sessionObject"):new SessionBean();
        try {	
	        	objectId=StringUtils.hasLength(request.getParameter(OBJECTID)) ? Integer.parseInt(request.getParameter(OBJECTID)) : 0;
	        	childId=StringUtils.hasLength(request.getParameter("childId")) ? Integer.parseInt(request.getParameter("childId")) : 0;
	        	subChildId=StringUtils.hasLength(request.getParameter("subChildId")) ? Integer.parseInt(request.getParameter("subChildId")) : 0;
	        	otherSubChildId=StringUtils.hasLength(request.getParameter("otherSubChildId")) ? Integer.parseInt(request.getParameter("otherSubChildId")) : 0;
	        	//condition return to handle document functionlity without login : exception
	        	List<Object[]> lstDocuments =null;
	    			lstDocuments =documentService.getDocuments(objectId, childId, subChildId,otherSubChildId);
	        	
	        	if(lstDocuments!=null && !lstDocuments.isEmpty()) {
	        		int cnt=1;
	        		for (Object[] objects : lstDocuments) {
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("Sr.No", cnt++);
						jsonObject.put("DocId", objects[0]);
						jsonObject.put("fileName", objects[1]);
						jsonObject.put("cStatus", objects[4]);
						jsonArray.put(jsonObject);
					}
	        	}
	            response.getWriter().write(jsonArray.toString());
//        	}else{
//        		response.getWriter().write("sessionexpired");
//        	}
        } catch (Exception ex) {
        	exceptionHandlerService.writeLog(ex);	
        }
        
    }
    
    
    @RequestMapping(value = "/ajax/deletebriefcasefile",method = RequestMethod.POST)
    public void removeUploadedFile(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
    	int objectId=0;
        String docId = StringUtils.hasLength(request.getParameter(DOC_ID)) ? request.getParameter(DOC_ID) : "";
        int cStatusDoc=0;
        cStatusDoc = StringUtils.hasLength(request.getParameter("cStatusDoc")) ? Integer.parseInt(request.getParameter("cStatusDoc")) : 0;
        objectId=StringUtils.hasLength(request.getParameter(OBJECTID)) ? Integer.parseInt(request.getParameter(OBJECTID)) : 0;
        boolean renameFlag = false;
        SessionBean sessionBean= (SessionBean) session.getAttribute("sessionObject")!=null?(SessionBean) session.getAttribute("sessionObject"):new SessionBean();
        int userType = 0;
        try {
        	if(sessionBean!=null){
        		userType=sessionBean.getUserTypeId();
        	}
        	//in case of tender authority and bidder registration userType would be 2
        	List<Object[]> tblOfficerDocument = null;
        	tblOfficerDocument=documentService.getDocument(Integer.parseInt(docId),userType);
//        	if(session.getAttribute(CommonKeywords.SESSION_OBJ.toString()) != null) {
	    		for(int i=0;i<tblOfficerDocument.size();i++){
		    		String filePath=docUploadPath+tblOfficerDocument.get(i)[1].toString();
		    		renameFlag = renameFile(filePath,tblOfficerDocument.get(i)[0].toString());
	    		}
	    		if (renameFlag) {
	    			renameFlag = documentService.updateDocStatus(docId, cStatusDoc,userType);
	            }
	          response.getWriter().write(String.valueOf(renameFlag));
//        	}else{
//        		response.getWriter().write("sessionexpired");
//        	}
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);	
        }
    }
    
    
    
    @RequestMapping(value = "/ajax/canceldocument",method = RequestMethod.POST)
    public void cancelUploadedFile(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        String docId = StringUtils.hasLength(request.getParameter(DOC_ID)) ? request.getParameter(DOC_ID) : "";
        int cStatusDoc=0;
        cStatusDoc = StringUtils.hasLength(request.getParameter("cStatusDoc")) ? Integer.parseInt(request.getParameter("cStatusDoc")) : 0;
        boolean renameFlag = false;
        SessionBean sessionBean= (SessionBean) session.getAttribute("sessionObject");
        try {
        	if(session.getAttribute(CommonKeywords.SESSION_OBJ.toString()) != null) {
	    		List<Object[]> tblOfficerDocument=documentService.getDocument(Integer.parseInt(docId),sessionBean.getUserTypeId());
	    		for(int i=0;i<tblOfficerDocument.size();i++){
		    		String filePath=docUploadPath+tblOfficerDocument.get(i)[1].toString();
		    		renameFlag = renameCancelFile(filePath,tblOfficerDocument.get(i)[0].toString());
	    		}
	    		if (renameFlag) {
	    			renameFlag = documentService.cancelDocStatus(docId, cStatusDoc);
	            }
	          response.getWriter().write(String.valueOf(renameFlag));
        	}else{
        		response.getWriter().write("sessionexpired");
        	}
        } catch (Exception e) {
        	exceptionHandlerService.writeLog(e);	
        }
    }
    
    
    
    @RequestMapping(value = "/ajax/downloadbriefcasefile/{docId}")
    public void downloadBriefcaseFile(@PathVariable(DOC_ID) int docId,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        ServletOutputStream outputStream = null;
        InputStream fis=null;
        SessionBean sessionBean= (SessionBean) session.getAttribute("sessionObject")!=null?(SessionBean) session.getAttribute("sessionObject"):new SessionBean();
        try {
        	//this line of code added to suffies condition : if user has not logged in and want to download documents
        	String filePath=null;
        	String fileName=null;
    		List<Object[]> tblOfficerDocument=documentService.getDocument(docId,sessionBean.getUserTypeId());
    		if(!tblOfficerDocument.isEmpty()){
	    		filePath=docUploadPath+tblOfficerDocument.get(0)[1].toString();
	    		filePath += File.separator+tblOfficerDocument.get(0)[0].toString();
	    		fileName=tblOfficerDocument.get(0)[0].toString();
    		}
            File file;
            file = new File(filePath);
            fis = new FileInputStream(file);
            byte[] buf = new byte[(int) file.length()];
            int offset = 0;
            int numRead = 0;
            while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) {
                offset += numRead;
            }
            
            // gets MIME type of the file
            String mimeType = context.getMimeType(filePath);
            if (mimeType == null) {        
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
             
            // modifies response
            response.setContentType(mimeType);
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName +"\"");
            outputStream = response.getOutputStream();
            outputStream.write(buf);
            outputStream.flush();
            outputStream.close();
        } catch (Exception ex) {
        	exceptionHandlerService.writeLog(ex);
        }finally{
        	if(fis!=null){
        		fis.close();
        	}
        }
    }
    
    
    
    @RequestMapping(value = "/ajax/downloadbriefcasefile/{docId}/{objectId}/{tempobjectId}")
    public void downloadBriefcaseFileForSpecificObjectId(@PathVariable(DOC_ID) int docId,@PathVariable("objectId") int objectId,@PathVariable("tempobjectId") int dd,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        ServletOutputStream outputStream = null;
        InputStream fis=null;
        SessionBean sessionBean= (SessionBean) session.getAttribute("sessionObject")!=null?(SessionBean) session.getAttribute("sessionObject"):new SessionBean();
        try {
        	//this line of code added to suffies condition : if user has not logged in and want to download documents
        	String filePath=null;
        	String fileName=null;
        	List<Object[]> tblOfficerDocument = null;
        	if(objectId==6 || objectId==7) {
        		tblOfficerDocument=documentService.getDocument(docId,2);
        	}else {
        		tblOfficerDocument=documentService.getDocument(docId,sessionBean.getUserTypeId());
        	}
    		
    		if(!tblOfficerDocument.isEmpty()){
	    		filePath=docUploadPath+tblOfficerDocument.get(0)[1].toString();
	    		filePath += File.separator+tblOfficerDocument.get(0)[0].toString();
	    		fileName=tblOfficerDocument.get(0)[0].toString();
    		}
            File file = null;
            file = new File(filePath);
            fis = new FileInputStream(file);
            byte[] buf = new byte[(int) file.length()];
            int offset = 0;
            int numRead = 0;
            while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) {
                offset += numRead;
            }
            
            // gets MIME type of the file
            String mimeType = context.getMimeType(filePath);
            if (mimeType == null) {        
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
             
            // modifies response
            response.setContentType(mimeType);
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName +"\"");
            outputStream = response.getOutputStream();
            outputStream.write(buf);
            outputStream.flush();
            outputStream.close();
        } catch (Exception ex) {
        	exceptionHandlerService.writeLog(ex);
        }finally{
        	if(fis!=null){
        		fis.close();
        	}
        }
    }
    
    
    @RequestMapping(value = "/ajax/downloadbriefcasefile/{docId}/{usertype}")
    public void downloadBriefcaseFile(@PathVariable(DOC_ID) int docId,@PathVariable("usertype") int usertype,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        ServletOutputStream outputStream = null;
        InputStream fis=null;
        try {
        	
        	//this line of code added to suffies condition : if user has not logged in and want to download documents
        	
        	String filePath=null;
        	String fileName=null;
    		List<Object[]> tblOfficerDocument=documentService.getDocument(docId,usertype);
    		if(!tblOfficerDocument.isEmpty()){
	    		filePath=docUploadPath+tblOfficerDocument.get(0)[1].toString();
	    		filePath += File.separator+tblOfficerDocument.get(0)[0].toString();
	    		fileName=tblOfficerDocument.get(0)[0].toString();
    		}
            File file = null;
            file = new File(filePath);
            fis = new FileInputStream(file);
            byte[] buf = new byte[(int) file.length()];
            int offset = 0;
            int numRead = 0;
            while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length - offset)) >= 0)) {
                offset += numRead;
            }
            
            // gets MIME type of the file
            String mimeType = context.getMimeType(filePath);
            if (mimeType == null) {        
                // set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
             
            // modifies response
            response.setContentType(mimeType);
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName +"\"");
            outputStream = response.getOutputStream();
            outputStream.write(buf);
            outputStream.flush();
            outputStream.close();
        } catch (Exception ex) {
        	exceptionHandlerService.writeLog(ex);
        }finally{
        	if(fis!=null){
        		fis.close();
        	}
        		
        }
    }
    
    
    
    /**
     * to check the file size   
     * @param fielSize
     * @param maxFileSize
     * @return boolean
     */
    private boolean checkFileSize(long fielSize, long maxFileSize) {
        boolean chextn;
        if (maxFileSize >= fielSize) {
            chextn = true;
        } else {
            chextn = false;
        }
        return chextn;
    }
    
    /**
     * to check file extention
     * @param fileName
     * @param allowExtensions
     * @return boolean
     */
    private boolean checkFileExn(String fileName, String allowExtensions) {
        boolean chextn = false;
        int j = fileName.lastIndexOf('.');
        String lst = fileName.substring(j + 1);
        String str = allowExtensions;
        String[] str1 = str.split(",");
        for (int i = 0; i < str1.length; i++) {
            if (str1[i].trim().equalsIgnoreCase(lst)) {
                chextn = true;
            }
        }
        return chextn;
    }
    
    /**
     * to check the valid type 
     * @param file
     * @return boolean
     * @throws FileNotFoundException
     * @throws IOException
     */
    private boolean isValidContentType(File file) throws FileNotFoundException, IOException {
        boolean flag = false;
        int count = 0;
        FileInputStream fis = new FileInputStream(file);
        int j = file.getName().lastIndexOf('.');
        String fileExt = file.getName().substring(j + 1);
        if ("pdf".equalsIgnoreCase(fileExt)) {
            for (int i = 0; i < FILESIGNATURE_PDF.length; ++i) {
                if (fis.read() != FILESIGNATURE_PDF[i]) {
                    count++;
                }
            }
        } else if ("zip".equalsIgnoreCase(fileExt)) {
            for (int i = 0; i < FILESIGNATURE_ZIP.length; ++i) {
                if (fis.read() != FILESIGNATURE_ZIP[i]) {
                    count++;
                }
            }
        } else if ("rar".equalsIgnoreCase(fileExt)) {
            for (int i = 0; i < FILESIGNATURE_RAR.length; ++i) {
                if (fis.read() != FILESIGNATURE_RAR[i]) {
                    count++;
                }
            }
        }else if ("exe".equalsIgnoreCase(fileExt)) {
            for (int i = 0; i < FILESIGNATURE_EXE.length; ++i) {
                if (fis.read() != FILESIGNATURE_EXE[i]) {
                    count++;
                }
            }
        }else if ("DOCX".equalsIgnoreCase(fileExt) || "XLSX".equalsIgnoreCase(fileExt)) {
            for (int i = 0; i < FILESIGNATURE_DOCX_XLSX.length; ++i) {
                if (fis.read() != FILESIGNATURE_DOCX_XLSX[i]) {
                    count++;
                }
            }
        }else if ("doc".equalsIgnoreCase(fileExt) || "ppt".equalsIgnoreCase(fileExt) || "xls".equalsIgnoreCase(fileExt) || "pps".equalsIgnoreCase(fileExt)) {
            for (int i = 0; i < FILESIGNATURE_DOC_PPT_XLS_PPS.length; ++i) {
                if (fis.read() != FILESIGNATURE_DOC_PPT_XLS_PPS[i]) {
                    count++;
                }
            }
        }
        if (count > 0) {
            flag = false;
        } else {
            flag = true;
        }
        fis.close();
        return flag;
    }
    
    /**
     * create directory if it does not exists
     * @param drive
     * @param rpath
     * @return boolean
        String[] tpath = rpath.split("\\\\");
     */
    private boolean isDirExists(String drive, String rpath) {
        boolean flag = false;
        String[] tpath = rpath.split("\\\\");
        StringBuilder path = new StringBuilder();
        path.append(drive);

        for (int i = 0; i < tpath.length; i++) {
            path.append("\\").append(tpath[i]);

            File f = new File(path.toString());

            if (!f.isDirectory()) {
                f.mkdirs();
            }
        }
        return flag;
    }
    

    /**
     * to delete the file physically
     * @param filePath
     * @return boolean
     */
    private boolean renameFile(String filePath,String oldFileName) {
        boolean flg = false;
        try {
            File f = new File(filePath+File.separator+oldFileName);
            File f2=new File(filePath+File.separator+oldFileName.replace(".", "_deleted"+commonService.getServerDateTime().toString().replace(".","_").replace(":","_")+"."));
            if(f.exists()){
            	flg=f.renameTo(f2);
            }
        } catch (Exception ex) {
        	exceptionHandlerService.writeLog(ex);
        }
        return flg;
    }
    
    private boolean renameCancelFile(String filePath,String oldFileName) {
        boolean flg = false;
        try {
            File f = new File(filePath+File.separator+oldFileName);
            File f2=new File(filePath+File.separator+oldFileName.replace(".", "_cancel"+new Date().toString().replace(".","_").replace(":","_")+"."));
            if(f.exists()){
            	flg=f.renameTo(f2);
            }
        } catch (Exception ex) {
        	exceptionHandlerService.writeLog(ex);
        }
        return flg;
    }
    
   
    /**
     * 
     * @return
     */
  /*  private String getDocumentCheckListJson(int tenderId) {
    	String jsonStr = "";
	    StringBuilder json = new StringBuilder("[");
    	try {
				List<Object[]> tblTenderDocumentCheckList = eventCreationService.getTenderDocumentChecklist(tenderId);
				if(tblTenderDocumentCheckList!=null && !tblTenderDocumentCheckList.isEmpty()){
					for (Object[] tblTenderDocument: tblTenderDocumentCheckList) {
						json.append("{\"value\":\""+tblTenderDocument[0]+"\",\"label\":\""+tblTenderDocument[1]+"\"}").append(",");
					}
				}
				jsonStr = json.toString().replaceAll(",$", "");
				jsonStr=jsonStr+"]";
			} catch (Exception ex) {
			     exceptionHandlerService.writeLog(ex);
			} 
    	return jsonStr;
    }
*/
}
