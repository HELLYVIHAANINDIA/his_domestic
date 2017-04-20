var fromDateFormate = "";
function loadListPage(divId,listingId,formId){
	setJsonSearchCriteria(formId);
	if(formId != undefined){
		var searchfrm = $("#"+formId);
		var dataAttr = searchfrm.serialize();
	}
	$.ajax({
		 url: "/eProcurement/etender/commonListPage/"+listingId, 
		 datatype:'post',
		 data:dataAttr,
		 success: function(result){
                    
	        $("#"+divId).html(result);
	        loadDataTable(divId)
	    }
	 });
}

function setJsonSearchCriteria(formId){
	var equalArray="";
	var inArray="";
	var betweenDateArray="";
	var likeArray="";
	var finalVal ={};
	
	//this is for input type text
	$('.searchEqual').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			var value = formateVal($(this),$(this).val());
			equalArray += $(this).attr('columnName')+"='"+value.replace(/'/g, "''") +"'" + "~";
		}
	});
	
	$('.searchNotEqual').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			var value = formateVal($(this),$(this).val());
			equalArray += $(this).attr('columnName')+"<>'"+value.replace(/'/g, "''") +"'" + "~";
		}
	});
	$('.searchLessThen').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			var value = formateVal($(this),$(this).val());
			equalArray += $(this).attr('columnName')+"<'"+value.replace(/'/g, "''") +"'" + "~";
		}
	});
	$('.searchLessThenEqual').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			var value = formateVal($(this),$(this).val());
			equalArray += $(this).attr('columnName')+"<='"+value.replace(/'/g, "''") +"'" + "~";
		}
	});
	$('.searchGreaterThen').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			var value = formateVal($(this),$(this).val());
			equalArray += $(this).attr('columnName')+">'"+value.replace(/'/g, "''") +"'" + "~";
		}
	});

	$('.searchGreaterThenEqual').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			var value = formateVal($(this),$(this).val());
			equalArray += $(this).attr('columnName')+">='"+value.replace(/'/g, "''") +"'" + "~";
		}
	});
	$('.searchLike').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			var value = formateVal($(this),$(this).val());
			likeArray += $(this).attr('columnName')+" like '%"+value.replace(/'/g, "''") +"%'" + "~";
		}
	});
	
	$('.searchIn').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null  && $(this).val() != ","){
			var value = formateVal($(this),$(this).val());
			//var value = $(this).val()+"";
			inArray += $(this).attr('columnName')+" in ('"+ value.replace(/'/g, "''").replace(/\,/g,"','") +"')" + "~";
		}
	});
	
	$('.searchBetweenDate').each(function(){
		var between1 = $(this).find('.searchBetween1').val();
		var between2 = $(this).find('.searchBetween2').val();
		
		if(between1 != "" && between1 != undefined && between1 != null && between2 != "" && between2 != undefined && between2 != null ){
			if(between1.indexOf(":") != -1){
				between1 = formateVal($(this),between1);
				between2 = formateVal($(this),between2);
				betweenDateArray += $(this).attr('columnName')+" between '"+ between1 +"' and '"+between2+"' " + "~";
			}else{
				betweenDateArray += $(this).attr('columnName')+" between '"+ between1 +" 00:00:00:00' and '"+between2+" 23:59:59:998' " + "~";
			}
		}
	});
	
	$('.searchRange').each(function(){
		var between1 = $(this).find('.searchBetween1').val();
		var between2 = $(this).find('.searchBetween2').val();
		
		if(between1 != "" && between1 != undefined && between1 != null && between2 != "" && between2 != undefined && between2 != null ){
			betweenDateArray += $(this).attr('columnName')+" between "+ between1 +" and "+between2 + "~";
		}
	});
	
	$('.searchRadio').each(function(){
		var coumnName = $(this).attr('columnName');
		var radioValue = "";
		
		$(this).find('.searchRadioValue').each(function(){
			if($(this).val() != undefined && $(this).val() != ""){
				radioValue = $(this).val().replace(/'/g, "''");
			}
		});
		
		if(radioValue != ""){
			equalArray += coumnName+"='"+ radioValue +"'" + "~";
		}
	});
	
	$('.searchRadioButton').each(function(){
		var coumnName = $(this).attr('columnName');
		var radioValue = "";
		
		$(this).find('.searchRadioButtonValue').each(function(){
			if($(this).val() != undefined && $(this).val() != ""){
				radioValue = $(this).val().replace(/'/g, "''");
			}
		});
		
		if(radioValue != ""){
			equalArray += coumnName + "='"+ radioValue +"'" + "~";
		}
	});
	
	$('.searchCheckBox').each(function(){
		var coumnName = $(this).attr('columnName');
		var checkboxValuearray = "";
		
		$(this).find('.searchCheckBoxValue').each(function(){
			if($(this).is(":checked") == true){
				checkboxValuearray += "'"+ $(this).val().replace(/'/g, "''") +"',";
				
			}
		});
		
		if(checkboxValuearray != ""){
			inArray += coumnName+" in ("+ checkboxValuearray.substring(0,checkboxValuearray.length-1) +")" + "~";	
		}
	});
	
	$('.searchCheckBoxButton').each(function(){
		var coumnName = $(this).attr('columnName');
		var checkboxValuearray = "";
	
		$(this).find('.searchCheckBoxButtonValue').each(function(){
			if($(this).val() != undefined && $(this).val() != ""){
				checkboxValuearray += "'"+ $(this).val().replace(/'/g, "''") +"',";
			}
		});
		
		if(checkboxValuearray != ""){
			inArray += coumnName+" in ("+ checkboxValuearray.substring(0,checkboxValuearray.length-1) +")" + "~";	
		}
	});
	
	$('.searchNot').each(function(){
		if($(this).val() != "" && $(this).val() != undefined && $(this).val() != null ){
			equalArray += $(this).attr('columnName')+"<>'"+$(this).val().replace(/'/g, "''") +"'" + "~";
		}
	});
	
	finalVal = {
		"equalArray":equalArray,
		"betweenDateArray":betweenDateArray,
		"inArray":inArray,
		"likeArray":likeArray
	};
	if($("#jsonSearchCriteria").val() == undefined){
		$("#"+formId).append("<input type='hidden' id='jsonSearchCriteria' name='jsonSearchCriteria'> ");
	}
	$("#jsonSearchCriteria").val(JSON.stringify(finalVal));
}


function loadDataTable(divId){
var dateCol = new Array(); 
$("th[coldisplayname*='Date']").each(function(){
	dateCol.push($(this).parent().children().index($(this)));
});
var srnocol = getColumnIndex("srno");
var resultLength = 10;
var defaultOrder = $("#defaultOrder").val();
var orderColIndx = "0";
var orderType = "";
if(defaultOrder != "" && defaultOrder != undefined && defaultOrder.indexOf(":") != -1){ // value should be 5:desc like, 5 means index
	orderColIndx = defaultOrder.split(":")[0];
	orderType = defaultOrder.split(":")[1];
}
var pageStartNo = 0;
/*Hemal Start Auction visible only mapped bidders in case of limited auction*/
if(parseInt($('#isAuction').val())===1 && $('#userId').val()!==''){
 
    var from=$('#fromClause').val().split('where');
    from[0]=from[0]+" tbl_tender where ";
    var formClause=from[0]+from[1]+" and "+$('#userId').val() +" = (case when biddingAccess=1 then (select userId from tbl_bidder where userId="+$('#userId').val()+") else (select userId from tbl_tenderbiddermap where tenderId=tbl_tender.tenderId and userId="+$('#userId').val()+") end)";
    $('#fromClause').val(formClause);
}
/*Hemal End */
var $dataTableObj = $("#"+divId).find('#listingTable').DataTable( {
    	"bJQueryUI" : true,
    	"sPaginationType" : "full_numbers",
    	"iDisplayLength": resultLength, 
    	"bProcessing" : true,
    	"lengthMenu" : [[10,20,-1],[10,20,'All']],
    	"searching": true,
    	"bServerSide" : true,
    	"sAjaxSource" : "/eProcurement/etender/commonDataGrid",
    	"aaSorting": [orderColIndx,orderType],
    	 "language": {
    	      "emptyTable": "No record found.",
    	      "search": "_INPUT_",
    	      "searchPlaceholder": "Search"
    	    },
    	    
    	dom: 'Blfrtip',
    	"fnServerParams": function ( aoData ) {
    		 aoData.push({ "name": "actionItem", "value": $('#actionItem').val() },
         			{ "name": "commonAction", "value":$('#commonAction').val() },
         			{ "name": "fromClause", "value": $('#fromClause').val() },
         			{ "name": "isHQL", "value": $('#isHQL').val() },
         			{ "name": "srnoCol", "value": $('#srnoCol').val() },
         			{ "name": "jsonSearchCriteria", "value": $('#jsonSearchCriteria').val()}, 
         			{ "name": "columnName", "value": $("#columnName").val() });
    		 		pageStartNo = aoData[3].value;
    		    
            
       	}, 
    	"fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull,index) {
    		//var loopLen = columnJson.length + additionalColumn.length;
    	 	if($('#commonAction').val() != ""){
    			$('td', nRow).eq(0).html("<input type='checkbox' class='noExport selectIndividualCheckBox' id='selectIndividualCheckBox_"+iDisplayIndex+"'>");
    		}
    	 	if($('#srnoCol').val() == "1"){
    			 $('td', nRow).eq(srnocol).html((pageStartNo+1)+iDisplayIndex);
    			 /*var page = this.fnPagingInfo().iPage;
    		     var length = this.iDisplayLength;
    		     var index = (page * length + (iDisplayIndex +1));
    		     $('td:eq('+srnocol+')', nRow).html(index)*/
    			
    		}
    		//if($('#commonAction').val() != ""){
    	 	if($('#actionItem').val() != ""){
    			var actionItem = $('#actionItem').val();
    	 		var actionSplit = actionItem.split(",");
    	 		$('td', nRow).last().html("");
    	 		for(var actionVar in actionSplit){
        			$('td', nRow).last().append("<div class='label label-info' onclick='callActionItem(this)' style='cursor:pointer' actionname='"+actionSplit[actionVar]+"'>"+actionSplit[actionVar]+"</div>").append("&nbsp;&nbsp;").addClass("noExport");
    	 		}
    			//$('td', nRow).last().html("<input type='checkbox' class='' id='"+iDisplayIndex+"'>");
    		}
    	 	
    	 	$("#"+divId).find("th.hideColumn").each(function(){
    	 	    var col = $(this).parent().children().index($(this));
    	 	   $('td', nRow).eq(col).addClass("hideColumn");
    		});
    	 	for(var indx in dateCol){
    	 		var colIndx = dateCol[indx];
    	 		var tdVal = $('td', nRow).eq(colIndx).html();
                        
    	 		$('td', nRow).eq(colIndx).html(convertDateStringFormate(tdVal,'yyyy-mm-dd HH:mm',CLIENT_DATE_FORMATE));
    	 	}
    	},
    	buttons: [
                  {
                      extend: 'pdf',
                      footer: true,
                      exportOptions: {
                          //columns: [':visible' ]
                              columns: "thead th:not(.noExport)"
                      },
                  		initComplete: function () {
                		$('.buttons-pdf').html('<span class="glyphicon glyphicon-file" data-toggle="tooltip" title="Export To Excel"/>');
                		}
                  },
                  {
                      extend: 'print',
                      footer: true,
                      exportOptions: {
                          columns: "thead th:not(.noExport)"
                      }
                     
                  },
                  {
                      extend: 'excel',
                      footer: false,
                      exportOptions: {    
                          //columns: [':visible' ]
                              columns: "thead th:not(.noExport)"
                      }
                  }         
               ],

    	aoColumnDefs: [
 	       		{
 	       			bSortable: false,		// no sorting in last column
 	       			aTargets: [ -1 ]
 	       		},
 	       		{
 	       			bSortable: false,		// no sorting for first column
 	       			aTargets: [ 0 ]
 	       		}
 	       	]
    } );
	/*$("#"+divId).find("th.hideColumn").each(function(){
 	    var col = $(this).parent().children().index($(this));
		$dataTableObj.column(col).visible(false)
	})*/
/*{
extend: 'csv',
footer: false,
exportOptions: {
    //columns: [':visible' ]
        columns: "thead th:not(.noExport)"
}

},*/
setClickFunctionToDataGrid();
}

function getColumnIndex(columnname){
	var col = -1;
	$("th[coldisplayname='"+columnname+"']").each(function(){
 	    col = $(this).parent().children().index($(this));
	});
	return col;
}

/*function convertDateToClientFormat(tdVal,CLIENT_DATE_FORMATE){
	if(tdVal != undefined && tdVal != "" && CLIENT_DATE_FORMATE == "dd/MM/yyyy HH:mm"){
		var dateTd = new Date(tdVal);
		var hour = ('0'+dateTd.getHours()).slice(-2);
		var mins = ('0'+dateTd.getMinutes()).slice(-2);
		return  dateTd.getDate()+ '/' + (dateTd.getMonth() + 1) + '/' +  dateTd.getFullYear()+' '+hour+':'+mins;
	}else if(tdVal != undefined && tdVal != "" && CLIENT_DATE_FORMATE == "yyyy-mm-dd HH:mm"){
		var dateTd = new Date(tdVal);
		var hour = ('0'+dateTd.getHours()).slice(-2);
		var mins = ('0'+dateTd.getMinutes()).slice(-2);
		return  dateTd.getFullYear()+ '-' + (dateTd.getMonth() + 1) + '-' +  dateTd.getDate()+' '+hour+':'+mins;
	}
}*/
function formateVal(obj,val){
	if($(obj).hasClass("dateBox")){
		val = convertDateStringFormate(val,CLIENT_DATE_FORMATE,"yyyy-mm-dd HH:mm");
	}
	return val;
}
	
