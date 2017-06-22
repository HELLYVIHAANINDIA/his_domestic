package com.hisd.domestic.services;

import com.hisd.common.daointerface.HibernateQueryDao;
import com.hisd.common.daointerface.TblDocumentDao;
import com.hisd.common.services.CommonDAO;
import com.hisd.common.services.ExceptionHandlerService;
import com.hisd.domestic.model.TblDocument;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentService {
	
	@Autowired
	TblDocumentDao tblDocumentDao;
	@Autowired
	HibernateQueryDao hibernateQueryDao;
	@Autowired
	CommonDAO commonDAO;
	@Autowired
	ExceptionHandlerService exceptionHandlerService;
	
	/**
     * to add bidder document
     * @param tblBidderDocument
     * @return boolean
     * @throws Exception 
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public boolean addDocument(TblDocument tblDocument) throws SQLException{
    	boolean bSuccess;             
        tblDocumentDao.addTblDocument(tblDocument);
        bSuccess=true;
        return bSuccess;
    }
    
    /**
     * 
     * @param tblBidderDocument
     * @return
     * @throws Exception
     */
   /* @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public boolean addBidderDocument(TblBidderdocument tblBidderDocument) throws SQLException{
    	boolean bSuccess;             
        tblBidderDocumentDao.addTblBidderdocument(tblBidderDocument);
        bSuccess=true;
        return bSuccess;
    }
    */
    
    /**
     * to get bidder folder
     * @param userId
     * @return {@code List<Object[]>}
     * @throws Exception 
     */
    @Transactional
    public List<Object[]> getDocuments(int objectId,int childId,int subChildId,int otherSubChildId) throws SQLException{
        Map<String, Object> var = new HashMap<String, Object>();
        var.put("objectId",objectId);
        var.put("childId",childId);
        var.put("subChildId",subChildId);
        var.put("otherSubChildId",otherSubChildId);
        StringBuilder query=new StringBuilder();
       
        	query = new StringBuilder("select tblDocument.documentid,tblDocument.fileName,tblDocument.description,tblDocument.fileType,tblDocument.cstatus,tblDocument.createdAt,tblDocument.fileSize,'' from TblDocument tblDocument where ");
            query.append("  tblDocument.objectId=:objectId and tblDocument.childId=:childId and tblDocument.subChildId=:subChildId and tblDocument.otherSubChildId=:otherSubChildId order by createdAt desc ");
        
    
        return hibernateQueryDao.createNewQuery(query.toString(),var);        
    }
    
    
    /**
     * to get bidder doc details based on the doc id
     * @param docId
     * @return
     * @throws Exception 
     */
    @Transactional
    public List<Object[]> getDocument(int docId) throws SQLException{
        Map<String, Object> var = new HashMap<String, Object>();
        var.put("docId",docId);
      
        return hibernateQueryDao.createNewQuery("select tblDocument.fileName, tblDocument.path from TblDocument tblDocument where tblDocument.documentid=:docId order by createdAt desc ",var);
       
    }
    

    /**
     * to change the status of the bidder documents
     * @param docId
     * @param cStatusDoc
     * @return
     * @throws Exception 
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public boolean cancelDocStatus(String docId,int cStatusDoc) throws SQLException{
        int cnt;
        Map<String, Object> var = new HashMap<String, Object>();
        var.put("docId", docId);
        cnt = hibernateQueryDao.updateDeleteNewQuery("update TblOfficerdocument set cstatus=2 where officerDocId in (:docId)",var);
        return cnt!=0;

    }
    
    /**
     * to change the status of the bidder documents
     * @param docId
     * @param cStatusDoc
     * @return
     * @throws Exception 
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public boolean updateDocStatus(String docId,int cStatusDoc) throws SQLException{
        int cnt = 0;
        Map<String, Object> var = new HashMap<String, Object>();
        var.put("docId", docId);
      
        	cnt = hibernateQueryDao.updateDeleteNewQuery("delete from TblDocument where documentid in (:docId)",var);
       
        return cnt!=0;
    }
    
    
    /**
	 * 
	 * @param tenderId
	 * @return
	 * @throws Exception
	 */
	public List<Object[]> getDocumentById(int documentId) throws SQLException {
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("documentId", documentId);
		String query = "select tblTenderDocument.documentId,tblTenderDocument.documentName from TblTenderDocument tblTenderDocument where tblTenderDocument.documentId=:documentId";
        List<Object[]> lst = commonDAO.executeSelect(query, parameters);
        return lst;
	}
	
    /**
     * to delete the file physically
     * @param filePath
     * @return boolean
     */
    public boolean changeDirectoryName(String dirPath,String newFolderName) {
        boolean flg = false;
        try {
        	File dir = new File(dirPath);
    		if (dir.isDirectory()) {
    			System.err.println("There is no directory @ given path");
	    		File newDir = new File(dir.getParent() + File.separator + newFolderName);
	    		dir.renameTo(newDir);
    		}
        } catch (Exception ex) {
        	exceptionHandlerService.writeLog(ex);
        }
        return flg;
    }


}
