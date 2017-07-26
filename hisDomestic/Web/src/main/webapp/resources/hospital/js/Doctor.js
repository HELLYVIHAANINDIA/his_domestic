function changeTabDoctor(tabId,hdPatientId,hdUserTypeId){
	if(tabId != undefined){
		var url ;
		if(hdUserTypeId == 2){
			url = contextPath+"/domestic/doctor/tabcontent/"+tabId+"/"+hdPatientId+"/"+hdUserTypeId;
		}
		$.ajax({
			type: "POST",
			url: url,
			success: function success(result){
				$("#divCallPage").html("");
	 			$("#divCallPage").html(result);
		}
		});	
	}
	 $("#hdTabId").val(tabId);
}
$(document).ready(function() {
	var hdTabId = $("#hdTabId").val();
	var hdUserTypeId = $("#hdUserTypeId").val();
	var hdsuperAdmin = $("#hdsuperAdmin").val();
	var hdPatientId = $("#hdPatientId").val();
	if(hdUserTypeId==2){
//		if(hdTabId == 2){
			/*PatientType*/
			changeTabDoctor(hdTabId,hdPatientId,hdUserTypeId);
//		}
		/*else if(hdsuperAdmin){
			changeTabDoctor(hdTabId,hdPatientId,hdUserTypeId);
		}	*/
	}
	
});

function checkDuplicateEmail() {
	var data = {};
	var searchValue = $("#txtloginid").val();
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : contextPath+"/domestic/user/isemailidexists/"+searchValue+"/",
		data : data,
		timeout : 100000,
		async:false,
		success : function(data) {
			var obj = jQuery.parseJSON(data);
			$.each(obj, function (key, value) {
					if(value.isExists=='true'){
						$("#verifyMail").html("<span style=\"color:red\">Email ID is already registered<\span>");
						$("#verifyMail").show();
						return false;
					}else{
						$("#verifyMail").html("");
						$("#verifyMail").hide();
						return true;
					}
    		     });
		},
		error : function(e) {
		},
	});
	return true;
}
function getReferenceType(){
	$.ajax({
		contentType : "application/json",
		url : contextPath+"/domestic/user/getreferencetype",
		dataType: "json",
		async:false,
		success : function(data) {
			$("#selrefrence option").not(":first").remove();
			for(var i = 0; i <data.length;i++){
				$("#selrefrence").append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>");
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
	});
}

function getConsltingDoctor(){
	$.ajax({
		contentType : "application/json",
		url : contextPath+"/domestic/user/getConsltingDoctor",
		dataType: "json",
		async:false,
		success : function(data) {
			$("#selconsltingDoctor option").not(":first").remove();
			for(var i = 0; i <data.length;i++){
				$("#selconsltingDoctor").append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			  console.log(jqXHR+"------jqXHR");
	            console.log(textStatus+'------textStatus');
	            console.log(errorThrown+'-----errorThrown');
		},
	});
}
function getState(){
    var countryId = $("#selCountry").val();
    if(countryId != ""){
    	$.ajax({
		contentType : "application/json",
		url : contextPath+"/domestic/user/getstatebycountry/"+countryId,
		dataType: "json",
		async:false,
		success : function(data) {
			$("#selState option").not(":first").remove();
			for(var i = 0; i <data.length;i++){
				$("#selState").append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>")
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
	});
   }
 }
function getSocialEconomicStatus(){
	$.ajax({
		contentType : "application/json",
		url : contextPath+"/domestic/user/getSocialEconomicStatus",
		dataType: "json",
		async:false,
		success : function(data) {
			$("#selEconomic option").not(":first").remove();
			for(var i = 0; i <data.length;i++){
				$("#selEconomic").append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>");
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
	});
}
function getPayby(){
	$.ajax({
		contentType : "application/json",
		url : contextPath+"/domestic/user/getPayBy",
		dataType: "json",
		async:false,
		success : function(data) {
			$("#selPayby option").not(":first").remove();
			for(var i = 0; i <data.length;i++){
				$("#selPayby").append("<option value='"+data[i][0]+"'>"+data[i][1]+"</option>");
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
	});
}
