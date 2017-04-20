	var VALIDATE_MSG_REQUIRED = 'Please enter';
    var VALIDATE_MSG_NO_SPACE = 'Space is not allowed';
    var VALIDATE_MSG_INVALID_EMAIL = 'Please enter valid email ID';
    var VALIDATE_MSG_INVALID_EMAIL_MSGBOX = 'Allows Min. 6 Max. 1000 alphanumeric and Special Characters(@,.,-,_)';
    var CLIENT_DATETIME = new Date();
    var yr =  CLIENT_DATETIME.getFullYear();
    var Hours =  CLIENT_DATETIME.getHours();
    var mins =  CLIENT_DATETIME.getMinutes();
    var tDate=new Date();
	if(CLIENT_DATE_FORMATE_WHM.toUpperCase() == 'DD-MMM-YYYY'){
   		var cal_months_names = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
   		dateFormatString = tDate.getDate()+ '/' + cal_months_names[tDate.getMonth()] + '/' +  tDate.getFullYear()+' '+getFullNumber(Hours)+':'+getFullNumber(mins)+":00";
        CLIENT_DATETIME=dateFormatString;
	}
    $("#currentTime").val(tDate);
    var DATETIMEFORMATE_CALENDAR=CLIENT_DATE_FORMATE_WHM.toUpperCase().replace(/DD/g,'%d').replace(/MMM/g,'%mmm').replace(/MM/g,'%m').replace(/YYYY/g,'%Y')+' %H:%M';
    var DATEFORMATE_CALENDAR=CLIENT_DATE_FORMATE_WHM.toUpperCase().replace(/DD/g,'%d').replace(/MMM/g,'%mmm').replace(/MM/g,'%m').replace(/YYYY/g,'%Y');
    var VALIDATE_MSG_INVALID_CONF_EMAIL ="Confirm E-mail id do not match with"
    var VALIDATE_MSG_EMAIL_INVALID = 'Allows Min. 6 Max. 50 alphanumeric and Special Characters(@,.,-,_)';
    var VALIDATE_MSG_MINIMUM = 'Minimum';
    var VALIDATE_MSG_CHARS_ALLOWED = 'characters';
    var VALIDATE_MSG_MAXIMUM = 'Allows max.';
    var VALIDATE_MSG_CHANGESKEYWORD = 'alphabets, numbers and special characters (@,*, (,), -, +,/,.,&,Comma,Space)';
    var VALIDATE_MSG_ONLY_NUMERIC = 'Only numerics are allowed';
    var VALIDATE_MSG_ONLY_POSITIVE = 'Only positive numbers without decimal';
    var VALIDATE_MSG_ONLY_POSITIVE_1 = 'Only positive numbers are allowed';
    var VALIDATE_MSG_ONLY_ALPHABETS = 'Only alphabets are allowed';
    var VALIDATE_MSG_INVALID_CITY = 'Invalid city';
    var VALIDATE_MSG_INVALID_PHONE = 'Invalid phoneno';
    var VALIDATE_MSG_ONLY_ALPHA_NUM_SPECIAL = 'Please enter characters other than (=, &#39;, &quot;)';
    var VALIDATE_MSG_ONLY_ALPHA_NUM_SPECIAL_COMMA = 'Please enter characters other than (=, &#39;, &quot; ,(comma))';
    var VALIDATE_MSG_ONLY_ALPHA_NUM_SPECIAL_CHAR = 'Allows max. 5000 alphanumeric and special characters (*,@,/,+,-,Space,dot)';
    var VALIDATE_MSG_NUMERICFEWALPHA = 'Allows max. 50 alphabets, numbers and special characters (dot, -, /, comma, space, &, _)';
    var VALIDATE_MSG_ONLY_ALPHA_NUM_SPECIAL_MARQUEE = 'Allows Max. 2000 characters, numbers, special characters (* - + / , .)';
    var VALIDATE_MSG_INVALID_PASSWORD_SPECIAL_CHAR = 'Password must comprise of at least one alphanumeric and special character (!,@,#,$,_,.,(,))';
    var VALIDATE_MSG_INVALID_FULL_NAME = 'Invalid fullname';
    var VALIDATE_MSG_INVALID_DOC_NAME = 'Invalid document name';
    var VALIDATE_MSG_INVALID_COMPANY_NAME = 'Invalid companyname';
    var VALIDATE_MSG_INVALID_KEYWORD = 'Allows Max. 100 characters numbers and special characters (/ , - , ., ,, &)';
    var VALIDATE_MSG_INVALID_WEBSITE = 'Invalid website';
    var VALIDATE_MSG_INVALID_ALPHA_NUM_SPACE = 'Invalid alphanumwithspace';
    var VALIDATE_MSG_INVALID_CLIENT_NAME = 'Invalid client name';
    var VALIDATE_MSG_NUM_DECIMAL = 'Invalid number it must contain decimal upto';
    var VALIDATE_MSG_INVALID_CONF_PASSWORD = 'Confirm password does not match with';
    var VALIDATE_MSG_SAME_PASSWORD_AS_LOGINID = 'Password cannot be same as Email Id';
    var VALIDATE_MSG_SELECT = 'Please select';
    var VALIDATE_MSG_COMMAINVALID='Allows Max. 100 alphanumeric and Special Characters (), -, ,/,Space,&';
    var VALIDATE_MSG_TXTAREA='characters numbers and special characters (/ , - , ., ,&#39;,&,(,), comma, space)';
    var VALIDATE_MSG_ADDRESS='Characters numbers and special characters (/ , - , ., ,, space, &, :, ;)';
    var VALIDATE_MSG_UPTO='Allows max. {0} Digit(s) after decimal '; 
    var VALIDATE_MSG_DECIMALPOINT='digits after decimal';
    var VALIDATE_MSG_COMMON_NUM_DECIMAL='Allows only numeric values and';
    var VALIDATE_MSG_UPTO_FIVE_DECIMAL='Allowed  only 1 to 5 decimal';
    var VALIDATE_MSG_ONLY_NUMERIC_WITH_COMMA = 'Only numerics are allowed including comma in it.';
    var VALIDATE_MSG_UPTO_NINE_NUMERIC='Only numerics 1 to 9 are allowed';
    var VALIDATE_MSG_ALLOW_MAX='Allows Max. ';
    var VALIDATE_MSG_BRIEF='characters,numbers and special characters ((,),_,:,&,+, /, -, ., Comma,  Space)';
    var VALIDATE_MSG_FORM_NAME='characters,numbers and special characters ( / , - , .)';
    var VALIDATE_MSG_TENDERBRIEF='characters,numbers and special characters ((,),_,:,&,+, /, -, .,&#39;,Comma,  Space)';
    var VALIDATE_MSG_SPECIALALPHANUMERIC='alphabets, numbers and special characters (@,*, (,), -, +,/,., Space)';
    var INVALID='Invalid';
    var COMMON_UPTO_FIVE_DECIMAL='and upto five decimal allowed';
    var VALIDATE_BETWEEN='must be between ';
    var VALIDATE_GREATER='must be greater than ';
    var VALIDATE_LESSAR='must be smaller than';
    var VALIDATE_GREATER_SYSDATE='must be greater than current Date and Time';
    var VALIDATE_PREPONE_DATE='You are not allowed to prepone';
    var VALIDATE_LESSAR_SYSDATE='must be smaller than current Date and Time';
    var VALIDATE_NUMBER_LENGTH='numbers';
    var VALIDATE_MSG_MAX='Max.';
    var VALIDATE_MSG_INCDECVAL_IN_PER='in % should be greater than 0% and cannot be greater than 100%';
    var VALIDATE_MSG_REBATE_PERCENTAGE='Rebate cannot be less than 0% and greater than 100%';
    var VALIDATE_MSG_WEIGHTAGE_PERCENTAGE='Passing criteria should be less than or equal to scoring criteria';
    var VALIDATION_VALIDATIONMESSAGE='Allows Characters and Special Characters (Space, (.), (,))';
    var VALIDATE_TENDER_REFERENCE_NO='characters and special characters ((,), -, +,/,., Space)';
    var VALIDATE_TENDER_ADDRESS='Characters and Special Characters (,), -, /,., Space)';
    var VALIDATE_GE_CURRDATE='must be greater than or equals to current date and time.';
    var VALIDATE_GT_CURRDATE='must be greater than to current Date and Time.';
    var VALIDATE_GT_COMPDATE='must be greater than';
    var VALIDATE_GE_COMPDATE='must be greater than or equal to';
    var VALIDATE_LE_COMPDATE='must be less than or equal to';
    var VALIDATE_LT_COMPDATE='must be less than';
    var VALIDATE_LE_CURRDATE='must be less than or equal to current date.';
    var VALIDATE_REMARKS='Characters numbers and special characters ((,), -, +,/,., Space)';
    var VALIDATE_MSG_INVALID_ALPHANUMWITHNEWCHAR='Allows Max. 1000 alphabets, numbers and special characters ((,), -, +,/,., Space) ';
    var VALIDATE_MSG_INVALID_ALPHANUMWITHCHAR='Allows Max. 500 alphabets, numbers and Special Characters (/,-,.,, and space)';
    var VALIDATE_MSG_INVALID_ALPHANUMERICWITHSPECIAL='Allows Max. 1000 alphabets, numbers and special characters ((,),comma, -, +,/,., Space)';
    var VALIDATE_MSG_INVALID_ALPHAWITHSPECIAL='Alphabets and special characters (.,-,/,space with Max. allowed length 20 characters)';
    var VALIDATE_MSG_INVALID_SPECIALKEYWORD='alphabets, numbers and Special Characters (@,*, (,), -, +,/,., comma, Space)';
    var VALIDATE_MSG_INVALID_SPECIALKEYWORD_NUMBER='alphabets, numbers and special characters (@,*, (,), -, +,/,., Space)';
    var VALIDATE_MSG_INVALID_COMMON_KEYWORD='Allows Max. 1000 alphabets, numbers and special characters (@,*, (,), -, +,/,.,&,Comma,Space)';
    var VALIDATE_MSG_INVALID_SPECIAL_CHAR = "Allows Max. 50 Characters and Special character (',-,.)";
    var VALIDATE_MSG_INVALID_FINAL_NETVALUE_DEC="Max. 10 digits and 5 decimal points are allowed";
    var VALIDATE_MSG_INVALID_FINAL_NETVALUE_NUM="Only numeric values of max 10 digit value and 5 decimal points are allowed";
    var VALIDATE_TENDERKEYWORD_LENGTH='Allows Max. 1000 alphabets, numbers and special characters (@,*, (,), -, +,/,.,&,Comma,Space)';
    var VALIDATION_PERCENTAGE='Allows numeric value and special character (.) upto 5 decimal points';
    var VALIDATION_WEIGHTAGE_TEXT_PERCENTAGE_BEFORE='Allows numeric value and special character (.) upto ';
    var VALIDATION_WEIGHTAGE_TEXT_PERCENTAGE_AFTER='decimal points';
    var VALIDATION_SPLIT_PERCENTAGE_BEFORE='Allows numeric value and special character (.) upto';
    var VALIDATION_SPLIT_PERCENTAGE_AFTER='decimal points';
    var VALIDATE_MSG_SPLIT_ORDER_PERCENTAGE='Split order cannot be less than 0 and cannot be greater than or equal to 100';
    var VALIDATION_MSG_DATE_INVALID='Please enter valid date and time in DD/MM/YYYY and HH:MM format respectively';
    var VALIDATE_MSG_INVALID_CONF_ACCTNo='does not match with';
    var VALIDATE_MSG_PBG_DETAILS='Enter value from 0 to 100';
    var VALIDATE_NOZERO='Zero value is not allowed';

 
	function getFullNumber(number){
	    if(number < 10)
	        return '0' + number;
	    else
	        return number;
	}

    function getFullNumber(number){
        if(number < 10)
            return '0' + number;
        else
            return number;
    }

function loginValidate(){
  var flag1  = validateTextComponent($('#j_username'));
  var flag2  = validateTextComponent($('#j_password'));
  if(flag1 && flag2){
		var createPdfForm = document.createElement("form");
		createPdfForm.method = "POST";
		createPdfForm.action = contextPath+"/submitLogin";
		var username = $("<input>", {
			type : 'hidden',
			name : 'j_username',
			value : $('#j_username').val()
		});
		var password = $("<input>", {
			type : 'hidden',
			name : 'j_password',
			value : $('#j_password').val()
		});
		$(createPdfForm).append(username, password);
		document.body.appendChild(createPdfForm);
		createPdfForm.submit();
	    return true;
  }
  return false;
}
function validate(){
   var vbool = valOnSubmit();
   return disableBtn(vbool);
}

function submitLogout(){
	$('#formLogout').submit();
}

function setClickFunctionToDataGrid(){
	setTimeout(function(){
		if($(".dt-button.buttons-pdf.buttons-html5").html() != undefined){
			$(".dt-button.buttons-pdf.buttons-html5").attr("onclick",'exportContent("listingTable","'+$("#fileNameForExport").val()+'",0)');
			$(".dt-button.buttons-excel.buttons-html5").attr("onclick",'exportContent("listingTable","'+$("#fileNameForExport").val()+'",4)');
		}
	},1000);
}

	/**
		generateType=0,1 :PDF
		generateType=2 :HTML
		generateType=3 :Doc
		generateType=4 :Xls
		generateType=5 :Print
	**/
	
	var removeScriptTag = function(data){
		try{
			var SCRIPT_REGEX = /<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi;
			while (SCRIPT_REGEX.test(data)) {
				data = html.replace(SCRIPT_REGEX, "");
			}
		}catch(e){
			
		}
		return data;
	}

	var printHtml = function(html){
		console.log(html);
		var mywindow = window.open('', 'Print_Panel');
        mywindow.document.write(html);
        mywindow.document.close();
        setTimeout(function(){
        	mywindow.print();
        	mywindow.close();
        },500);
	}
	var exportContent = function(exportId,fileName,generateType){
		var htmlData;
	if (generateType == 5) {
			var html = '<HTML>\n<HEAD>\n<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">\n';
			if (document.getElementsByTagName != null) {
				var headTags = document.getElementsByTagName("head");
				if (headTags.length > 0)
					html += headTags[0].innerHTML;
			}
			html += '\n</HE' + 'AD>\n<BODY>\n';
			var data = document.getElementById(exportId);
			if (data != null){
				html += data.innerHTML;
			}else{
				return;
			}
			html += '\n</BO' + 'DY>\n</HT' + 'ML>';
			html = removeScriptTag(html);
			htmlData = $("<div/>").html($(html));
			$(htmlData).find(".noExport").remove();
			printHtml($(htmlData).html());	
			return;
		}
		var createPdfForm = document.createElement("form");
		createPdfForm.method = "POST";
		createPdfForm.action = contextPath+"/exportDataFromPage";
		htmlData = $("<div/>").html($("#" + exportId).clone());
		var data = $(htmlData).html();
		data = removeScriptTag(data);
		data = '<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">' + data;
		data = data.replace(/>\s+</g, "><");
		$(data).find(".noExport").remove();
		
          $(data).find('a').each(function() {
              $(this).attr('href','#');
          });
         htmlData = $("<div/>").html($(data));
		 $(htmlData).find(".noExport").remove();
         $(htmlData).find(".goBack").remove();
		var exportData = $("<input>", {
			type : 'hidden',
			name : 'pdfBuffer',
			value : $(htmlData).html()
		});
		if (fileName == undefined || fileName == "") {
			fileName = "dataExported";
		}
		var filename = $("<input>", {
			type : 'hidden',
			name : 'fileName',
			value : fileName
		});
		var gType = $("<input>", {
			type : 'hidden',
			name : 'txtGenerateType',
			value : generateType
		});
		$(createPdfForm).append(exportData, filename, gType);
		document.body.appendChild(createPdfForm);
		createPdfForm.submit();
	}
