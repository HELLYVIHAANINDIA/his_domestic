/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 *
 */
@Service("TenderAuditTrailService")
public class AuditTrailService {
/*
	@Autowired
	private TblTenderAuditTrailDao tblTenderAuditTrailDao;

*/	/**
	 * To make Audit in eProc
	 *
	 * @param audit object set in Filter comprising trackLoginId and url
	 * @param linkId url accessed by user
	 * @param remarks status for the action
	 * @param TenderId it contains TenderId
	 * @param objectId it is the primary key of respective table
	 * @param remarkSign remarks from remarks Box and/or signed text generated(in case of pki) 
	 * controller
	 */
	public void makeAuditTrail(Object audit, int linkId, String remarks, Integer tenderId,Integer objectId,String... remarkSign) {
		RequestContextHolder.getRequestAttributes().setAttribute("helpLinkId", linkId, RequestAttributes.SCOPE_REQUEST);// To use to generate help content.
		/*if (audit != null && audit instanceof TblAuditTrail) {
			TblAuditTrail auditMasterAdmin = (TblAuditTrail) audit;
			TblTenderAuditTrail auditMaster = new TblTenderAuditTrail();
			auditMaster.setPageUrl(auditMasterAdmin.getPageUrl());
			auditMaster.setTblTrackLogin(auditMasterAdmin.getTblTrackLogin());
			auditMaster.setRemark(remarks != null ? remarks : "");
			auditMaster.setLinkId(linkId);
			auditMaster.setTenderId(tenderId==null ? 0 : tenderId);
			auditMaster.setObjectId(objectId==null ? 0 : objectId);
			tblTenderAuditTrailDao.addTblTenderAuditTrail(auditMaster);                
		}*/
	}
}                
