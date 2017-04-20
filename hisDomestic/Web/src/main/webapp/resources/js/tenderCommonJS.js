var priceEnvelopeConflictMsg='Price Bid envelope and Techno Commercial envelope cannot be selected together, please select any one of them';
var techEnvelopeConflictMsg = 'Technical Envelope and Techno-Commercial envelope cannot be selected together, please select any one of them';
var multiStageConflicMsg='For multistage evaluation multiple envelope selection is mandatory.';
var envelopeRemmoveConflicMsg="On removing envelop, bidding form(s) and committee member(s) mapped in selected envelop will be removed. Are you sure you want to proceed further?";

var setGlobalCurrencySelect = function(ob){
    var aucBaseCur=$(ob).val();
    var inputs = $('input:checkbox[id^="chkCurrency_"]'); 
    for(var i=0;i<=inputs.length;i++){ 
        var chkval=  $("#chkCurrency_"+i).val();
                  
        if(aucBaseCur==chkval){
            $("#chkCurrency_"+i).prop("checked", true);            
            
        }else{
            $("#chkCurrency_"+i).prop("checked", false);
        }
    }   
}
var changeBiddingType = function(ob){
    if($(ob).val() == '1'){
        $("#trBidCurrency").hide();   
    }else{
        $("#trBidCurrency").show();
        var baseCur=$("#selCurrencyId").val();
        var inputs = $('input:checkbox[id^="chkCurrency_"]'); 
        for(var i=0;i<=inputs.length;i++){ 
            var chkval=  $("#chkCurrency_"+i).val(); 
            if(baseCur==chkval){
                $("#chkCurrency_"+i).attr("checked", true);
                
            }
        }
    }
}

var modeOfPrebidMeeting = function(ob){
    if($(ob).val()==1){
        $("#trPreBidMeetingAddress").show();
        $("#txtaPreBidAddress").attr("tovalid", 'true');
        $("#trPreBidMeetingDate").show(); 
        $('#txtPreBidStartDate').attr('dtrequired','true');
        $('#txtPreBidStartDate').attr('datevalidate','lt:txtSubmissionEndDate');
        $('#txtPreBidEndDate').attr('dtrequired','true');
        $('#txtPreBidEndDate').attr('datevalidate','gt:txtPreBidStartDate,lt:txtSubmissionEndDate');
    }else{
        $("#trPreBidMeetingAddress").hide();
        $("#trPreBidMeetingDate").hide();
        $('#txtPreBidStartDate').removeAttr('dtrequired');
        $('#txtPreBidStartDate').removeAttr('datevalidate');
        $('#txtPreBidEndDate').removeAttr('dtrequired');
        $('#txtPreBidEndDate').removeAttr('datevalidate');
        $("#txtaPreBidAddress").attr("tovalid", 'false');
    }
    if(cstatus == 0){
    	changeDtValidationWhenReq();
    }
}
var changeEmdDetail = function(ob){
    if($(ob).val()==1){
        $("#trEmdAllowed").show();
        $("#txtaEmdPaymentAddress").attr("tovalid", 'true');
        $("#txtEmdAmount").attr("tovalid", 'true');
    }else{
        $("#trEmdAllowed").hide();
        $("#txtaEmdPaymentAddress").attr("tovalid", 'false');
        $("#txtEmdAmount").attr("tovalid", 'false');
        $("#txtaEmdPaymentAddress").val("");
        $("#txtEmdAmount").val("");
    }
}
var changeDocFeeDetail = function(cThis){
    if($(cThis).val()==1 ){
        $("#txtDocumentFee").attr("tovalid",'true');
        $("#txtaDocFeePaymentAddress").attr("tovalid", 'true');
        $("#trDocAmtAndAdd").show();
        $("#docAddress2").show();
        $("#txtaDocFeePaymentAddress").attr("tovalid", 'true');
    }else{
        $("#trDocAmtAndAdd").hide();
        $("#docAddress2").hide();
        $("#txtDocumentFee").attr("tovalid",'false');
        $("#txtaDocFeePaymentAddress").attr("tovalid",'false');
    }
}
var keepSelectedCurrency = function(chk){
    if($(chk).val() == $('#selCurrencyId').val() && !$(chk).is(":checked")){
        return false;
    }else{
        return true;
    }
}
var validateData = function(){  
   var vbool = valOnSubmit();
	if($("#txtTenderNo").val()){
		$('#txtTenderNo').val($("#txtTenderNo").val());
	}
	if($("#txtProjectDuration").val()){
		$('#txtProjectDuration').val($("#txtProjectDuration").val());
	}
    if(vbool){
    	if($("#selFormType").val()){      
                var str=$("#selFormType").val();    
                var data="";
                $.each( str, function( index, value ){
                    data += value+",";
                });
                
                if($("#selEnvelopeType").val()==2){
                	var multiStageVal = data.split(",");
                    if(multiStageVal.length==1 || multiStageVal.length == 2){
                    	$("#errFormTypeValidation").text(multiStageConflicMsg);
                    	return false;
                    }	
                }
                
                var test=data.search("4,5");
                $("#errFormTypeValidation").text("");   
                if(test!=-1){
                    $("#errFormTypeValidation").text(priceEnvelopeConflictMsg);
                    vbool=false;
                }else if(data.search("3,5") != -1){
                	$("#errFormTypeValidation").text(techEnvelopeConflictMsg);
                	vbool=false;
                }else{
                    $("#errFormTypeValidation").text("");
                }
        }
    }
  
    return vbool;
}
var validateTenderSubmit = function(){
	try{
    var vbool=true;
    vbool=validateData();
    if(vbool){
    	var txtEventType = $('select#txtEventType option:selected').val();
    	$("#hdEventTypeId").val(txtEventType);
        if($("#selBiddingType").val()==2){
            var currList="";
            $("input[id*='chkCurrency_']:checked").each(function() {
            	if(!$(this).is(':disabled')) {	
            		var cur = $(this).val();
                    if(currList==""){
                        currList=cur;
                    }else{
                        currList=currList+","+cur;
                    }
            	}
            });               
            $('#txtCommaSepCur').val(currList);
        }
        if(opType=='edit'){
            var formType=$('#selFormType').val();
            var oldRmvForm="";
            $.each( onLoadFormType, function( index, value ){
                if($.inArray(value, formType) == -1){   
                    if(oldRmvForm==""){
                        oldRmvForm=value;
                    }
                    else{
                        oldRmvForm=oldRmvForm+","+value;
                    }
                }
            });
            if(oldRmvForm != ""){
                if(confirm(envelopeRemmoveConflicMsg)){
                $('#txtRmvFormList').val(oldRmvForm);
                    vbool=true;
                }else{
                    vbool=false;
                }
            }
            var cnt = 0;
            $("textarea[tovalid='true']").each(function(){
                if(!$(this).is(':disabled')){
                    if($(this).attr('id').indexOf('rtf') != -1){
                    	var value = $('iframe').contents().find('.wysihtml5-editor').html();
                        $(this).val(value);
                    }
                    if(!validateTextComponent(this)){
                        cnt=cnt+1;
                        if(cnt==1){
                            $(this).focus();
                        }
                        vbool = false;
                    }           
                }
            });
        }
    }
    var keywords = "";
    if(vbool){
	    keyword = $("#selKeywords").select2("data");
		if(keyword.length <= 0){
			var div = $('<div class="errselKeywords validationMsg clearfix">Please select keyword</div>')
			$("#keywordTd").append(div);
			$("#selKeywords").focus();
			vbool=false;
		}else{
			$(".errselKeywords").remove();
		}
	}
    if(vbool){
    	$.each(keyword,function(i,item){ 
    		keywords+=item.id+"###"+item.text+"#@#"; 
    	});
    	$("#categoryText").val(keywords);
        
    	$("[disabled]").removeAttr("disabled");
    	$("[readonly]").removeAttr("readonly");
        vbool= disableBtn(vbool);
    }  
    return vbool;
	}catch(e){
		console.log(e)
		return false;
	}
}
var checkForOtherOption = function(cThis){
    if($(cThis).val()==5){
        $("#trOtherProcNature").show();
        $("#txtOtherProcNature").attr('tovalid','true');
        $("#txtOtherProcNature").focus();
    }else{
        $("#trOtherProcNature").hide();
        $("#txtOtherProcNature").attr('tovalid','false');
    }
}
var  changeEnvelopeValue = function(cThis){
	if($(cThis).val() == 2){
		$("#selFormType option[value='5']").remove();
	}else{
		if($("#selFormType  option[value='5']").size() == 0){
			$("#selFormType").append($('<option>', {text : 'TechnoCommercial(Technical & PriceBid)',value: '5'}));
		}
	}
	$("#errFormTypeValidation").text("");
}
var  changeInEnvelopeSelection = function(cThis){
    var str=$(cThis).val();
    var data="";
    $.each( str, function( index, value ){
        data += value+",";
    });
    if($("#selEnvelopeType").val()==2){
    	var multiStageVal = data.split(",");
        if(multiStageVal.length==1 || multiStageVal.length == 2){
        	$("#errFormTypeValidation").text(multiStageConflicMsg);
        	return false;
        }
    }
    changeRebate(cThis);
    showWeightEvaluation($("#selIsItemwiseWinner"))
    var test=data.search("4,5");
    $("#errFormTypeValidation").text("");
    if(test!=-1){
        $("#errFormTypeValidation").text(priceEnvelopeConflictMsg);
    }else if(data.search("3,5") != -1){
    	$("#errFormTypeValidation").text(techEnvelopeConflictMsg);
    }else{
    	$("#errFormTypeValidation").text("");
    } 
}
var getSecurityFeesDetail = function(cThis){
    if($(cThis).val()==1){
        $("#trSecFeeAllowed").show();
        $("#txtaSecFeePaymentAddress").attr('tovalid','true');
        $("#txtSecurityFee").attr('tovalid','true');
    }else{
        $("#trSecFeeAllowed").hide();
        $("#txtaSecFeePaymentAddress").attr('tovalid','false');
        $("#txtSecurityFee").attr('tovalid','false');
        $("#txtaSecFeePaymentAddress").val("");
        $("#txtSecurityFee").val("");
    }
}
var doProcessOnLoad = function(){
        $('#txtDocumentStartDate').attr('datevalidate','lt:txtSubmissionEndDate,lt:txtDocumentEndDate');
        $('#txtDocumentEndDate').attr('datevalidate','gt:txtDocumentStartDate');       
        $('#txtSubmissionStartDate').attr('datevalidate','lt:txtSubmissionEndDate');
        $('#txtSubmissionStartDate').attr('datevalidate','lt:txtSubmissionEndDate');
        $('#DocumentStartDate').attr('datevalidate','lt:txtSubmissionEndDate');
    if(opType=="edit"){
    	changeRebate($('#selFormType'));
    	showWeightEvaluation($("#selIsItemwiseWinner"));
    }
    if(cstatus == 0){
    	changeDtValidationWhenReq();
    }

  	$("#selKeywords").select2({
	    minimumInputLength: 3,
	    ajax: {
	        url: contextPath+"/common/user/getCategoryData/4",
	        dataType: 'json',
	        type: "GET",
	        quietMillis: 50,
	        selectOnClose: true,
	        data: function (term) {
	            return  {
	                term: term.term
	            }
	        },
	        processResults: function (data, params) {
	            return {
	              results: $.map(data, function (item) {
	                    return {
	                        text: item[1], 
	                        id: item[0],
	                    }
	                }),
	            };
	          },
	    }
	});
  	changeEnvelopeValue($("#selEnvelopeType"));
}

var showWeightEvaluation = function(cThis){
	if($(cThis).val() == 0 && ($("#selFormType").val().indexOf("4")!=-1 || $("#selFormType").val().indexOf("5")!=-1)){
		$("#tdIsWeightEval").show();
	}else{
		$("#tdIsWeightEval").hide();
		$("#isWeightageEvaluationRequired").val("0");
	}
}
var changeRebate = function(cThis){
	var envlopStr=$(cThis).val();
    var envlop="";
    $.each( envlopStr, function( index, value ){
    	envlop += value+",";
    });
    if((envlop.search("4")!=-1 || envlop.search("5")!=-1) && $("#selIsItemwiseWinner").val() == 0){
    	$("#tdIsRebateApplicable").show();
    } else{
    	$("#selIsRebateApplicable").val(0);
    	$("#tdIsRebateApplicable").hide();
    }
}

var changeDtValidationWhenReq = function(comp)
{
    
	var havingVal='';
	var size = 0;
	for(val in dateFieldObject)
		{
			size++;
		}
	
	$(".dateBox").each(function(){
		var attr = $(this).attr("dtrequired");
		if(attr != null && attr != undefined && attr != '')
		{
			if(dateFieldObject[$(this).attr("id")] == undefined)
			{
					dateFieldObject[$(this).attr("id")] = $(this).attr("datevalidate");	
			}
			$(this).attr("onblur","changeDtValidationWhenReq(this)"); // Change data validation function.
			if($(this).val() != '' && havingVal == '')
				{
					havingVal = true;
				}
		}
	  });
	
	
	if(havingVal != true){
		for(obj in dateFieldObject){
			var compId = obj;
			$(".err"+compId).remove();	
			$("#hdIsDateValidationAllow").val(0);
			$("#"+compId).attr("dtrequired","false");
			$("#"+compId).removeAttr("datevalidate");
		}
		
	}
	
	
	if((comp != undefined && $(comp).val() != '') || havingVal == true){
		for(obj in dateFieldObject)
		{
			if(obj == 'txtPreBidStartDate')
			{
				if($("#selIsPreBidMeeting").val() == 1)
				{
					$("#"+obj).attr("datevalidate",dateFieldObject[obj]);		
					$("#"+obj).attr("dtrequired","true");
				}
			}else if(obj == 'txtPreBidEndDate')
			{
				if($("#selIsPreBidMeeting").val() == 1)
				{
					$("#"+obj).attr("datevalidate",dateFieldObject[obj]);
					$("#"+obj).attr("dtrequired","true");
				}
			} else if(obj == 'txtQuestionAnswerStartDate')
			{
				if($("#selIsQuestionAnswer").val() == 1)
				{
					$("#"+obj).attr("datevalidate",dateFieldObject[obj]);
					$("#"+obj).attr("dtrequired",true);
				}
			} else if(obj == 'txtQuestionAnswerEndDate')
			{
				if($("#selIsQuestionAnswer").val() == 1)
				{
					$("#"+obj).attr("datevalidate",dateFieldObject[obj]);
					$("#"+obj).attr("dtrequired","true");
				}
			} else
			{
				$("#"+obj).attr("datevalidate",dateFieldObject[obj]);
				$("#"+obj).attr("dtrequired","true");
			}
		}
		if(comp != undefined && comp != ''){
			validateEmptyDt($(comp));
		}
		$("#hdIsDateValidationAllow").val(0);
	} else{																		
			for(obj in dateFieldObject){
				var compId = obj;
				$(".err"+compId).remove();	
				$("#hdIsDateValidationAllow").val(0);
			}
	}
}