function specialTrim(str) {
	            return str.replace(/>\s+</g, '><');
	        } 
	         function fileValidate(objectid){
		       	 $(".successMsg").hide();
		            $('.err').remove();
		            $('#docDescError').html('');
		   	     	$('#fileError').html("");
		   	     	$('#docCheckListError').html("");
		            var valid = false;
		            var doValidate = true;
		            var count = 0;
		            var maxSize = parseInt('${allowedSize}')*1024;
		            var validExt = '${allowedExt}'.replace(/\*./g,'');
		            var browserName="";
		            var fileName = "";
		            var actSize = 0;
		            jQuery.each(jQuery.browser, function(i, val) {
		                browserName+=i;
		            });
		            if(objectid == -1){
		            	$("#txtDocDesc").val("AdminUser");
	                }
		            $(":input[type='file']").each(function(){
		                if(this.value == ''){
		                    $('#fileError').parent().append("<div class='err validationMsg' style='color:red; '><span style='display:inline-block;'><spring:message code='msg_tender_filetoupload_empty' /></span></div>");
		                    count++;
		                }
		               
		                if($("#txtDocDesc").val()==''){
		               	 $('.errtxtDocDesc').remove();
		               	 $("#docDescError").html("<div class='errtxtDocDesc validationMsg' style='color:red;'><spring:message code='msg_tender_docbrief_empty' /></div>");
		               	 count++;
		                }else if(!rgx_brief.test($("#txtDocDesc").val())){
		               	 $('.errtxtDocDesc').remove();
		               	 $("#docDescError").html("<div class='errtxtDocDesc' style='color:red;'><spring:message code='msg_tender_invalidDocBrief' /></div>");
		               	 count++;
		                }
	                	var fileNameArr=this.value.split('\\');
	                	$("#txtDocDtls").val(fileNameArr[fileNameArr.length -1]+""+$("#txtDocDesc").val()+""+$("#currentTime").val());
		                
		            });
		            
		            if(count > 0){
		                valid = false;
		            }else{
		                valid = true;
		            }
		            return valid;
		        }
	         function ajaxFileUpload(){
	        	
		            var fileName=$('input[type=file]').val().split('\\').pop();
		            var fbool = fileValidate($('#txtobjectId').val());
		            if(fbool){
		    	        $('#docDescError').html('');
		    	        $('#fileError').html("");
		    	        var url = contextPath+'/ajax/submitfileupload?txtDocDesc='+$("#txtDocDesc").val()+'&txtobjectId='+$('#txtobjectId').val()+'&txtChildId='+$('#txtChildId').val()+'&txtSubChildId='+$('#txtSubChildId').val()+'&txtOtherSubChildId='+$('#txtOtherSubChildId').val();
		    	        
		    	        $.ajaxFileUpload({
		    	            url:url,
		    	            type:"POST",
		    	            fileElementId:'fileToUpload',
		    	            dataType: "text",
		    	            secureuri:true,
		    	            success: function (data){
		    	                var index=data.toString().indexOf("Error:");
		    	                 if( index < 0){
		    	                    var strRemove="&nbsp;&nbsp;<a href='javascript:' onclick=\"removeFile('"+$.trim(data.toString())+"');\">Remove</a>";
		    	                    if($('#txtHidDocIds').val() != '')
		    	                        $('#txtHidDocIds').val($('#txtHidDocIds').val()+",");
	                                $('#fileToUpload').val('');
		    	                    $("#txtDocDesc").val('');
		    	                    $("#fileCount").val(parseInt($("#fileCount").val(),10) + 1);
		    	                    
	 	 			   	            	jAlert("Document Uploaded successfully",function () {});
	 	 		                	
		    	                    getDocDetails();
		    	                }else{
		    	                	 if(data.toString().indexOf("sessionexpired") < 0){
	                                   	$('#fileToUpload').val('');
	                                    $("#txtDocDesc").val('');
		    	                    	$('#fileError').html('<span style="display:inline-block;" class="validationMsg">'+data.toString().substr(index+6,data.toString().length)+'</span>');
		    	                	 }else{
		    	                		 window.location.replace(contextPath+"/sessionexpired");
		    	                	 }
		    	                }
		    	            },
		    	            error: function (data, status, e){
	                                alert(e);
		    	            }
		    	        });
		    	      }else{
		            	return false;
		    	     }
		        }
	         function checkFile(obj){
		        	if($(obj).val()!=""){
		        		$(".err").remove();	
		        		$("#fileError").html("");
//		        		$("#fileToUploadName").val($(obj).val());
		        	}
		        } 
	         
	         function getDocDetails(){
	              $.post(contextPath+"/ajax/getuploadeddocs", {
	            	 objectId : $('#txtobjectId').val(),
	            	 childId : $('#txtChildId').val(),
	            	 subChildId : $('#txtSubChildId').val(),
	            	 otherSubChildId : $('#txtOtherSubChildId').val()
	            },
	            function(j)
	            {
	            	if (j == 'sessionexpired') {
	                    window.location = contextPath+"/" + j;
	                } else {
	                	$("#vwdoc").html("");
	                	if(j == undefined  || j == ""){
	                		j = [];
	                	}
	                	var obj = jQuery.parseJSON(j.toString());
	                		if(obj.length>0){
		                	    for(var i=0;i<obj.length;i++)
		                	    {
		                	    	var strRemove="&nbsp;&nbsp;<a href='javascript:' onclick=\"removeFile('"+obj[i]["DocId"]+"','"+obj[i]["cStatus"]+"');\">Remove</a>";
		                	    	var strCancel="&nbsp;&nbsp;<a href='javascript:' onclick=\"cancelFile('"+obj[i]["DocId"]+"','"+obj[i]["cStatus"]+"');\"> Cancel </a>";
		                	    	var docId = obj[i]["DocId"];
		                	    	var cStatus=obj[i]["cStatus"];
		                	    	var status='';
		                	    	if(cStatus==1){
		                	    		status='Approved';
		                	    	}else if(cStatus==0){
		                	    		status='Pending';
		                	    	}else{
		                	    		status='Cancelled';
		                	    	}
		                	    	var strDownload="&nbsp;&nbsp;<a href="+contextPath+"/ajax/downloadbriefcasefile/"+docId+">Download</a>";
		                	    		
		                	        var tr="<tr id='vwdocId' DocId='"+docId+"'>";
		                	        var td0="<td>"+obj[i]["Sr.No"]+"</td>";
		                	       
		                	        var td2="<td>"+obj[i]["fileName"]+"</td>";
		                	        if(cStatus==1){
		                	        	var td7="<td>";
		                	        	if(objectId==1){
		                	        		td7=td7+strCancel+"|";	
		                	        	}
		                	        	td7=td7+strDownload+"</td></tr>";
		                	    	}else if(cStatus==0){
		                	    		var td7="<td>"+strRemove+"|"+strDownload+"</td></tr>";
		                	    	}else{
		                	    		var td7="<td>"+strDownload+"</td></tr>";
		                	    	}
		                	        if(i==0){
		                	        	$("#vwdoc").append("<table id='doctableId' class='table table-bordered'><tr><th>Sr No.</th><th>File Name</th><th></th></tr>");
		                	        }
		                	       $("#doctableId").append(tr+td0+td2+td7);
		                	    }
		                	    $("#vwdoc").append("</table>");
	                	    }else{
	                	    	$("#vwdoc").append("<table class='table table-bordered'>");
	                	    	$("#vwdoc").append("<tr><td colspan=\"4\">No documents found</td></tr>");
	                	    	$("#vwdoc").append("</table>");
	                	    }  
	                		
	                }
	            }); 
	        }
	        
	         
		        function removeFile(obj,cStatusDoc){
		        
		        
		        	var objectId=$('#txtobjectId').val();
//		        	 jConfirm('<spring:message code="msg_tender_cnfrm_deletedoc"/>','<spring:message code="lbl_document" />',function (result) {
		        	jConfirm("Are you sure you want delete Document?","Document",function (result) { 
		  				if(result){
		  					 $(".successMsg").hide();
		  		   	          $.post(contextPath+"/ajax/deletebriefcasefile", {
		  		   	            docId : obj,
		  		   	            objectId : objectId,
		  	 	   	            cStatusDoc : cStatusDoc 
		  		   	          },
		 	 		   	      	function(j)
		 	 		   	        {
		 	 		   	            if (j == 'sessionexpired') {
		 	 		                    window.location = contextPath+"/" + j;
		 	 		                } else {
		 	 			   	            if($.trim(j.toString()) == 'true')
		 	 			   	            {
		 	 			   	            	jAlert("Document deleted successfully",function () {});
		 	 		                	} 
		 	 			   	         	getDocDetails();
		 	 		                }
		 	 		   	       
		 	 		             });
		  					}
		              	}); 	
		       }
		        function cancelFile(obj,cStatusDoc){
	           	 	var objectId= '${objectId}';
//	 	            if(confirm('<spring:message code="msg_tender_cnfrm_deletedoc" />')){
		   	    	 $(".successMsg").hide();
		   	          $.post(contextPath+"/ajax/canceldocument", {
		   	            docId : obj,
		   	            objectId : objectId,
		   	            cStatusDoc : cStatusDoc
		   	        },
		   	        function(j)
		   	        {
		   	            if (j == 'sessionexpired') {
		                    window.location = contextPath+"/" + j;
		                } else {
			   	            if($.trim(j.toString()) == 'true')
			   	            {
			   	                $("#successDiv").show();
			   	                $('#successDiv').html('<spring:message code="msg_tender_cancel_successfully" />');
			   	            }
			   	         	/*getDocDetails();*/
		                }
		   	        }); 
//	 	             }
		       }
		        function downloadFile(obj){
	           	 	var objectId = '${objectId}';
		   	    	 $(".successMsg").hide();
		   	    	  $.ajax({
		   	    	 	url : contextPath+"/ajax/downloadbriefcasefile/"+obj+"/"+objectId,
		   	    	    type : "GET",
		   	    	    success : function(data) {
		   	    	      if (data == "success") {
		   	    	        alert('request sent!');
		   	    	      }
		   	    	    }
		   	    	  });
		       }