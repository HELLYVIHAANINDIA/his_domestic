var rgx_email_id = /^((([a-z]|\d|[\-_ ]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[\-_]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i; //email,emailmsgbox
var rgx_phoneno = /^((\+){0,1}[0-9][0-9](\-){0,1}){0,1}([0-9]+(\-)*[0-9]+)+$/;
var rgx_alphanumspecial = /^([0-9a-zA-Z\@\*\(\)\-\+\.\s\/\,]*)[a-zA-Z\@\*\(\)\-\+\.\s\,\/]+([0-9a-zA-Z\@\*\(\)\-\+\.\s\/\,]*)$/;
var rgx_number = /^[0-9]*$/;
var rgx_brief =/^([0-9a-zA-Z\s]*)[0-9a-zA-Z\s\-\/\.\(\)_:&\,\+]+([0-9a-zA-Z\s\-\/\.\(\)_:&\,\+\s]*)$/;
var rgx_password  = /^((?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$_\.\(\)])[a-zA-Z0-9!@#$_\.\(\)]{8,50})+$/;
var rgx_fullname = /^([a-zA-Z\'\-\.\s]*)[a-zA-Z]+([a-zA-Z\'\-\.\s]*)$/;
var rgx_website =/^([a-zA-Z0-9_\-]+(?:\.[a-zA-Z0-9_\-]+)(?:\.[a-zA-Z0-9_\-]+)*\.[a-zA-Z]{2,4}(?:\/[a-zA-Z0-9_]+)*(?:\/[a-zA-Z0-9_]+\.[a-zA-Z]{2,4}(?:\?[a-zA-Z0-9_]+\=[a-zA-Z0-9_]+)?)?(?:\&[a-zA-Z0-9_]+\=[a-zA-Z0-9_]+)*)$/;
var rgx_url = /^http(s)?:\/\/(www\.)?[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/;
var rgx_numwithdecimal = "^\\d.*?\\.\\d{decimalUpto}$";
var rgx_integeronly = /^[1-9]\d*$/;
var rgx_positivewithdecimal=/^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$/;
var rgx_uptodecimal = "^\\s*-?[0-9]\\d*(\\.\\d{1,decimal})?\\s*$";
var rgx_uptofivenum = /^[1-5]*$/;
var rgx_uptoninenum = /^[1-9]*$/;
var rgx_onetoninenum = /^[1-9]*$/;
var rgx_alphanumspecialrtf = /^([0-9a-zA-Z\=\:\,\#\&\;\'\"\>\<\@\*\(\)\-\+\.\s\/]*)[a-zA-Z]+([0-9a-zA-Z\=\:\,\#\&\;\'\"\>\<\@\*\(\)\-\+\.\s\/]*)$/;
var rgx_validatonmessage = /^([0-9a-zA-Z\.\s\,]*)[a-zA-Z]+([0-9a-zA-Z\.\s\,]*)$/;
var rgx_tenderbrief =/^([0-9a-zA-Z\s]*)[0-9a-zA-Z\s\-\/\.\(\)_:&\'\,\+]+([0-9a-zA-Z\s\-\/\.\(\)_:&\,\+\s]*)$/;
var rgx_alphawithspecial = /^([0-9a-zA-Z\s]*)[a-zA-Z\-\.\/\s]+([0-9a-zA-Z\-\.\/\s]*)$/; 
var rgx_alphanumspecialwithoutcomm = /^([0-9a-zA-Z\&\_\-\.\s\(\)\/\,]*)[0-9a-zA-Z\&\_\-\.\s\(\)\,\/]+([0-9a-zA-Z\&\_\-\.\s\(\)\/\,\&]*)$/;
var rgx_dateddmmyyyy =/^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2} (0\d|1\d|2[0-3]):(0\d|1\d|2\d|3\d|4\d|5\d)$/;
var rgx_datemmddyyyy =/^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2} (0\d|1\d|2[0-3]):(0\d|1\d|2\d|3\d|4\d|5\d)$/;
var rgx_dateddmmyyyy=/^(0[1-9]|1\d|2\d|3[01])\ (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\ (19|20)\d{2} (0\d|1\d|2[0-3]):(0\d|1\d|2\d|3\d|4\d|5\d)$/;
var rgx_alphanumericspecial_subject = /^([0-9a-zA-Z\s]*)[0-9a-zA-Z\+\-\*\@\.\/\(\)\,\s]+([0-9a-zA-Z\+\-\*\@\.\/\(\)\,\s]*)$/; 
var rgx_numericswithcomma = /^[0-9\,]*$/;
var rgx_allmoney = "^-?[0-9]+(.?[0-9]{0,5})?$";
var mandatoryCheckBoxIds=new Array();
var rgx_posnegwithdecimal= "/^-?[0-9]+(.[0-9]{0,decimal})?$/";
var rgx_alphabets = /^[\sa-zA-Z\'\-]+$/;

var  validateTextComponent = function(comp){
   
    var compVal = $.trim($(comp).val());
    $(comp).val(compVal);

    var compId = $(comp).attr('id');
    var tbool=true;
    $(".err"+compId).remove();
    var valids = $(comp).attr("validarr").split("@@");

    var notcommmsg = true;
    var isreqfired = false;
    if($(comp).attr("validationmsg")!=undefined){
        notcommmsg = false;
    }
    var maxlen = 0;
    for(var i=0;i<valids.length;i++){
        var str = valids[i];
        var minlen = 0;

        var decimalupto = 0;
        var othercmpId = '';
        var uptodecimal=0;
        if(str.indexOf(':', 0)!=-1){    
            var lenArr = str.split(':');
            str = lenArr[0];

            if(str == 'length'){
                minlen = parseInt(lenArr[1].split(',')[0]);
                maxlen = parseInt(lenArr[1].split(',')[1]);
            }else if(str == 'alphanumericlength'){
                minlen = parseInt(lenArr[1].split(',')[0]);
                maxlen = parseInt(lenArr[1].split(',')[1]);
            }else if(str == 'numwithdecimal'){
                decimalupto = parseInt(lenArr[1]);
            }else if(str == 'posnegnumwithdecimal')
            {
                decimalupto = parseInt(lenArr[1]);
            }else if(str == 'checkloginidpwd'){
                othercmpId = lenArr[1];
            }else if(str == 'confirmpwd'){
                othercmpId = lenArr[1];
            }else if(str == 'confirmemail'){
                othercmpId = lenArr[1];
            }else if(str == 'numanduptodecimal'){
                uptodecimal = lenArr[1];
            }else if(str == 'lengthForNum'){
                maxlen = parseInt(lenArr[1]);
            }else if(str == 'tenderbrief'){
                maxlen = parseInt(lenArr[1]);
            }           
        }
        var compValEmpty = (compVal!='');
        rgx_uptodecimal="^\\s*-?[0-9]\\d*(\\.\\d{1,decimal})?\\s*$";
        var titleVal = $(comp).attr('title')!='' ? $(comp).attr('title') : 'value';
        switch (str){
            case 'required':
                if(tbool && !compValEmpty){
                	setValidationMsg(comp,compId,VALIDATE_MSG_REQUIRED + " " +titleVal);
                    tbool = false;
                    isreqfired = true;
                }
                break;                
            case 'email':
                if(tbool && compValEmpty){  /* && !rgx_email_id.test(compVal) */
                    
                    	if(compVal.length < 6 || compVal.length > 50 || !(/^[ A-Za-z0-9@.\-_]*$/.test(compVal))){  /* length and special characters*/
                    		if(notcommmsg){
                    			setValidationMsg(comp,compId,VALIDATE_MSG_EMAIL_INVALID);
                    		}
                			tbool = false;
                		}else if(!rgx_email_id.test(compVal)){ /* validate email */
                			if(notcommmsg){
                				setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_EMAIL);
                			}
                			tbool = false;
                        }
                    
                }
                break;
                
            case 'alphabet':
                if(tbool && compValEmpty && !rgx_alphabets.test(compVal)){
                    if(notcommmsg){
                        $(comp).parent().append("<div class='err"+compId+" validationMsg clearfix'>" + VALIDATE_MSG_ONLY_ALPHABETS + "</div>");
                    }
                    tbool = false;
                }
                break;
            case 'alphanumericlength':
                
                var tempVal = compVal;
                
                if(compId.indexOf('rtf') != -1){
                     
                	compVal=compVal.replace(/&nbsp;/g, " ");
                    compVal = compVal.replace(/(\r\n|\n|\r)/gm, " ").replace(/^\s+|\s+$/g, '');
                }
                if(tbool && compValEmpty && minlen!=0 && compVal.length < minlen){
                  
                    if(notcommmsg){
        				setValidationMsg(comp,compId,VALIDATE_MSG_MINIMUM + " " + minlen + " " + VALIDATE_MSG_NUMERICFEWALPHA);
                    }
                    tbool = false;
                }
             
                if(tbool && compValEmpty && maxlen!=0 && compVal.length > maxlen){
                  
                    if(notcommmsg){
                      
                        setValidationMsg(comp,compId,VALIDATE_MSG_MAXIMUM + " " + maxlen + " " + VALIDATE_MSG_NUMERICFEWALPHA);
                    }
                    tbool = false;
                }
            break;
                
            case 'length':
           
                var tempVal = compVal;
                
                if(compId.indexOf('rtf') != -1){
                     
                	compVal=compVal.replace(/&nbsp;/g, " ");
                    compVal = compVal.replace(/(\r\n|\n|\r)/gm, " ").replace(/^\s+|\s+$/g, '');
                }
                if(tbool && compValEmpty && minlen!=0 && compVal.length < minlen){
                  
                    if(notcommmsg){
                        setValidationMsg(comp,compId,VALIDATE_MSG_MINIMUM + " " + minlen + " " + VALIDATE_MSG_CHARS_ALLOWED);
                    }
                    tbool = false;
                }
             
                if(tbool && compValEmpty && maxlen!=0 && compVal.length > maxlen){
                  
                    if(notcommmsg){
                      
                    	setValidationMsg(comp,compId,VALIDATE_MSG_MAXIMUM + " " + maxlen + " " + VALIDATE_MSG_CHARS_ALLOWED);
                    }
                    tbool = false;
                }
                break;

            
            
            case 'lengthForNum':
                var beforeDot=compVal.split(".",1);
                if(tbool && compValEmpty && maxlen!=0 && beforeDot[0].length > maxlen){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_MAXIMUM + " " + maxlen + " " + VALIDATE_NUMBER_LENGTH);
                    }
                    tbool = false;
                }
                break;
            case 'numeric':
                if(tbool && compValEmpty && !rgx_number.test(compVal)){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_ONLY_NUMERIC);
                    }
                    tbool = false;
                }
                break;
            case 'numericwithcomma':
            	if(tbool && compValEmpty && !rgx_numericswithcomma.test(compVal))
            	{
            		if(notcommmsg)
            		{
            			setValidationMsg(comp,compId,VALIDATE_MSG_ONLY_NUMERIC_WITH_COMMA);
            		}
            		tbool =false;	
            	}
            	break;
            case 'uptofive':
                if(tbool && compValEmpty && !rgx_uptofivenum.test(compVal)){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_UPTO_FIVE_DECIMAL);
                    }
                    tbool = false;
                }
                break;
            case 'posnegnumwithdecimal':
                debugger;
                if(tbool && compValEmpty){
                    rgx_posnegwithdecimal = rgx_posnegwithdecimal.replace('decimal',decimalupto);
                    var decimalRegex = new RegExp(rgx_posnegwithdecimal);
                    if(compVal != undefined && compVal.indexOf(".") == -1){
                    	compVal = compVal+".00";
                    }
                    if (!decimalRegex.test(compVal)){
                        if(notcommmsg){
                        	setValidationMsg(comp,compId,VALIDATE_MSG_NUM_DECIMAL + " " +decimalupto);
                        }
                        tbool = false;
                    }
                }
                
            break;
            case 'uptonine':
                if(tbool && compValEmpty && !rgx_uptoninenum.test(compVal)){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_UPTO_NINE_NUMERIC);
                    }
                    tbool = false;
                }
                break;
            case 'onetonine':
                if(tbool && compValEmpty && !rgx_onetoninenum.test(compVal) && parseInt(compVal,10)==0){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_UPTO_NINE_NUMERIC);
                    }
                    tbool = false;
                }
                break;
            case 'integeronly':
                if(tbool && compValEmpty && !rgx_integeronly.test(compVal)){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_ONLY_POSITIVE);
                    }
                    tbool = false;
                }
                break;
                
                
                
            case 'phoneno':
                if(tbool && compValEmpty && !rgx_phoneno.test(compVal)){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_PHONE);
                    }
                    tbool = false;
                }
                break;
                
                
            case 'alphanumspecial':
                if(tbool && compValEmpty && (/\-{2}/.test(compVal) || !rgx_alphanumspecial.test(compVal))){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_ONLY_ALPHA_NUM_SPECIAL);
                    }
                    tbool = false;
                }
                break;
           
                
            case 'password':
                if(tbool && compValEmpty && !rgx_password.test(compVal)){
                    if(notcommmsg){
                    	if(compVal.length < 8 || compVal.length > 50 ||  (/^(?=.*\d)(?=.*[a-zA-Z])(?=.*[\{\}\'\"\?\^\|\[\]\-\_<>\:\;\+\*\`\~\\]).{6,}$/.test(compVal))){
                    		setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_PASSWORD);
                    	}else{
                    		setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_PASSWORD_SPECIAL_CHAR);
                    	}
                    }
                    tbool = false;
                }
                break;
                
                
                
            case 'fullname':
                if(tbool && compValEmpty && (/\-{2}/.test(compVal) || !rgx_fullname.test(compVal))){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_FULL_NAME);
                    }
                    tbool = false;
                }
                break;
                
                

                
            case 'website':
                if(tbool && compValEmpty && (/\-{2}/.test(compVal) || !rgx_website.test(compVal) && !rgx_url.test(compVal))){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_WEBSITE);
                    }
                    tbool = false;
                }
                break;
            
                
                
            case 'numwithdecimal':
                if(tbool && compValEmpty){
                    rgx_numwithdecimal = rgx_numwithdecimal.replace('decimalUpto',decimalupto);
                    var decimalRegex = new RegExp(rgx_numwithdecimal);
                    if(compVal != undefined && compVal.indexOf(".") == -1){
                    	compVal = compVal+".00";
                    }
                    if (!decimalRegex.test(compVal)){
                        if(notcommmsg){
                        	setValidationMsg(comp,compId,VALIDATE_MSG_NUM_DECIMAL + " " +decimalupto);
                        }
                        tbool = false;
                    }
                }
                break;
				
				
            case 'nonzero':
				if(tbool && compValEmpty){
					if(eval(compVal)==0){
						if(notcommmsg){
							setValidationMsg(comp,compId,VALIDATE_NOZERO);
						}
						tbool = false; 
					}
				}
				break;
				

            case 'confirmpwd':
                if(tbool && compValEmpty && compVal != $('#txt'+othercmpId).val()){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_CONF_PASSWORD +' ' + $('#txt'+othercmpId).attr('title'));
                    }
                    tbool = false;
                }
                break;
            case 'confirmemail':
                if(tbool && compValEmpty && compVal != $('#txt'+othercmpId).val()){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_INVALID_CONF_EMAIL +' ' + $('#txt'+othercmpId).attr('title'));
                    }
                    tbool = false;
                }
                break;
			
			 case 'checkloginidpwd':
				if(tbool && compValEmpty && compVal == $('#txt'+othercmpId).val()){
					if(notcommmsg){
						setValidationMsg(comp,compId,VALIDATE_MSG_SAME_PASSWORD_AS_LOGINID);
					}
					tbool = false;
				}
				break;

            
            
            case 'tenderbrief':
                if(tbool && compValEmpty && (/\-{2}/.test(compVal) || !rgx_tenderbrief.test(compVal) || maxlen<compVal.length)){
                    if(notcommmsg){
                    	setValidationMsg(comp,compId,VALIDATE_MSG_ALLOW_MAX+" "+maxlen+" "+VALIDATE_MSG_TENDERBRIEF);
                    }
                    tbool = false;
                }
                break;

            
            case 'numanduptodecimal':
                if(tbool && compValEmpty ){
                    if(compVal!=null && compVal!= ""){
                        rgx_uptodecimal=rgx_uptodecimal.replace('decimal',uptodecimal);
                        var decimalRegex = new RegExp(rgx_uptodecimal);
                        if(compVal.indexOf('.', 0)==-1){
                            if (!rgx_number.test(compVal)){
                                if(notcommmsg){
                                	setValidationMsg(comp,compId,VALIDATE_MSG_ONLY_NUMERIC);
                                }
                                tbool = false;
                            }
                        }else{
                            var number=compVal.split('.')[0];
                            if (!rgx_number.test(number)){
                                if(notcommmsg){
                                	setValidationMsg(comp,compId,VALIDATE_MSG_ONLY_NUMERIC);
                                }
                                tbool = false;
                            }else{
                                if (!decimalRegex.test(compVal)){
                                    if(notcommmsg){
                                    	setValidationMsg(comp,compId,VALIDATE_MSG_MAXIMUM+" "+uptodecimal +" "+VALIDATE_MSG_DECIMALPOINT);
                                    }
                                    tbool = false;
                                }
                            }
                        }
                }
            }
            break;

            
        }
    }
    if(!tbool && !isreqfired && !notcommmsg){
        setValidationMsg(comp,compId,$(comp).attr("validationmsg"));
        
    }

    return tbool;
}
 
function valOnSubmit(){
       var  vbool = true;
       var txtAreaValArr = new Array();
       var cnt=0;
    $("input[tovalid='true']").each(function(){
            if(!$(this).is(':disabled')  && !validateTextComponent(this)){
        	  cnt=cnt+1;
               if(cnt==1){
                $(this).focus();
                  }
            vbool = false;
         
        }
    });

    $("textarea[tovalid='true']").each(function(){
        if(!$(this).is(':disabled')){
            var isRTF = false;
            if($(this).attr('id').indexOf('rtf') != -1){
               // CKEDITOR.instances[$(this).attr('id')].setData(CKEDITOR.instances[$(this).attr('id')].getData().replace(/-/g,'&#45;'));
            	var data = $('iframe').contents().find('.wysihtml5-editor').text();
            	$(this).val(data);
                isRTF = true;
            }
            if(!validateTextComponent(this)){
                cnt=cnt+1;
                if(cnt==1){
                    $(this).focus();
                }
                vbool = false;
            }else{
                if(!isRTF){
                    txtAreaValArr.push(this);
                }
            }            
        }
    });
    $("select[isrequired='true']").each(function(){
        if(!$(this).is(':disabled')  && !validateCombo(this)){
            cnt=cnt+1;
            if(cnt==1){
                $(this).focus();
            }
            vbool = false;
        }
    });
    $("input[datepicker='yes']").each(function(){
        if(!$(this).is(':disabled')  && !validateEmptyDt(this)){
            cnt=cnt+1;
            if(cnt==1){
                $(this).focus();
            }
            vbool = false;
        }
    });
    $("input[type=checkbox]").each(function(){
        if(!$(this).is(':disabled') && $(this).attr('isrequired')){
        	createMandatoryCheckBoxArray(this);
        }
    });
    vbool=dynamicCheckBoxValidation(vbool);
    if(vbool){
        safePageTextArea(txtAreaValArr);
    }
    return vbool;
}

function safePageTextArea(txtAreaValArr){
    for(var j=0;j<txtAreaValArr.length;j++){        
        $(txtAreaValArr[j]).val(replaceQuotes($(txtAreaValArr[j]).val().replace(/>\s+</g, '><')));
    }
}
function createMandatoryCheckBoxArray(comp){
	var cnt=0;
	for(var i=0;i<mandatoryCheckBoxIds.length;i++){
		var fieldName= $(comp).attr('name');
		if(fieldName==$(mandatoryCheckBoxIds[i]).attr('name')){
			cnt++;
		}
	}
	if(cnt==0){
		mandatoryCheckBoxIds.push(comp);
	}
}
function dynamicCheckBoxValidation(vbool){
	if(mandatoryCheckBoxIds.length > 0){
		var cnt=0;
		for(var i=0;i<mandatoryCheckBoxIds.length;i++){
    		var compName=$(mandatoryCheckBoxIds[i]).attr('name');
    		$('.err'+compName).remove();
		}
    	for(var i=0;i<mandatoryCheckBoxIds.length;i++){
    		var comp=$(mandatoryCheckBoxIds[i]);
    		var compName = $(comp).attr('name');
    		var chkBool =true;
    		$('input[name='+compName+']').each(function(){
    			var cntChecked=0;
    			var isChecked=$(this).attr('checked');
				if(isChecked){
					cntChecked++;
				}
				if(cntChecked>0){
					chkBool=false;
				}
	   	 	 });
    		 if(chkBool){
    			 setValidationMsg(comp,compId,VALIDATE_MSG_SELECT + " " +($(comp).attr('title')!='' ? $(comp).attr('title') : 'value'));
    			cnt++;
    		 }
    	}
    	if(cnt==0 && vbool){
    		return true;
    	}else{
    		return false;
    	}
    }else{
    	return vbool;
    }
}
function validateCombo(comp){
    var compVal = $(comp).val();
    var compId = $(comp).attr('id');
    var tbool=true;
    $(".err"+compId).remove();
    if(compVal != ''){
		$("#selValidation option[value='']").attr('selected', false);
	}
    //comVal==-1 add by Pooja
    if(compVal=='' || compVal==null || compVal==-1){
        setValidationMsg(comp,compId,VALIDATE_MSG_SELECT + " " +($(comp).attr('title')!='' ? $(comp).attr('title') : 'value'));
        tbool = false;
    }
    return tbool;
}
function isValidDate(dateString,dateFormateFlag)
{
	var dateWithOutTime = dateString.split(" ");
	var parts;
	var day = 0;
    var month = 0;	
    var year = 0;
	if(dateFormateFlag!=3){
		parts = dateWithOutTime[0].split("/");	
	}else{
		switch(dateWithOutTime[1]){
		case'Jan':
			dateWithOutTime[1] = 01;
			break;
		case'Feb':
			dateWithOutTime[1] = 02;
			break;
		case'Mar':
			dateWithOutTime[1] = 03;
			break;
		case'Apr':
			dateWithOutTime[1] = 04;
			break;
		case'May':
			dateWithOutTime[1] = 05;
			break;
		case'Jun':
			dateWithOutTime[1] = 06;
			break;
		case'Jul':
			dateWithOutTime[1] = 07;
			break;
		case'Aug':
			dateWithOutTime[1] = 08;
			break;
		case'Sep':
			dateWithOutTime[1] = 09;
			break;
		case'Oct':
			dateWithOutTime[1] = 10;
			break;
		case'Nov':
			dateWithOutTime[1] = 11;
			break;
		case'Dec':
			dateWithOutTime[1] = 12;
			break;
		}
		parts = [dateWithOutTime[0],dateWithOutTime[1],dateWithOutTime[2]];
	}
    
    if(dateFormateFlag == 1 || dateFormateFlag == 3){
    	day = parseInt(parts[0], 10);
        month = parseInt(parts[1], 10);
        year = parseInt(parts[2], 10);
    }else if(dateFormateFlag == 2){
    	day = parseInt(parts[1], 10);
        month = parseInt(parts[0], 10);
        year = parseInt(parts[2], 10);
    }

    if(year < 1000 || year > 3000 || month == 0 || month > 12){
    	return false;
    }
    var monthLength = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];

    if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)){
    	monthLength[1] = 29;
    }

    return day > 0 && day <= monthLength[month - 1];
}
function validateEmptyDt(comp){
	 var compVal = toJSDate($(comp).val());
	    var compId = $(comp).attr('id');
	    var dateFormate = $(comp).attr('placeholder');
	    var dateFormateArry = dateFormate.split(" ");
	    var tbool=true;
	    $(".err"+compId).remove();
	    
    if($(comp).val()!='' && tbool && !$(comp).attr('readonly')){
    	if(dateFormateArry[0] == 'DD/MM/YYYY'){
    		if(!rgx_dateddmmyyyy.test($(comp).val())){
    			setValidationMsg(comp,compId,VALIDATION_MSG_DATE_INVALID);
                tbool = false;
            }else if(!isValidDate($(comp).val(),1)){
            	setValidationMsg(comp,compId,VALIDATION_MSG_DATE_INVALID);
                tbool = false;
            }	
    	}else if(dateFormateArry[0] == 'MM/DD/YYYY'){
    		if(!rgx_datemmddyyyy.test($(comp).val())){
    			setValidationMsg(comp,compId,VALIDATION_MSG_DATE_INVALID);
                tbool = false;
            }else if(!isValidDate($(comp).val(),2)){
            	setValidationMsg(comp,compId,VALIDATION_MSG_DATE_INVALID);
                tbool = false;
            }
    	}
    	else if(dateFormateArry[1] == 'MMM'){
    		if(!rgx_dateddmmyyyy.test($(comp).val())){
    			setValidationMsg(comp,compId,VALIDATION_MSG_DATE_INVALID);
    			tbool = false;
            }else if(!isValidDate($(comp).val(),3)){
            	setValidationMsg(comp,compId,VALIDATION_MSG_DATE_INVALID);
                tbool = false;
            }
    	}
    }
    
    
    if(compVal!='' && tbool){
        if($(comp).attr('datevalidate')!=undefined){
            var compIds = $(comp).attr('datevalidate').split(",");
            $.each(compIds,function(key, value ){
                var datesp=compIds[key].split(":");
                if(datesp[1]=='c'){
                    if(datesp[0]=='ge'){
                        var cdate=toJSDate(CLIENT_DATETIME.substring(0, CLIENT_DATETIME.lastIndexOf(":")));  
                        if(cdate>compVal){
                        	setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_GE_CURRDATE)
                            tbool = false;
                        }
                    }else if(datesp[0]=='gt'){
                        var cdate=toJSDate(CLIENT_DATETIME.substring(0, CLIENT_DATETIME.lastIndexOf(":")));  
                        if(cdate>=compVal){
                        	setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_GT_CURRDATE);
                            tbool = false;
                        }
                    }else if(datesp[0]=='le'){
                    	var cdate=toJSDate(CLIENT_DATETIME.substring(0, CLIENT_DATETIME.lastIndexOf(":")));  
                        if(cdate<compVal){
                            setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_LE_CURRDATE);
                            tbool = false;
                        }
                    }
                }else if(datesp[1]!='c'){
                    if($('#'+datesp[1]).val()!='' && $('#'+datesp[1]).val()!=null){
                        if(datesp[0]=='ge'){
                            var compareDate = toJSDate($('#'+datesp[1]).val());
                            if(compareDate>compVal){
                                setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_GE_COMPDATE+" "+($('#'+datesp[1]).attr('title')!='' ? $('#'+datesp[1]).attr('title') : 'date'));
                                tbool = false;
                            }
                        }
                        else if(datesp[0]=='gt'){
                            var compareDate = toJSDate($('#'+datesp[1]).val());
                            if(compareDate>=compVal){
                            	setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_GT_COMPDATE+" "+($('#'+datesp[1]).attr('title')!='' ? $('#'+datesp[1]).attr('title') : 'date'));
                                tbool = false;
                            }
                        }
                        else if(datesp[0]=='le'){
                            var compareDate = toJSDate($('#'+datesp[1]).val());
                            if(compareDate<compVal){
                                setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_LE_COMPDATE+" "+($('#'+datesp[1]).attr('title')!='' ? $('#'+datesp[1]).attr('title') : 'date'));
                                tbool = false;
                            }
                        }
                        else if(datesp[0]=='lt'){
                            var compareDate = toJSDate($('#'+datesp[1]).val());
                            if(compareDate<=compVal){
                                setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_LT_COMPDATE+" "+($('#'+datesp[1]).attr('title')!='' ? $('#'+datesp[1]).attr('title') : 'date'));
                                tbool = false;
                            }
                        }
                    }
                }
                if(!tbool){
                    return tbool;
                }
            });
        }
    }
    if($(comp).attr('dtrequired')!=undefined &&  $(comp).attr('dtrequired') == 'true' && compVal==''){
        setValidationMsg(comp,compId,(VALIDATE_MSG_SELECT + " " +($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')));

        tbool = false;
    }
    if(compVal!='' && tbool){
        var isgreater = false;
        if($(comp).attr('comparewith')!=undefined){
            if($(comp).attr('comparewith').indexOf(',', 0)!=-1){
                var compIds = $(comp).attr('comparewith').split(",");
                var startDt = toJSDate($('#'+compIds[0]).val());
                var endDt = toJSDate($('#'+compIds[1]).val());
                if(!(startDt<=compVal && endDt>=compVal)){
                    setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_BETWEEN +($('#'+compIds[0]).attr('title')!='' ? $('#'+compIds[0]).attr('title') : 'date')+" and " +($('#'+compIds[1]).attr('title')!='' ? $('#'+compIds[1]).attr('title') : 'date'));

                    tbool = false;
                }
            }else{
                isgreater = $(comp).attr('isgreater')!=undefined ? $(comp).attr('isgreater') : false;
                var datecomp = $('#'+$(comp).attr('comparewith'));
                var compDt = toJSDate(datecomp.val());
                if(isgreater=='true' && compDt>=compVal){
                	setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_GREATER +(datecomp.attr('title')!='' ? datecomp.attr('title') : 'date'));
                    tbool = false;
                }
                if(isgreater=='false' && compDt<compVal){
                	setValidationMsg(comp,compId,($(comp).attr('title')!='' ? $(comp).attr('title') : 'date')+"  "+VALIDATE_LESSAR +(datecomp.attr('title')!='' ? datecomp.attr('title') : 'date'));

                    tbool = false;
                }
            }
        }
    }
    return tbool;
}
function disableBtn(status){

    if(status){
        $("input[type='submit']").each(function(){
        	
            $(this).attr('disabled',true);
        });
    }
    return status;
}
function toJSDate(date){
    if(date!='' && date!=undefined){
        var cal_months_names = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
        for(var cal=0;cal<cal_months_names.length;cal++){            
            date = date.replace(cal_months_names[cal],((eval(cal+1)<=9) ? '0': '')+eval(cal+1));
        }
        var time = date.substr(date.lastIndexOf(" ")+1);
        date = date.indexOf(":") != -1 ? date.substr(0, date.lastIndexOf(" ")) : date;
        var day = date.slice(0,2);
        var month = date.slice(3,5);
        var year = date.slice(6,11);
        if(DATEFORMATE_CALENDAR.indexOf('%d')>1){
            var temp = month;
            month=day;
            day=temp;
        }
        var finalStartDt=year+"/"+month+"/"+day+" "+time;
        if(time.indexOf(":") == -1 ){
        	finalStartDt=year+"/"+month+"/"+day;
        }
        return new Date(finalStartDt).getTime();
    }else{
        return '';
    }
}
function stripCKEDITOR(html) {
    var tmp = document.createElement("div");
    tmp.innerHTML = html;

    if (tmp.textContent == '' && typeof tmp.innerText == 'undefined') {
        return '0';
    }
    return tmp.textContent || tmp.innerText;
}
function replaceQuotes(quotedata){
    return quotedata;//.replace(/â€˜/g,'&#0145;').replace(/â€™/g,'&#0146;').replace(/â€œ/g,'&#0147;').replace(/â€�/g,'&#0148;').replace(/'/g,'&#39;').replace(/"/g,'&#34;').replace(/Â¨/g,'&#168;').replace(/Â´/g,'&#180;').replace(/`/g,'&#96;').replace(/â€¢/g,'&#8226;').replace(/â€”/g,'&#8212;').replace(/=/g,'&#61;').replace(/-/g,'&#45;').replace(/\+/g,'&#43;').replace(/\r/g,'&#x9;').replace(/\\/g,'&#92;');
}

function reverseReplaceLineBreaks(quotedata){
    return quotedata;//.replace(/&#xa;/g,' ').replace(/&#x9;/g,' ').replace(/&#xa;/g,' ');
}
function reverseReplaceQuotes(quotedata){
    return quotedata.replace(/&#0145;/g,'â€˜').replace(/&#0146;/g,'â€™').replace(/&#0147;/g,'â€œ').replace(/&#0148;/g,'â€�').replace(/&#39;/g,"'").replace(/&#34;/g,'"').replace(/&#168;/g,'Â¨').replace(/&#180;/g,'Â´').replace(/&#96;/g,'`').replace(/&#8226;/g,'â€¢').replace(/&#8212;/g,'â€”').replace(/&#61;/g,'=').replace(/&#45;/g,'-').replace(/&#43;/g,'+').replace(/&#92;/g,'\\');
}
function htmlReplaceQuotes(quotedata){
	return quotedata.replace(/</g, '&lt;').replace(/>/g, '&gt;');
}
function htmlReverseReplaceQuotes(quotedata){
	return quotedata.replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&#xa;/g,' ').replace(/&amp;/g,'&');
}
function htmlNewLineReverseReplaceQuotes(quotedata){
	return quotedata.replace(/&#xa;/g,'\n');
}



function wordConversionOnMouseOver(ob,rowId){
	var spanId = $(ob).attr('id');
	var value = $(ob).html().replace(/\,/g,"");

    if(value !='' && !isNaN(value)){
        $('.popbox').hide();  
		if(spanId.indexOf("startPrice_") > -1){			
			$('#pop_startPrice_'+rowId).text(IndianConvertionAmountInWord(parseFloat(value)));
			$('#pop_startPrice_'+rowId).show();
			$("#pop_startPrice_"+rowId).offset({left:tempX+5,top:tempY+10});
		}else if(spanId.indexOf("h1l1Amount_") > -1){			
			$('#pop_h1l1Amount_'+rowId).text(IndianConvertionAmountInWord(parseFloat(value)));
			$('#pop_h1l1Amount_'+rowId).show();
			$("#pop_h1l1Amount_"+rowId).offset({left:tempX+5,top:tempY+10});
		}
    }
}

function hideWordConversion(){
	 $('.popbox').hide();
}

function replaceWithBR(textdata){
    return textdata.replace(/\r?\n/g, '<br />');;
}

function convertDateStringFormate(dateVal,from,to){
	var returnVal = dateVal;
	try{
		if(dateVal != undefined && dateVal != ""){
			if(from == "dd/MM/yyyy HH:mm"){
				if(dateVal.indexOf(" ") != -1){
					var val = dateVal.split(" ");
					dateVal = val[0].split("/").reverse().join("-") + " "+val[1];
				}else{
					dateVal = dateVal.split("/").reverse().join("-");
				}
			}
			var dateTd = new Date(dateVal);
			var hour = ('0'+dateTd.getHours()).slice(-2);
			var mins = ('0'+dateTd.getMinutes()).slice(-2);
		
			if(to == "yyyy-mm-dd HH:mm"){
				returnVal = dateTd.getFullYear()+ '-' + (dateTd.getMonth() + 1) + '-' +  dateTd.getDate()+' '+hour+':'+mins;
			}
			if(to == "dd/MM/yyyy HH:mm"){
				returnVal = dateTd.getDate()+ '/' + (dateTd.getMonth() + 1) + '/' +  dateTd.getFullYear()+' '+hour+':'+mins;
			}
			if(to == "dd-MMM-yyyy HH:mm"){
				
				var cal_months_names = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
				returnVal = dateTd.getDate()+ '-' + cal_months_names[dateTd.getMonth()] + '-' +  dateTd.getFullYear()+' '+hour+':'+mins;
			}
		}
	}catch(e){
		console.log(e);
	}
	return returnVal; 
}
//var end = new Date('02/19/2017 10:1 AM');

var _second = 1000;
var _minute = _second * 60;
var _hour = _minute * 60;
var _day = _hour * 24;
var timer;

var showRemaining = function(endDate,msgAppended,timeOverMsg) {
    var now = new Date();
    var distance = endDate - now;
    if (distance < 0) {

        clearInterval(timer);
        if(timeOverMsg == undefined || timeOverMsg == null){
        	timeOverMsg = "Time over.";
        }
        document.getElementById('countdown').innerHTML = timeOverMsg;

        return;
    }
    var days = Math.floor(distance / _day);
    var hours = Math.floor((distance % _day) / _hour);
    var minutes = Math.floor((distance % _hour) / _minute);
    var seconds = Math.floor((distance % _minute) / _second);
    if(msgAppended == undefined || msgAppended == null){
    	msgAppended = "";
    }
    document.getElementById('countdown').innerHTML = msgAppended +" " +days + 'days ';
    document.getElementById('countdown').innerHTML += hours + 'hrs ';
    document.getElementById('countdown').innerHTML += minutes + 'mins ';
    document.getElementById('countdown').innerHTML += seconds + 'secs';
}
var blockUI = function(msg){
	if(msg == undefined){
		msg = "Please Wait...";
	}
	try{
    	$.blockUI({message: '<h4>'+msg+'</h4>'});
	}catch(e){
		
	}
}
var unBlockUI = function(){
	try{
		$.unblockUI({});
	}catch(err){
		
	}
}
var setValidationMsg = function(comp,compId,msg){
	$(comp).parent().append("<div class='err"+compId+" validationMsg clearfix'>" + msg + "</div>");
}
