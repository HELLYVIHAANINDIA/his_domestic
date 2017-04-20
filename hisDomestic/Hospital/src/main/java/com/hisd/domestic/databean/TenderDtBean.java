/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hisd.domestic.databean;

import java.math.BigDecimal;
import java.util.Map;
import org.springframework.core.convert.ConversionService;

/**
 *
 */
public class TenderDtBean {

    private String domainsForspecialCharacterSkip;
	private String txtTenderNo;
    private int txtParentDepartment;
    private int selDeptOfficial;
    private String txtaTenderBrief;
    private String rtfTenderDetail;
    private String txtaKeyword;
    private int selEnvelopeType = 0;
    private String[] selFormType;
    private String txtValidityPeriod = "0";
    private int selProcurementNatureId = 0;
    private int selDownloadDocument = 1;
    private String txtTenderValue = "0";
    private int selIsSplitPOAllowed = 0;
    private int selIsItemwiseWinner = 0;
    private int selSubmissionMode = 1;
    private int selTenderMode = 0;
    private int selBiddingType = 0;
    private int selCurrencyId;
    private int selIsConsortiumAllowed = 0;
    private int selIsFormBasedConsortium = 0;
    private int selIsBidWithdrawal = 1;
    private int selBiddingVariant = 1;
    private int selIsPreBidMeeting = 0;
    private int selPreBidMode = 0;
    private int isPastEvent;
    private String txtaPreBidAddress = "";
    private String txtaDocumentSubmission = "";
    private int selIsWorkflowRequired = 1;
    private int selWorkflowType;
    private int selIsQuestionAnswer = 0;
    private String txtDocumentStartDate;
    private String txtDocumentEndDate;
    private String txtSubmissionStartDate;
    private String txtSubmissionEndDate;
    private String txtPreBidStartDate;
    private String txtBidOpenDate;
    private String txtQuestionAnswerStartDate;
    private String txtQuestionAnswerEndDate;
    private int selIsDocfeesApplicable = 1;
    private int selDocFeePaymentMode = 2;
    private String txtDocumentFee = "";
    private String txtaDocFeePaymentAddress = "";
    private int selIsSecurityfeesApplicable = 0;
    private int selSecFeePaymentMode = 2;
    private String txtSecurityFee = "";
    private String txtaSecFeePaymentAddress = "";
    private int selEmdPaymentMode = 2;
    private String txtEmdAmount = "";
    private String txtaEmdPaymentAddress = "";
    private String txtProjectDuration = "0";
    private int selIsEMDApplicable = 0;
    private int selDecimalValueUpto = 3;
    private int selEventType = 0;
    private String txtPreBidEndDate;
    private int hdEventTypeId = 0;
    private int hdTenderId = 0;
    private String hdOpType;
    private String txtOtherProcNature;
    private boolean isCorrigendum = false;
    private int isOpeningByCommittee = 1;
    private int forHomePage = 1;
    private int isEncodedName = 0;
    private int isMandatoryDocument = 0;
    private int isEncDocumentOnly = 0;
    private int isRebateForm = 1;
    private int isNegotiationAllowed = 0;
    private int isFinalPriceSheetReq=0;
    private int isDisplayClarificationDoc=0;
    private int isCreateAuction = 0;
    private int encryptionLevel = 2;
    private int autoResultSharing = 1;
    private int hdIsCategoryAllow = 0;
    private int hdBrdMode = 0;
    private BigDecimal sorVariation = BigDecimal.ZERO;
    private ConversionService conversionService;
    private Map<String, Object> configParam1;
    private Map<String, Object> hideConfigParam;
    private String txtRmvFormList;
    private int clientId;
    
    	//PT:20681
    private String txtRegistrationCharges;
    private int selRegistrationChargesMode;
    private int selIsRegistrationCharges;
    private   int isPartialFillingAllowed=0;
    private   int showResultOnHomePage;
    private   int winningReportMode;
    //PT:20853
    private   int cstatus;
    private   int hdIsDateValidationAllow=1;
    //CPPP
    private   int selProduct=0;
    private   int selFormContract=0;
    private   int selTenderSector=0;
    private   String txtaPrequalification="";
    private   int selAutoResultSharing=0;
    private   int selIsRebateApplicable=0;
    private   int selIsWeightageEvaluationRequired=0;
	private int decryptorRequired=1;
	private int selDepartment = 0;
    private int subDept = 0;
    private int organization = 0;
    
    private int txtEventType = 0;

      
	public int getSelIsFormBasedConsortium() {
		return selIsFormBasedConsortium;
	}

	public void setSelIsFormBasedConsortium(int selIsFormBasedConsortium) {
		this.selIsFormBasedConsortium = selIsFormBasedConsortium;
	}

	public int getSelIsWeightageEvaluationRequired() {
		return selIsWeightageEvaluationRequired;
	}

	public void setSelIsWeightageEvaluationRequired(int selIsWeightageEvaluationRequired) {
		this.selIsWeightageEvaluationRequired = selIsWeightageEvaluationRequired;
	}

	public int getSelDepartment() {
		return selDepartment;
	}

	public int getTxtEventType() {
		return txtEventType;
	}

	public void setTxtEventType(int txtEventType) {
		this.txtEventType = txtEventType;
	}

	public void setSelDepartment(int selDepartment) {
		this.selDepartment = selDepartment;
	}

	public int getSubDept() {
		return subDept;
	}

	public void setSubDept(int subDept) {
		this.subDept = subDept;
	}

	public int getOrganization() {
		return organization;
	}

	public void setOrganization(int organization) {
		this.organization = organization;
	}

	public int getSelIsRebateApplicable() {
		return selIsRebateApplicable;
	}

	public void setSelIsRebateApplicable(int selIsRebateApplicable) {
		this.selIsRebateApplicable = selIsRebateApplicable;
	}

	public int getSelAutoResultSharing() {
		return selAutoResultSharing;
	}

	public void setSelAutoResultSharing(int selAutoResultSharing) {
		this.selAutoResultSharing = selAutoResultSharing;
	}
    public String getDomainsForspecialCharacterSkip() {
		return domainsForspecialCharacterSkip;
	}

	public void setDomainsForspecialCharacterSkip(
			String domainsForspecialCharacterSkip) {
		this.domainsForspecialCharacterSkip = domainsForspecialCharacterSkip;
	}

    public int getDecryptorRequired() {
		return decryptorRequired;
	}

	public void setDecryptorRequired(int decryptorRequired) {
		this.decryptorRequired = decryptorRequired;
	}

	public int getIsDisplayClarificationDoc() {
		return isDisplayClarificationDoc;
	}

	public void setIsDisplayClarificationDoc(int isDisplayClarificationDoc) {
		this.isDisplayClarificationDoc = isDisplayClarificationDoc;
	}

	public boolean isCorrigendum() {
		return isCorrigendum;
	}

	public void setCorrigendum(boolean isCorrigendum) {
		this.isCorrigendum = isCorrigendum;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getIsFinalPriceSheetReq() {
		return isFinalPriceSheetReq;
	}

	public void setIsFinalPriceSheetReq(int isFinalPriceSheetReq) {
		this.isFinalPriceSheetReq = isFinalPriceSheetReq;
	}

	public String getTxtRmvFormList() {
        return txtRmvFormList;
    }

    public void setTxtRmvFormList(String txtRmvFormList) {
        this.txtRmvFormList = txtRmvFormList;
    }

    public BigDecimal getSorVariation() {
        return sorVariation;
    }

    public void setSorVariation(BigDecimal sorVariation) {
        this.sorVariation = sorVariation;
    }

    public int getIsOpeningByCommittee() {
        return isOpeningByCommittee;
    }

    public void setIsOpeningByCommittee(int isOpeningByCommittee) {
        this.isOpeningByCommittee = isOpeningByCommittee;
    }

    public int getForHomePage() {
        return forHomePage;
    }

    public void setForHomePage(int forHomePage) {
        this.forHomePage = forHomePage;
    }

    public int getIsEncodedName() {
        return isEncodedName;
    }

    public void setIsEncodedName(int isEncodedName) {
        this.isEncodedName = isEncodedName;
    }

    public int getIsMandatoryDocument() {
        return isMandatoryDocument;
    }

    public void setIsMandatoryDocument(int isMandatoryDocument) {
        this.isMandatoryDocument = isMandatoryDocument;
    }

    public int getIsEncDocumentOnly() {
        return isEncDocumentOnly;
    }

    public void setIsEncDocumentOnly(int isEncDocumentOnly) {
        this.isEncDocumentOnly = isEncDocumentOnly;
    }

    public int getIsRebateForm() {
        return isRebateForm;
    }

    public void setIsRebateForm(int isRebateForm) {
        this.isRebateForm = isRebateForm;
    }

    public int getIsNegotiationAllowed() {
        return isNegotiationAllowed;
    }

    public void setIsNegotiationAllowed(int isNegotiationAllowed) {
        this.isNegotiationAllowed = isNegotiationAllowed;
    }

    public int getIsCreateAuction() {
        return isCreateAuction;
    }

    public void setIsCreateAuction(int isCreateAuction) {
        this.isCreateAuction = isCreateAuction;
    }

    public int getEncryptionLevel() {
        return encryptionLevel;
    }

    public void setEncryptionLevel(int encryptionLevel) {
        this.encryptionLevel = encryptionLevel;
    }

    public int getAutoResultSharing() {
        return autoResultSharing;
    }

    public void setAutoResultSharing(int autoResultSharing) {
        this.autoResultSharing = autoResultSharing;
    }

    
    public String getTxtOtherProcNature() {
		return txtOtherProcNature;
	}

	public void setTxtOtherProcNature(String txtOtherProcNature) {
		this.txtOtherProcNature = txtOtherProcNature;
	}

	public int getHdTenderId() {
        return hdTenderId;
    }

    public void setHdTenderId(int hdTenderId) {
        this.hdTenderId = hdTenderId;
    }

    public String getHdOpType() {
        return hdOpType;
    }

    public void setHdOpType(String hdOpType) {
        this.hdOpType = hdOpType;
    }

    public Map<String, Object> getConfigParam1() {
        return configParam1;
    }

    public void setConfigParam1(Map<String, Object> configParam1) {
        this.configParam1 = configParam1;
    }

    public Map<String, Object> getHideConfigParam() {
        return hideConfigParam;
    }

    public void setHideConfigParam(Map<String, Object> hideConfigParam) {
        this.hideConfigParam = hideConfigParam;
    }


    public ConversionService getConversionService() {
        return conversionService;
    }

    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public int getSelIsCertRequired() {
        return selIsCertRequired;
    }

    public void setSelIsCertRequired(int selIsCertRequired) {
        this.selIsCertRequired = selIsCertRequired;
    }
    private int selIsCertRequired;

    public int getHdEventTypeId() {
        return hdEventTypeId;
    }

    public void setHdEventTypeId(int hdEventTypeId) {
        this.hdEventTypeId = hdEventTypeId;
    }

    public String getTxtPreBidEndDate() {
        return txtPreBidEndDate;
    }

    public void setTxtPreBidEndDate(String txtPreBidEndDate) {
        this.txtPreBidEndDate = txtPreBidEndDate;
    }

    public int getSelEventType() {
        return selEventType;
    }

    public void setSelEventType(int selEventType) {
        this.selEventType = selEventType;
    }

    public int getSelDecimalValueUpto() {
        return selDecimalValueUpto;
    }

    public void setSelDecimalValueUpto(int selDecimalValueUpto) {
        this.selDecimalValueUpto = selDecimalValueUpto;
    }

    public int getSelIsEMDApplicable() {
        return selIsEMDApplicable;
    }

    public void setSelIsEMDApplicable(int selIsEMDApplicable) {
        this.selIsEMDApplicable = selIsEMDApplicable;
    }

    public String getTxtProjectDuration() {
        return txtProjectDuration;
    }

    public void setTxtProjectDuration(String txtProjectDuration) {
        this.txtProjectDuration = txtProjectDuration;
    }

    public String getTxtTenderNo() {
        return txtTenderNo;
    }

    public void setTxtTenderNo(String txtTenderNo) {
        this.txtTenderNo = txtTenderNo;
    }

    public int getTxtParentDepartment() {
        return txtParentDepartment;
    }

    public void setTxtParentDepartment(int txtParentDepartment) {
        this.txtParentDepartment = txtParentDepartment;
    }

    public int getSelDeptOfficial() {
        return selDeptOfficial;
    }

    public void setSelDeptOfficial(int selDeptOfficial) {
        this.selDeptOfficial = selDeptOfficial;
    }

    public String getTxtaTenderBrief() {
        return txtaTenderBrief;
    }

    public void setTxtaTenderBrief(String txtaTenderBrief) {
        this.txtaTenderBrief = txtaTenderBrief;
    }

    public String getRtfTenderDetail() {
        return rtfTenderDetail;
    }

    public void setRtfTenderDetail(String rtfTenderDetail) {
        this.rtfTenderDetail = rtfTenderDetail;
    }

    public String getTxtaKeyword() {
        return txtaKeyword;
    }

    public void setTxtaKeyword(String txtaKeyword) {
        this.txtaKeyword = txtaKeyword;
    }

    public int getSelEnvelopeType() {
        return selEnvelopeType;
    }

    public void setSelEnvelopeType(int selEnvelopeType) {
        this.selEnvelopeType = selEnvelopeType;
    }

    public String[] getSelFormType() {
        return selFormType;
    }

    public void setSelFormType(String[] selFormType) {
        this.selFormType = selFormType;
    }

    public String getTxtValidityPeriod() {
        return txtValidityPeriod;
    }

    public void setTxtValidityPeriod(String txtValidityPeriod) {
        this.txtValidityPeriod = txtValidityPeriod;
    }

    public int getSelProcurementNatureId() {
        return selProcurementNatureId;
    }

    public void setSelProcurementNatureId(int selProcurementNatureId) {
        this.selProcurementNatureId = selProcurementNatureId;
    }

    public int getSelDownloadDocument() {
        return selDownloadDocument;
    }

    public void setSelDownloadDocument(int selDownloadDocument) {
        this.selDownloadDocument = selDownloadDocument;
    }

    public String getTxtTenderValue() {
        return txtTenderValue;
    }

    public void setTxtTenderValue(String txtTenderValue) {
        this.txtTenderValue = txtTenderValue;
    }

    public int getSelIsSplitPOAllowed() {
        return selIsSplitPOAllowed;
    }

    public void setSelIsSplitPOAllowed(int selIsSplitPOAllowed) {
        this.selIsSplitPOAllowed = selIsSplitPOAllowed;
    }

    public int getSelIsItemwiseWinner() {
        return selIsItemwiseWinner;
    }

    public void setSelIsItemwiseWinner(int selIsItemwiseWinner) {
        this.selIsItemwiseWinner = selIsItemwiseWinner;
    }

    public int getSelSubmissionMode() {
        return selSubmissionMode;
    }

    public void setSelSubmissionMode(int selSubmissionMode) {
        this.selSubmissionMode = selSubmissionMode;
    }

    public int getSelTenderMode() {
        return selTenderMode;
    }

    public void setSelTenderMode(int selTenderMode) {
        this.selTenderMode = selTenderMode;
    }

    public int getSelBiddingType() {
        return selBiddingType;
    }

    public void setSelBiddingType(int selBiddingType) {
        this.selBiddingType = selBiddingType;
    }

    public int getSelCurrencyId() {
        return selCurrencyId;
    }

    public void setSelCurrencyId(int selCurrencyId) {
        this.selCurrencyId = selCurrencyId;
    }

    public int getSelIsConsortiumAllowed() {
        return selIsConsortiumAllowed;
    }

    public void setSelIsConsortiumAllowed(int selIsConsortiumAllowed) {
        this.selIsConsortiumAllowed = selIsConsortiumAllowed;
    }

    public int getSelIsBidWithdrawal() {
        return selIsBidWithdrawal;
    }

    public void setSelIsBidWithdrawal(int selIsBidWithdrawal) {
        this.selIsBidWithdrawal = selIsBidWithdrawal;
    }

    public int getSelBiddingVariant() {
        return selBiddingVariant;
    }

    public void setSelBiddingVariant(int selBiddingVariant) {
        this.selBiddingVariant = selBiddingVariant;
    }

    public int getSelIsPreBidMeeting() {
        return selIsPreBidMeeting;
    }

    public void setSelIsPreBidMeeting(int selIsPreBidMeeting) {
        this.selIsPreBidMeeting = selIsPreBidMeeting;
    }

    public int getSelPreBidMode() {
        return selPreBidMode;
    }

    public void setSelPreBidMode(int selPreBidMode) {
        this.selPreBidMode = selPreBidMode;
    }

    public String getTxtaPreBidAddress() {
        return txtaPreBidAddress;
    }

    public void setTxtaPreBidAddress(String txtaPreBidAddress) {
        this.txtaPreBidAddress = txtaPreBidAddress;
    }

    public String getTxtaDocumentSubmission() {
        return txtaDocumentSubmission;
    }

    public void setTxtaDocumentSubmission(String txtaDocumentSubmission) {
        this.txtaDocumentSubmission = txtaDocumentSubmission;
    }

    public int getSelIsWorkflowRequired() {
        return selIsWorkflowRequired;
    }

    public void setSelIsWorkflowRequired(int selIsWorkflowRequired) {
        this.selIsWorkflowRequired = selIsWorkflowRequired;
    }
    public int getSelWorkflowType() {
		return selWorkflowType;
	}

	public void setSelWorkflowType(int selWorkflowType) {
		this.selWorkflowType = selWorkflowType;
	}

	public int getSelIsQuestionAnswer() {
        return selIsQuestionAnswer;
    }

    public void setSelIsQuestionAnswer(int selIsQuestionAnswer) {
        this.selIsQuestionAnswer = selIsQuestionAnswer;
    }

    public String getTxtDocumentStartDate() {
        return txtDocumentStartDate;
    }

    public void setTxtDocumentStartDate(String txtDocumentStartDate) {
        this.txtDocumentStartDate = txtDocumentStartDate;
    }

    public String getTxtDocumentEndDate() {
        return txtDocumentEndDate;
    }

    public void setTxtDocumentEndDate(String txtDocumentEndDate) {
        this.txtDocumentEndDate = txtDocumentEndDate;
    }

    public String getTxtSubmissionStartDate() {
        return txtSubmissionStartDate;
    }

    public void setTxtSubmissionStartDate(String txtSubmissionStartDate) {
        this.txtSubmissionStartDate = txtSubmissionStartDate;
    }

    public String getTxtSubmissionEndDate() {
        return txtSubmissionEndDate;
    }

    public void setTxtSubmissionEndDate(String txtSubmissionEndDate) {
        this.txtSubmissionEndDate = txtSubmissionEndDate;
    }

    public String getTxtPreBidStartDate() {
        return txtPreBidStartDate;
    }

    public void setTxtPreBidStartDate(String txtPreBidStartDate) {
        this.txtPreBidStartDate = txtPreBidStartDate;
    }

    public String getTxtBidOpenDate() {
        return txtBidOpenDate;
    }

    public void setTxtBidOpenDate(String txtBidOpenDate) {
        this.txtBidOpenDate = txtBidOpenDate;
    }

    public String getTxtQuestionAnswerStartDate() {
        return txtQuestionAnswerStartDate;
    }

    public void setTxtQuestionAnswerStartDate(String txtQuestionAnswerStartDate) {
        this.txtQuestionAnswerStartDate = txtQuestionAnswerStartDate;
    }

    public String getTxtQuestionAnswerEndDate() {
        return txtQuestionAnswerEndDate;
    }

    public void setTxtQuestionAnswerEndDate(String txtQuestionAnswerEndDate) {
        this.txtQuestionAnswerEndDate = txtQuestionAnswerEndDate;
    }

    public int getSelIsDocfeesApplicable() {
        return selIsDocfeesApplicable;
    }

    public void setSelIsDocfeesApplicable(int selIsDocfeesApplicable) {
        this.selIsDocfeesApplicable = selIsDocfeesApplicable;
    }

    public int getSelDocFeePaymentMode() {
        return selDocFeePaymentMode;
    }

    public void setSelDocFeePaymentMode(int selDocFeePaymentMode) {
        this.selDocFeePaymentMode = selDocFeePaymentMode;
    }

    public String getTxtDocumentFee() {
        return txtDocumentFee;
    }

    public void setTxtDocumentFee(String txtDocumentFee) {
        this.txtDocumentFee = txtDocumentFee;
    }

    public String getTxtaDocFeePaymentAddress() {
        return txtaDocFeePaymentAddress;
    }

    public void setTxtaDocFeePaymentAddress(String txtaDocFeePaymentAddress) {
        this.txtaDocFeePaymentAddress = txtaDocFeePaymentAddress;
    }

    public int getSelIsSecurityfeesApplicable() {
        return selIsSecurityfeesApplicable;
    }

    public void setSelIsSecurityfeesApplicable(int selIsSecurityfeesApplicable) {
        this.selIsSecurityfeesApplicable = selIsSecurityfeesApplicable;
    }

    public int getSelSecFeePaymentMode() {
        return selSecFeePaymentMode;
    }

    public void setSelSecFeePaymentMode(int selSecFeePaymentMode) {
        this.selSecFeePaymentMode = selSecFeePaymentMode;
    }

    public String getTxtSecurityFee() {
        return txtSecurityFee;
    }

    public void setTxtSecurityFee(String txtSecurityFee) {
        this.txtSecurityFee = txtSecurityFee;
    }

    public String getTxtaSecFeePaymentAddress() {
        return txtaSecFeePaymentAddress;
    }

    public void setTxtaSecFeePaymentAddress(String txtaSecFeePaymentAddress) {
        this.txtaSecFeePaymentAddress = txtaSecFeePaymentAddress;
    }

    public int getSelEmdPaymentMode() {
        return selEmdPaymentMode;
    }

    public void setSelEmdPaymentMode(int selEmdPaymentMode) {
        this.selEmdPaymentMode = selEmdPaymentMode;
    }

    public String getTxtEmdAmount() {
        return txtEmdAmount;
    }

    public void setTxtEmdAmount(String txtEmdAmount) {
        this.txtEmdAmount = txtEmdAmount;
    }

    public String getTxtaEmdPaymentAddress() {
        return txtaEmdPaymentAddress;
    }

    public void setTxtaEmdPaymentAddress(String txtaEmdPaymentAddress) {
        this.txtaEmdPaymentAddress = txtaEmdPaymentAddress;
    }

    public boolean isIsCorrigendum() {
        return isCorrigendum;
    }

    public void setIsCorrigendum(boolean isCorrigendum) {
        this.isCorrigendum = isCorrigendum;
    }

    public int getIsPastEvent() {
        return isPastEvent;
    }

    public void setIsPastEvent(int isPastEvent) {
        this.isPastEvent = isPastEvent;
    }
    
   

	public int getHdIsCategoryAllow() {
		return hdIsCategoryAllow;
	}

	public void setHdIsCategoryAllow(int hdIsCategoryAllow) {
		this.hdIsCategoryAllow = hdIsCategoryAllow;
	}

	public int getHdBrdMode() {
		return hdBrdMode;
	}

	public void setHdBrdMode(int hdBrdMode) {
		this.hdBrdMode = hdBrdMode;
	}
	

	public String getTxtRegistrationCharges() {
		return txtRegistrationCharges;
	}

	public void setTxtRegistrationCharges(String txtRegistrationCharges) {
		this.txtRegistrationCharges = txtRegistrationCharges;
	}

	public int getSelRegistrationChargesMode() {
		return selRegistrationChargesMode;
	}

	public void setSelRegistrationChargesMode(int selRegistrationChargesMode) {
		this.selRegistrationChargesMode = selRegistrationChargesMode;
	}

	public int getSelIsRegistrationCharges() {
		return selIsRegistrationCharges;
	}

	public void setSelIsRegistrationCharges(int selIsRegistrationCharges) {
		this.selIsRegistrationCharges = selIsRegistrationCharges;
	}

	public int getIsPartialFillingAllowed() {
		return isPartialFillingAllowed;
	}

	public void setIsPartialFillingAllowed(int isPartialFillingAllowed) {
		this.isPartialFillingAllowed = isPartialFillingAllowed;
	}

	public int getShowResultOnHomePage() {
		return showResultOnHomePage;
	}

	public void setShowResultOnHomePage(int showResultOnHomePage) {
		this.showResultOnHomePage = showResultOnHomePage;
	}

	public int getWinningReportMode() {
		return winningReportMode;
	}

	public void setWinningReportMode(int winningReportMode) {
		this.winningReportMode = winningReportMode;
	}

	public int getCstatus() {
		return cstatus;
	}

	public void setCstatus(int cstatus) {
		this.cstatus = cstatus;
	}

	public int getHdIsDateValidationAllow() {
		return hdIsDateValidationAllow;
	}

	public void setHdIsDateValidationAllow(int hdIsDateValidationAllow) {
		this.hdIsDateValidationAllow = hdIsDateValidationAllow;
	}
	public int getSelProduct() {
		return selProduct;
	}

	public void setSelProduct(int selProduct) {
		this.selProduct = selProduct;
	}

	public int getSelFormContract() {
		return selFormContract;
	}

	public void setSelFormContract(int selFormContract) {
		this.selFormContract = selFormContract;
	}

	public int getSelTenderSector() {
		return selTenderSector;
	}

	public void setSelTenderSector(int selTenderSector) {
		this.selTenderSector = selTenderSector;
	}
	public String getTxtaPrequalification() {
		return txtaPrequalification;
	}

	public void setTxtaPrequalification(String txtaPrequalification) {
		this.txtaPrequalification = txtaPrequalification;
	}
/*	public void validateTxtTenderNo(BindingResult bindingResult) {
        commonValidators.isNotBlank(this.txtTenderNo, TXTTENDERNO, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTTENDERNO)) {
            commonValidators.validateLength(this.txtTenderNo, 500, TXTTENDERNO, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTTENDERNO)) {
                commonValidators.isTenderBrief(this.txtTenderNo, TXTTENDERNO, 500, bindingResult);
            }
        }
    }

    public void validateRtfTenderDetail(BindingResult bindingResult) {
        commonValidators.isNotBlank(this.rtfTenderDetail, RTFTENDERDTL, bindingResult);

    }

    public void validateTxtaTenderBrief(BindingResult bindingResult) {
        commonValidators.isNotBlank(this.txtaTenderBrief, TXTATENDERBRIEF, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTATENDERBRIEF)) {
        	commonValidators.validateLength(AbcUtility.reverseReplaceSpecialChars(this.txtaTenderBrief), 10000, TXTATENDERBRIEF, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTATENDERBRIEF)) {
                commonValidators.isTenderBrief(this.txtaTenderBrief, TXTATENDERBRIEF, 10000, bindingResult);
            }
        }
    }

    public void validateTxtaDocumentSubmission(BindingResult bindingResult) {
        commonValidators.isNotBlank(this.txtaDocumentSubmission, TXTADOCUMENTSUBMISSION, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTADOCUMENTSUBMISSION)) {
            commonValidators.validateLength(this.txtaDocumentSubmission, 1000, TXTADOCUMENTSUBMISSION, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTADOCUMENTSUBMISSION)) {
                commonValidators.isTenderBrief(this.txtaDocumentSubmission, TXTADOCUMENTSUBMISSION, 1000, bindingResult);
            }
        }
    }

    public void validateTxtaPreBidAddress(BindingResult bindingResult) {
        commonValidators.isNotBlank(this.txtaPreBidAddress, TXTAPREBIDADDRESS, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTAPREBIDADDRESS)) {
            commonValidators.validateLength(this.txtaPreBidAddress, 1000, TXTAPREBIDADDRESS, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTAPREBIDADDRESS)) {
                commonValidators.isTenderBrief(this.txtaPreBidAddress, TXTAPREBIDADDRESS, 1000, bindingResult);
            }
        }
    }

    public void validateTxtDocDownloadingStartDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTADOCSTARTDATE)) {
            int compVal = 0;
            commonValidators.isNotBlank(txtDocumentStartDate, TXTADOCSTARTDATE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTADOCSTARTDATE)) {
                if (configParam1.containsKey(ISPASTEVENT) && Integer.parseInt(configParam1.get(ISPASTEVENT).toString()) == 0) {
                    compVal = commonValidators.compareWithSystemDate(conversionService.convert(txtDocumentStartDate, Date.class));
                    if (compVal == 0 || compVal > 0) {
                        bindingResult.rejectValue(TXTADOCSTARTDATE, "msg_doc_download_startdate_grater_sysdate");
                        if (!bindingResult.hasFieldErrors(TXTADOCSTARTDATE)) {
                            compVal = commonValidators.compareTwoDate(conversionService.convert(this.txtSubmissionEndDate, Date.class), conversionService.convert(txtDocumentStartDate, Date.class));                            
                            if (compVal < 0 || compVal == 0) {
                                bindingResult.rejectValue(TXTADOCSTARTDATE, "msg_doc_download_startdate_lessthan_submissionenddate");
                            }
                        }
                    }
                } else {
                    if (!bindingResult.hasFieldErrors(TXTADOCSTARTDATE)) {
                        compVal = commonValidators.compareTwoDate(conversionService.convert(this.txtSubmissionEndDate, Date.class), conversionService.convert(txtDocumentStartDate, Date.class));
                        if (compVal < 0 || compVal == 0) {
                            bindingResult.rejectValue(TXTADOCSTARTDATE, "msg_doc_download_startdate_lessthan_submissionenddate");
                        }
                    }
                }
            }
        }
    }

    public void validateTxtDocDownloadingEndDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTADOCENDDATE)) {
            int compVal = 0;
            commonValidators.isNotBlank(txtDocumentEndDate, TXTADOCENDDATE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTADOCENDDATE)) {
                if (txtDocumentStartDate != null) {
                    compVal = commonValidators.compareTwoDate( conversionService.convert(txtDocumentEndDate, Date.class),conversionService.convert(this.txtDocumentStartDate, Date.class));
                    if (compVal < 0 || compVal == 0) {
                        bindingResult.rejectValue(TXTADOCENDDATE, "msg_doc_download_enddate_grater_startdate");
                        if (!bindingResult.hasFieldErrors(TXTADOCENDDATE)) {
                            compVal = commonValidators.compareTwoDate(conversionService.convert(this.txtSubmissionEndDate, Date.class), conversionService.convert(txtDocumentEndDate, Date.class));
                            if (compVal < 0) {
                                bindingResult.rejectValue(TXTADOCENDDATE, "msg_doc_download_enddate_le_submissionenddate");
                            }
                        }
                    }
                } else {
                    compVal = commonValidators.compareTwoDate(conversionService.convert(this.txtSubmissionEndDate, Date.class), conversionService.convert(txtDocumentEndDate, Date.class));
                    if (compVal < 0) {
                        bindingResult.rejectValue(TXTADOCENDDATE, "msg_doc_download_enddate_le_submissionenddate");
                    }
                }
            }
        }
    }

    public void validateTxtPreBidStartDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTPREBIDSTARTDATE)) {
            int compVal = 0;
            commonValidators.isNotBlank(txtPreBidStartDate, TXTPREBIDSTARTDATE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTPREBIDSTARTDATE)) {
                if (configParam1.containsKey(ISPASTEVENT) && Integer.parseInt(configParam1.get(ISPASTEVENT).toString()) == 0) {
                    compVal = commonValidators.compareWithSystemDate(conversionService.convert(txtPreBidStartDate, Date.class));
                    if (compVal > 0) {
                        bindingResult.rejectValue(TXTPREBIDSTARTDATE, "msg_prebid_meeting_startdate_gt_sysdate");
                        if (this.txtSubmissionEndDate != null && !"".equals(this.txtSubmissionEndDate) && !bindingResult.hasFieldErrors(TXTPREBIDSTARTDATE)) {
                            compVal = commonValidators.compareTwoDate(conversionService.convert(txtSubmissionEndDate, Date.class), conversionService.convert(this.txtPreBidStartDate, Date.class));
                            if (compVal < 0 || compVal == 0) {
                                bindingResult.rejectValue(TXTPREBIDSTARTDATE, "msg_prebidmeeting_satrtdate_lt_bidsubmission_enddate");
                            }
                        }
                    }
                } else {
                    if (this.txtSubmissionEndDate != null && !"".equals(this.txtSubmissionEndDate) && !bindingResult.hasFieldErrors(TXTPREBIDSTARTDATE)) {
                        compVal = commonValidators.compareTwoDate(conversionService.convert(txtSubmissionEndDate, Date.class), conversionService.convert(this.txtPreBidStartDate, Date.class));
                        if (compVal < 0 || compVal == 0) {
                            bindingResult.rejectValue(TXTPREBIDSTARTDATE, "msg_prebidmeeting_satrtdate_lt_bidsubmission_enddate");
                        }
                    }
                }
            }
        }
    }

    public void validateTxtPreBidEndDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTPREBIDENDDATE)) {
            commonValidators.isNotBlank(txtPreBidEndDate, TXTPREBIDENDDATE, bindingResult);
            if (this.txtPreBidStartDate != null && !"".equals(this.txtPreBidStartDate) && !bindingResult.hasFieldErrors(TXTPREBIDENDDATE)) {
                int compVal = commonValidators.compareTwoDate(conversionService.convert(txtPreBidEndDate, Date.class), conversionService.convert(this.txtPreBidStartDate, Date.class));
                if (compVal < 0 || compVal == 0) {
                    bindingResult.rejectValue(TXTPREBIDENDDATE, "msg_prebid_meeting_date_gt_prebid_meeting_startdate");
                    if (this.txtSubmissionEndDate != null && !"".equals(this.txtSubmissionEndDate) && !bindingResult.hasFieldErrors(TXTPREBIDENDDATE)) {
                        compVal = commonValidators.compareTwoDate(conversionService.convert(txtSubmissionEndDate, Date.class), conversionService.convert(this.txtPreBidEndDate, Date.class));
                        if (compVal < 0 || compVal == 0) {
                            bindingResult.rejectValue(TXTPREBIDENDDATE, "msg_prebid_meeting_enddate_lt_bidsubmission_enddate");
                        }
                    }
                }
            }
        }
    }

    public void validateTxtSubmissionStartDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTSUBMISSIONSTARTDATE)) {
            commonValidators.isNotBlank(txtSubmissionStartDate, TXTSUBMISSIONSTARTDATE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTSUBMISSIONSTARTDATE)) {

                if (configParam1.containsKey(ISPASTEVENT) && Integer.parseInt(configParam1.get(ISPASTEVENT).toString()) == 0 && txtDocumentStartDate != null && !txtDocumentStartDate.equals("")) {
                    int compVal = commonValidators.compareWithSystemDate(conversionService.convert(txtDocumentStartDate, Date.class));
                    if (compVal > 0) {
                        bindingResult.rejectValue(TXTSUBMISSIONSTARTDATE, "msg_submission_startdate_lt_sysdate");
                    }
                }
            }
        }
    }

    public void validateTxtSubmissionEndDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTSUBMISSIONENDDATE)) {
            int compVal = 0;
            commonValidators.isNotBlank(txtSubmissionEndDate, TXTSUBMISSIONENDDATE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTSUBMISSIONENDDATE)) {
                if (this.txtSubmissionStartDate != null && !"".equals(this.txtSubmissionStartDate)) {
                    compVal = commonValidators.compareTwoDate(conversionService.convert(txtSubmissionEndDate, Date.class), conversionService.convert(this.txtSubmissionStartDate, Date.class));
                    if (compVal < 0 || compVal == 0) {
                        bindingResult.rejectValue(TXTSUBMISSIONENDDATE, "msg_submission_enddate_gt_startdate");
                        if (txtDocumentEndDate != null && !"".equals(txtDocumentEndDate) && !bindingResult.hasFieldErrors(TXTSUBMISSIONENDDATE)) {
                            compVal = commonValidators.compareTwoDate(conversionService.convert(this.txtSubmissionEndDate, Date.class), conversionService.convert(txtDocumentEndDate, Date.class));
                            if (compVal < 0) {
                                bindingResult.rejectValue(TXTSUBMISSIONENDDATE, "msg_submission_enddate_gt_docdownload_enddate");
                            }
                        }
                    }
                } else {
                    if (!bindingResult.hasFieldErrors(TXTSUBMISSIONENDDATE)) {
                        if (txtDocumentEndDate != null && !"".equals(txtDocumentEndDate) && !bindingResult.hasFieldErrors(TXTSUBMISSIONENDDATE)) {
                            compVal = commonValidators.compareTwoDate(conversionService.convert(this.txtSubmissionEndDate, Date.class), conversionService.convert(txtDocumentEndDate, Date.class));
                            if (compVal < 0) {
                                bindingResult.rejectValue(TXTSUBMISSIONENDDATE, "msg_submission_enddate_gt_docdownload_enddate");
                            }
                        }
                    }
                }
            }
        }
    }

    public void validateTxtQueAnsStartDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTQUEANSSTARTDATE)) {
            int compVal = 0;
            commonValidators.isNotBlank(txtQuestionAnswerStartDate, TXTQUEANSSTARTDATE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTQUEANSSTARTDATE)) {
                if (configParam1.containsKey(ISPASTEVENT) && Integer.parseInt(configParam1.get(ISPASTEVENT).toString()) == 0) {
                    compVal = commonValidators.compareWithSystemDate(conversionService.convert(this.txtQuestionAnswerStartDate, Date.class));
                    if (compVal > 0) {
                        bindingResult.rejectValue(TXTQUEANSSTARTDATE, "msg_queans_startdate_gt_currdate");
                        if (txtSubmissionEndDate != null && !"".equals(txtSubmissionEndDate) && !bindingResult.hasFieldErrors(TXTQUEANSSTARTDATE)) {
                            compVal = commonValidators.compareTwoDate(conversionService.convert(txtSubmissionEndDate, Date.class), conversionService.convert(this.txtQuestionAnswerStartDate, Date.class));
                            if (compVal < 0 || compVal == 0) {
                                bindingResult.rejectValue(TXTQUEANSSTARTDATE, "msg_queans_startdate_lt_bodsubmissionenddate");
                            }
                        }
                    }
                } else {
                    if (txtSubmissionEndDate != null && !"".equals(txtSubmissionEndDate) && !bindingResult.hasFieldErrors(TXTQUEANSSTARTDATE)) {
                        compVal = commonValidators.compareTwoDate(conversionService.convert(txtSubmissionEndDate, Date.class), conversionService.convert(this.txtQuestionAnswerStartDate, Date.class));
                        if (compVal < 0 || compVal == 0) {
                            bindingResult.rejectValue(TXTQUEANSSTARTDATE, "msg_queans_startdate_lt_bodsubmissionenddate");
                        }
                    }
                }
            }
        }
    }

    public void validateTxtQueAnsEndDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTQUEANSENDDATE)) {
            commonValidators.isNotBlank(txtQuestionAnswerEndDate, TXTQUEANSENDDATE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTQUEANSENDDATE)) {
                int compVal = commonValidators.compareTwoDate( conversionService.convert(txtQuestionAnswerEndDate, Date.class),conversionService.convert(this.txtQuestionAnswerStartDate, Date.class));
                if (compVal < 0 || compVal == 0) {
                    bindingResult.rejectValue(TXTQUEANSENDDATE, "msg_queans_enddate_gt_queans_startdate");
                    if (txtSubmissionEndDate != null && !"".equals(txtSubmissionEndDate) && !bindingResult.hasFieldErrors(TXTQUEANSENDDATE)) {
                        compVal = commonValidators.compareTwoDate(conversionService.convert(txtSubmissionEndDate, Date.class),conversionService.convert(this.txtQuestionAnswerEndDate, Date.class));

                       if (compVal < 0 || compVal == 0) {
                            bindingResult.rejectValue(TXTQUEANSENDDATE, "msg_queans_enddate_lt_submissionenddate");
                        }
                    }
                }
            }
        }
    }

    public void validateTxtBidOpenDate(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTBIDOPENDATE)) {
            commonValidators.isNotBlank(txtBidOpenDate, TXTBIDOPENDATE, bindingResult);
            if (txtSubmissionEndDate != null && !"".equals(txtSubmissionEndDate) && !bindingResult.hasFieldErrors(TXTBIDOPENDATE)) {
                int compVal = commonValidators.compareTwoDate(conversionService.convert(txtBidOpenDate, Date.class),conversionService.convert(this.txtSubmissionEndDate, Date.class));
                if (compVal <= 0) {
                    bindingResult.rejectValue(TXTBIDOPENDATE, "bidopendate_ge_bidsubmissiondate");
                }
            }
        }
    }

    public void validateTxtValidityPeriod(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTVALIDITYPRD)) {
            commonValidators.isNotBlank(txtValidityPeriod, TXTVALIDITYPRD, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTVALIDITYPRD)) {
                if (!commonValidators.validateLength(this.txtValidityPeriod, 5) || !commonValidators.isDigits(txtValidityPeriod)) {
                    Integer[] obj = new Integer[1];
                    obj[0] = 5;
                    bindingResult.rejectValue(TXTVALIDITYPRD, "allow_max_positive_number", obj, null);
                }
            }
        }
    }

    public void validateTxtProjectDuration(BindingResult bindingResult) throws Exception {
        if (!bindingResult.hasFieldErrors(TXTPROJECTDURATION)) {
            commonValidators.isNotBlank(txtProjectDuration, TXTPROJECTDURATION, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTPROJECTDURATION)) {
            	commonValidators.validateLength(AbcUtility.reverseReplaceSpecialChars(this.txtProjectDuration), 50,TXTPROJECTDURATION,bindingResult);
                if (!commonValidators.validateLength(this.txtProjectDuration, 50)) {
                    bindingResult.rejectValue(TXTPROJECTDURATION, "allow_max_fifty_alphanumeric_char");
                }
            }
        }
    }

    public void validateTxtDocuementFees(BindingResult bindingResult) throws Exception {
        String docFees = "";
        if (!bindingResult.hasFieldErrors(TXTDOCUMENTFEE)) {
            commonValidators.isNotBlank(txtDocumentFee, TXTDOCUMENTFEE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTDOCUMENTFEE)) {
                if (txtDocumentFee.contains(".")) {
                    docFees = txtDocumentFee.substring(0, txtDocumentFee.indexOf('.'));
                } else {
                    docFees = this.txtDocumentFee;
                }
                if (!bindingResult.hasFieldErrors(TXTDOCUMENTFEE)) {
                    commonValidators.isNumeric(this.txtDocumentFee, TXTDOCUMENTFEE, bindingResult);
                    if (!bindingResult.hasFieldErrors(TXTDOCUMENTFEE)) {
                        commonValidators.validateLengthDecimal(docFees, 10, TXTDOCUMENTFEE, bindingResult);
                        if (!bindingResult.hasFieldErrors(TXTDOCUMENTFEE)) {
                            commonValidators.isUptoDecimal(this.txtDocumentFee, 2, TXTDOCUMENTFEE, bindingResult);  //Related Bug Id#26376 and Changes Bug id#30211
                        }
                    }
                }
            }
        }
    }

    public void validateTxtSecurityFees(BindingResult bindingResult) throws Exception {
        String securityFees = "";
        if (!bindingResult.hasFieldErrors(TXTSECFEES)) {
            commonValidators.isNotBlank(txtSecurityFee, TXTSECFEES, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTSECFEES)) {
                if (txtSecurityFee.contains(".")) {
                    securityFees = txtSecurityFee.substring(0, txtSecurityFee.indexOf("."));
                } else {
                    securityFees = this.txtSecurityFee;
                }
                if (!bindingResult.hasFieldErrors(TXTSECFEES)) {
                    commonValidators.isNumeric(this.txtSecurityFee, TXTSECFEES, bindingResult);
                    if (!bindingResult.hasFieldErrors(TXTSECFEES)) {
                        commonValidators.validateLengthDecimal(securityFees, 10, TXTSECFEES, bindingResult);
                        if (!bindingResult.hasFieldErrors(TXTSECFEES)) {
                            commonValidators.isUptoDecimal(this.txtSecurityFee, 2, TXTSECFEES, bindingResult); //Related Bug Id#26376 and Changes Bug id#30211
                        }
                    }
                }
            }
        }
    }

    public void validateTxtEMDFees(BindingResult bindingResult) throws Exception {
        String emdFees = "";
        if (!bindingResult.hasFieldErrors(TXTEMDAMT)) {
            commonValidators.isNotBlank(txtEmdAmount, TXTEMDAMT, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTEMDAMT)) {
                if (txtEmdAmount.contains(".")) {
                    emdFees = txtEmdAmount.substring(0, txtEmdAmount.indexOf('.'));
                } else {
                    emdFees = this.txtEmdAmount;
                }
                if (!bindingResult.hasFieldErrors(TXTEMDAMT)) {
                    commonValidators.isNumeric(this.txtEmdAmount, TXTSECFEES, bindingResult);
                    if (!bindingResult.hasFieldErrors(TXTEMDAMT)) {
                        commonValidators.validateLengthDecimal(emdFees, 10, TXTEMDAMT, bindingResult);
                        if (!bindingResult.hasFieldErrors(TXTEMDAMT)) {
                            commonValidators.isUptoDecimal(this.txtEmdAmount, 2, TXTEMDAMT, bindingResult); //Related Bug Id#26376 and Changes Bug id#30211
                        }
                    }
                }
            }
        }
    }

    public void validateTxtRegistrationFees(BindingResult bindingResult) throws Exception {
        String regFees = "";
        if (!bindingResult.hasFieldErrors(TXTREGISTRATIONFEE)) {
            commonValidators.isNotBlank(txtRegistrationCharges, TXTREGISTRATIONFEE, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTREGISTRATIONFEE)) {
                if (txtRegistrationCharges.contains(".")) {
                	regFees = txtRegistrationCharges.substring(0, txtRegistrationCharges.indexOf('.'));
                } else {
                	regFees = this.txtRegistrationCharges;
                }
                if (!bindingResult.hasFieldErrors(TXTREGISTRATIONFEE)) {
                    commonValidators.isNumeric(this.txtRegistrationCharges, TXTREGISTRATIONFEE, bindingResult);
                    if (!bindingResult.hasFieldErrors(TXTREGISTRATIONFEE)) {
                        commonValidators.validateLengthDecimal(regFees, 10, TXTREGISTRATIONFEE, bindingResult);
                        if (!bindingResult.hasFieldErrors(TXTREGISTRATIONFEE)) {
                            commonValidators.isUptoDecimal(this.txtRegistrationCharges, 2, TXTREGISTRATIONFEE, bindingResult);
                        }
                    }
                }
            }
        }
    }
    
    public void validateTxtTenderValue(BindingResult bindingResult) throws Exception {
        String tenderValue = "";
        if (!bindingResult.hasFieldErrors(TXTTENDERVAL)) {
            commonValidators.isNotBlank(txtTenderValue, TXTTENDERVAL, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTTENDERVAL)) {
                if (txtTenderValue.contains(".")) {
                    tenderValue = txtTenderValue.substring(0, txtTenderValue.indexOf('.'));
                } else {
                    tenderValue = this.txtTenderValue;
                }
                if (!bindingResult.hasFieldErrors(TXTTENDERVAL)) {
                    commonValidators.isNumeric(this.txtTenderValue, TXTTENDERVAL, bindingResult);
                    if (!bindingResult.hasFieldErrors(TXTTENDERVAL)) {
                        commonValidators.validateLengthDecimal(tenderValue, 10, TXTTENDERVAL, bindingResult);
                        if (!bindingResult.hasFieldErrors(TXTTENDERVAL)) {
                            commonValidators.isUptoDecimal(this.txtTenderValue, this.selDecimalValueUpto, TXTTENDERVAL, bindingResult);
                        }
                    }
                }
            }
        }
    }

    public void validateTxtaEmdPaymentAt(BindingResult bindingResult) throws Exception {
        commonValidators.isNotBlank(this.txtaEmdPaymentAddress, TXTAEMDPAYMENTAT, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTAEMDPAYMENTAT)) {
            commonValidators.validateLength(this.txtaEmdPaymentAddress, 1000, TXTAEMDPAYMENTAT, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTAEMDPAYMENTAT)) {
                commonValidators.isTenderBrief(this.txtaEmdPaymentAddress, TXTAEMDPAYMENTAT, 1000, bindingResult);
            }
        }
    }

    public void validateTxtaSecFeesPaymentAt(BindingResult bindingResult) throws Exception {
        commonValidators.isNotBlank(this.txtaSecFeePaymentAddress, TXTASECFEESPAYMENTAT, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTASECFEESPAYMENTAT)) {
            commonValidators.validateLength(this.txtaSecFeePaymentAddress, 1000, TXTASECFEESPAYMENTAT, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTASECFEESPAYMENTAT)) {
                commonValidators.isTenderBrief(this.txtaSecFeePaymentAddress, TXTASECFEESPAYMENTAT, 1000, bindingResult);
            }
        }
    }

    public void validateTxtaDocFeesPaymentAt(BindingResult bindingResult) throws Exception {
        commonValidators.isNotBlank(this.txtaDocFeePaymentAddress, TXTADOCFEESPAYMENTAT, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTADOCFEESPAYMENTAT)) {
            commonValidators.validateLength(this.txtaDocFeePaymentAddress, 1000, TXTADOCFEESPAYMENTAT, bindingResult);
            if (!bindingResult.hasFieldErrors(TXTADOCFEESPAYMENTAT)) {
                commonValidators.isTenderBrief(this.txtaDocFeePaymentAddress, TXTADOCFEESPAYMENTAT, 1000, bindingResult);
            }
        }
    }

    public void validateTxtaKeyword(BindingResult bindingResult) throws Exception {
        commonValidators.isNotBlank(this.txtaKeyword, TXTAKEYWORD, bindingResult);
        if (!bindingResult.hasFieldErrors(TXTAKEYWORD)) {
            commonValidators.isCommonKeyword(this.txtaKeyword, TXTAKEYWORD, 1000, bindingResult);
        }
    }
*/
    /*public void validateBean(BindingResult bindingResult) throws Exception {
        if (!isCorrigendum) {
            validateTxtTenderNo(bindingResult);
        }
        if (!isCorrigendum) {
            validateRtfTenderDetail(bindingResult);
        }
        if (!isCorrigendum) {
            validateTxtaTenderBrief(bindingResult);
        }
        
        if(hdIsCategoryAllow == 0 || (hdIsCategoryAllow == 1 && hdBrdMode == 1)){ //CR: 17618
        	validateTxtaKeyword(bindingResult);
        }
        
        if (configParam1.containsKey("validityPeriod")) {
            validateTxtValidityPeriod(bindingResult);
        }
        if (configParam1.containsKey("projectDuration")) {
            validateTxtProjectDuration(bindingResult);
        }
        if (configParam1.containsKey("tenderValue")) {
            validateTxtTenderValue(bindingResult);
        }
        if (configParam1.containsKey("documentSubmission")) {
            if (this.selSubmissionMode == 2) {
                validateTxtaDocumentSubmission(bindingResult);
            }
        }
        if (this.selIsEMDApplicable == 1) {
            if (this.selEmdPaymentMode == 2) {
                validateTxtaEmdPaymentAt(bindingResult);
            }
            validateTxtEMDFees(bindingResult);
        }
        if (this.selIsSecurityfeesApplicable == 1) {
            if (this.selSecFeePaymentMode == 2) {
                validateTxtaSecFeesPaymentAt(bindingResult);
            }
            validateTxtSecurityFees(bindingResult);
        }
        if (this.selIsDocfeesApplicable == 1) {
            if (this.selDocFeePaymentMode == 2) {
                validateTxtaDocFeesPaymentAt(bindingResult);
            }
            validateTxtDocuementFees(bindingResult);
        }
        if (this.selIsRegistrationCharges == 1) {
        	validateTxtRegistrationFees(bindingResult);
        }
        if (this.selIsPreBidMeeting == 1) {
        	if(hdIsDateValidationAllow == 1){
	            if (!isCorrigendum) {
	                validateTxtPreBidStartDate(bindingResult);
	                validateTxtPreBidEndDate(bindingResult);
	            }
        	}
            if (this.selPreBidMode == 2) {
            	// If preBidAddress is shown from default configuration then validate it else don't validate.For Bug #31826 By Jitendra
            	if (configParam1.containsKey("preBidAddress")) {
            		validateTxtaPreBidAddress(bindingResult);
            	}
            }
        }
        if(hdIsDateValidationAllow == 1){
	        if (configParam1.containsKey("submissionStartDate")) {
	            if (!isCorrigendum) {
	                validateTxtSubmissionStartDate(bindingResult);
	            }
	        }
	        if (!isCorrigendum) {
	            validateTxtSubmissionEndDate(bindingResult);
	            validateTxtBidOpenDate(bindingResult);
	        }
	        if (configParam1.containsKey("documentStartDate")) {
	            if (!isCorrigendum) {
	                validateTxtDocDownloadingStartDate(bindingResult);
	            }
	        }
	        if (configParam1.containsKey("documentEndDate")) {
	            if (!isCorrigendum) {
	                validateTxtDocDownloadingEndDate(bindingResult);
	            }
	        }
	        if (this.selIsQuestionAnswer == 1) {
	            if (!isCorrigendum) {
	                validateTxtQueAnsStartDate(bindingResult);
	                validateTxtQueAnsEndDate(bindingResult);
	            }
	        }
        }
    }*/
}
