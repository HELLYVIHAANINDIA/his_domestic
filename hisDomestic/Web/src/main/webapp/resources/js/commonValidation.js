function isRequiredTrue(textbox)
{
        var string=$.trim(textbox.value);
        var txtId= $(textbox).attr('id');
        $("#err"+txtId).remove();
        if(string==null || string==""){
                $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ENTERVAL+"</div>");
                textbox.value="";
                return false;
        }
        else
            {
                return true;
            }
}

function checkRequiredTrue(textbox)
{
        var string=$.trim(textbox.value);
        var txtId= $(textbox).attr('id');
        $("#err"+txtId).remove();
        if(string==null || string==""){
        textbox.value="";
            return false;
        }
        else
            {
                return true;
            }
}
function numeric(textbox) // Datatype = Numeric
{       
    var string=$.trim(textbox.value);
    var re5digit=/^([0-9]){0,15}$/;
    var txtId= $(textbox).attr('id');
    $("#err"+txtId).remove();
    if(string == 0){
		$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ZERONOTALLOW+"</div>"); 
		return false;
	}
    else if(string.indexOf("-") == 0){
        $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_MINUSNOTALLOW+"</div>"); 
        return false;
    }
    else if(string==null || string==""){
    	$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ENTERVAL+"</div>");
    	textbox.value="";
    	return false;
    }
    else if (!re5digit.test(string))
    {
        $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_NUMERIC15DIGIT+"</div>"); 
        return false;
    }
    return true;
}

function validateTxtBox(textbox, maxlen)
{
	var minlen = 0;
	
	var string=$.trim(textbox.value);
	var txtId= $(textbox).attr('id');
    $("#err"+txtId).remove();
    if(string==null || string==""){
    	$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ENTERVAL+"</div>");
    	textbox.value="";
       // textbox.focus();
    	return false;
    }
    if(txtId.indexOf('rtf') != -1){
    	string = string.replace(/(\r\n|\n|\r)/gm, " ").replace(/^\s+|\s+$/g, '').replace("&nbsp;", " ");
    	string = $.trim(stripCKEDITOR(string));
    }
    if(string!='' && string.length > maxlen){
    	$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+ VALIDATE_MSG_MAXIMUM + " " + maxlen + " " + VALIDATE_MSG_CHARS_ALLOWED + "</div>");
    }
}

function checkForMoney(textbox, digiLimit){ // Datatype = Money
    var val= $.trim(textbox.value);
    var txtId= $(textbox).attr('id');
    $("#err"+txtId).remove();
    if(val==null || val==""){
    	$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ENTERVAL+"</div>");
    	textbox.value="";
    	return false;
    }    
	if(val.indexOf(",")!= -1){
                $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_COMMANOTALLOW+"</div>"); 
		return false;
	}
	if(val.indexOf("-") == 0){
                $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_MINUSNOTALLOW+"</div>"); 
		return false;
	}
	
	if(val.indexOf('0') == 0 && val.indexOf('.') != 1 && val != 0){
		$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_REMOVELEADZERO+"</div>"); 
		return false;
	}
	
	var re5digit = null;
	if(digiLimit == 1){
		re5digit=/^[0-9]{0,15}\.{1}[0-9]{1,1}$/;
	}else if(digiLimit == 2){
		re5digit=/^[0-9]{0,15}\.{1}[0-9]{1,2}$/;
	}else if(digiLimit == 3){
		re5digit=/^[0-9]{0,15}\.{1}[0-9]{1,3}$/;
	}else if(digiLimit == 4){
		re5digit=/^[0-9]{0,15}\.{1}[0-9]{1,4}$/;
	}else if(digiLimit == 5){
		re5digit=/^[0-9]{0,15}\.{1}[0-9]{1,5}$/;
	}
        
	if(!re5digit.test(val)){
		if(val == 0){
			$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ZERONOTALLOW+"</div>"); 
			return false;
		}
		if(numerictestforfloat(textbox)){
	 		return true;
		}else{
			$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_NUM15DIGANDXDIGAFTERDECIMAL+"</div>"); 
			return false;
		}
	}else{
		if(val == 0){
			$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ZERONOTALLOW+"</div>"); 
			return false;
		}
		
		if(val.indexOf('.') > -1){
			val1 = val.substring(val.indexOf('.')+1,val.length);
			var val2;
			if(val1.indexOf('.') > -1){
                                $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_REMOVEEXTRPOINT+"</div>"); 
				return false;
			}
		}
		
		return true;
	}
}

function checkForMoneyAll(textbox, digiLimit) // Datatype =  Money all
{
    var txtId= $(textbox).attr('id');
    $("#err"+txtId).remove();
    var val= $.trim(textbox.value);
    var re5digit=/^([0-9]){0,15}$/;
    var v2;
    
    if(val==null || val==""){
    	$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_ENTERVAL+"</div>");
    	textbox.value="";
    	return false;
    } 
	
    var val1;
    if(val.indexOf('0') == 0 && val.indexOf('.') != 1 && val != 0)
    {
        $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_REMOVELEADZERO+"</div>");
        return false;
    }

    if(val.indexOf('-') == 0 )
    {
        if(val.indexOf('.') != 1)
            if(val.indexOf('0') == 1 && val.indexOf('.') != 2)
            {
                $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_REMOVELEADZERO+"</div>");
                return false;
            }
        val1 = val.substring(val.indexOf('-')+1,val.length);
        if(val1.indexOf('-') > -1)
        {
            $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_INVALIDNUMBERFORMAT+"</div>");
            return false;
        }
			
    }
    if(val.indexOf('.') > -1)
    {
        val1 = val.substring(val.indexOf('.')+1,val.length);
        var val2;
        if(val1.indexOf('.') > -1)
        {
            $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_REMOVEEXTRPOINT+"</div>");
            return false;
        }
    }
	
    if(val.indexOf(".") == 0){
        $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_DECIMALPRECEDEDBYNUM+"</div>");
        return false;
    } 
	
    if(val.indexOf('-') != 0)
    {
        if(val.indexOf('.') != -1)
            v2 = val.substring(0,val.indexOf('.'));
        else	
            v2 = val.substring(0,val.length);
			
        if(val.length > 0)
            if (!re5digit.test(v2))
            {
                $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_NUMERIC15DIGIT+"</div>");
                return false;
            }
    }
    if(val.indexOf('-') == 0)
    {
        if(val.indexOf('.') == -1)
        {
            v2 = val.substring(1,val.length);
        }
        else
        {
            v2 = val.substring(1,val.indexOf('.'));
        }
	
        if(val.length > 0)
            if (!re5digit.test(v2))
            {
                $(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_NUMERIC15DIGIT+"</div>");
                return false;
            }
    }
	
    re5digit=/^-?\d{1,15}$/;
	
    if(!re5digit.test(val)){
        if(CheckFloatForMoneyAll1(textbox, digiLimit)){
            return true;
        }else{
            return false;
        }
    }else{
        return true;
    }
    
    return true;
}

function CheckFloatForMoneyAll1(textbox, digiLimit) 
{
    var txtId= $(textbox).attr('id');
 	var val = textbox.value;
 	
	var re5digit;
	
	if(digiLimit == 1){
		re5digit = /^-?\d{1,15}(.\d{1,1})?$/;
	}else if(digiLimit == 2){
		re5digit = /^-?\d{1,15}(.\d{1,2})?$/;
	}else if(digiLimit == 3){
		re5digit = /^-?\d{1,15}(.\d{1,3})?$/;
	}else if(digiLimit == 4){
		re5digit = /^-?\d{1,15}(.\d{1,4})?$/;
	}else if(digiLimit == 5){		
		re5digit = /^-?\d{1,15}(.\d{1,5})?$/;
	}
	
	if(!re5digit.test(val)){
		if(numerictestforfloat(textbox)){
	 		return true;
		}else{
			$(textbox).parent().append("<div id='err"+txtId+"' class='errcode' style='color:red;'>"+MSG_AUC_NUM15DIGANDXDIGAFTERDECIMAL+"</div>"); 
			return false;
		}
	}else{
		return true;
	}
}

function numerictestforfloat(textbox)
{

    var string=textbox.value;
	var re5digit=/^([0-9]){0,15}$/;

	if (!re5digit.test(string))
	{
		 return false;
	}
	
	return true;
}