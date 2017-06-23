<!DOCTYPE html>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/DoctorMenu.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script src="${pageContext.servletContext.contextPath}/resources/hospital/js/Document.js"></script>

<section id="content-wrapper">
 
<div class="site-content-title">
<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">Clinical</h2></div>
<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>
</div>
<form id="patientPriscriptionForm" action="${pageContext.servletContext.contextPath}/domestic/doctor/saveClinical/${patient[0][8]}" method="post">
<div class="content">
<div class="row">
<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div style="background: #f9e7f9; border: 1px dashed #c02c40; padding: 10px; box-sizing: border-box; margin-bottom: 25px;">
<div class="row">
<div class="col-xl-2 col-xs-12">
<div class="field-set-box2">
<label>Patient CR No. <span class="cm-field">*</span> :</label>
<label class="disbl">${patient[0][0]}</label>
</div>
</div>
<div class="col-xl-2 col-xs-12">
<div class="field-set-box2">
<label>First Name <span class="cm-field">*</span> :</label>
<label class="disbl">${patient[0][1]}</span></label>
</div>
</div>

<div class="col-xl-2 col-xs-12">
<div class="field-set-box2">
<label>Last Name <span class="cm-field">*</span> :</label>
<label class="disbl">${patient[0][2]}</label>
</div>
</div>

<div class="col-xl-2 col-xs-12">
<div class="field-set-box2">
<label>Age <span class="cm-field"></span> :</label>
<label class="disbl">${patient[0][3]}</label>
</div>
</div>

<div class="col-xl-2 col-xs-12">
<div class="field-set-box2">
<label>Gender <span class="cm-field"></span> :</label>
<label class="disbl">${patient[0][4]}</label>
</div>
</div>

<div class="col-xl-2 col-xs-12">
<div class="field-set-box2">
<label>Mob.No. <span class="cm-field"></span> :</label>
<label class="disbl">${patient[0][5]}-${patient[0][6]}</label>
</div>
</div>

<div class="col-xl-3 col-xs-12">
<div class="field-set-box2">
<label>Consulting Docor <span class="cm-field">*</span> :</label>
<label class="disbl">${patient[0][7]}</label>
</div>
</div>
     
      
</div>
</div>

<div class="clear"></div>

</div>




<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="tab-content">
<div class="tab-pane active" id="inverse-tab-output" role="tabpanel">
<div class="des-card">
<div class="nav-tab-pills-image">

<ul role="tablist" class="nav nav-tabs">

<li class="nav-item">
<a role="tab" href="#home8" data-toggle="tab" class="nav-link active" aria-expanded="true">
<i class="fa fa-history icon icon_house" aria-hidden="true"></i>
Patient History
</a>
</li>

<li class="nav-item">
<a role="tab" href="#profile8" data-toggle="tab" class="nav-link" aria-expanded="false">
<i class="fa fa-database icon icon_profile" aria-hidden="true"></i>
Patient Clinical Data
</a>
</li>

<li class="nav-item">
<a role="tab" data-toggle="modal" data-target="#pr-pop" class="nav-link" aria-expanded="false" onclick="viewPrecription(${patient[0][8]})">
<i class="fa fa-file-text icon icon_cog" aria-hidden="true"></i>
Prescription
</a>
</li>
</ul>

<!-- Modal -->
<div id="pr-pop" class="modal fade" role="dialog">
  <div class="modal-dialog mdl-dialog" style="max-width: 1000px;">
    <div class="modal-content">
      <div class="modal-header">
      	<a class="prt-button" onclick="exportContent('prescrition', 'prescrition_${patient[0][8]}', 5)"	value="Print">
        <span>
                                    <i class="fa fa-print" aria-hidden="true"></i>
                                    Print
                                </span>
                            </a>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <div class="modal-body">
        <div id="prescrition"></div>
      </div>      
    </div>
  </div>
</div>

<div class="divider15"></div>
<div class="tab-content">

<div role="tabpanel" id="home8" class="tab-pane active" aria-expanded="true">
<div class="pills-height">
<div class="ps-container ps-theme-default" data-ps-id="6e153d5d-6a7a-80d6-184e-8c13a683353d">

<div style="border: 1px dashed #c02c40; box-sizing: border-box; margin-bottom: 25px; padding: 10px;">

<div class="row">

<div class="col-xl-2 col-lg-2 col-md-2 col-sm-12 col-xs-12">
<div class="field-set-box2">
<label style="margin-top: 15px;">Brief History :</label>
</div>
</div>

<div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 col-xs-12">
<div class="field-set-box">
<a href="#" class="upld" data-toggle="modal" data-target="#upldp">Upload Document</a>
<!-- <a href="#" class="view-upld" id="vw">View Document</a> -->
<div id="upldp" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h5 class="modal-title">Upload Document</h5>
      </div>
      <div class="modal-body">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<label>Title</label>
<div class="form-group">
<input class="form-control" id="txtDocDesc" value="" name="txtDocDesc" type="text">
</div>
</div>
</div>
<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<label>Multiple file upload <span style="color: red;">(PDF, JPG, JPEG, PNG)</span> of size <span style="color: red;">less than 2MB</span></label>
<div class="form-group">
<input class="form-control" value="" id="fileToUpload" name="fileToUpload" type="file">
</div>
</div>
</div>
<input type="hidden" id="txtobjectId" value="${objectId}">
<input type="hidden" id="txtChildId" value="${childId}">
<input type="hidden" id="txtSubChildId" value="${subChildId}">
<input type="hidden" id="txtOtherSubChildId" value="${otherSubChildId}">


        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal"  onclick="return ajaxFileUpload();">Upload</button>
      </div>
    </div>

  </div>
</div>
</div>
</div>

<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="view-document">
<div class="basic_table table-responsive" id="vwdoc">
<!-- <table class="table table-bordered">
<thead>
<tr>
<th>Sr No.</th>
<th>Title</th>
<th></th>
</tr>
</thead>
<tbody>
<tr>
<td>01</td>
<td>My Uploded Documents</td>
<td>
<span class="tag square-tag tag-success"><i class="fa fa-download" aria-hidden="true"></i> Download</span>
</td>
</tr>
</tbody>
</table> -->
</div>
</div>
</div>

<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<textarea class="form-control" style="min-height: 200px;" name="txthistory">${clinicalDetail[0].history} </textarea>
</div>
</div>

<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<label>Comments :</label>
<div class="form-group">
<textarea class="form-control" name="txtcomments"> ${clinicalDetail[0].comments}</textarea>
</div>
</div>
</div>

<div class="clear"></div>

</div>

</div>

<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;"><div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px;"><div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
</div>
</div>

<div role="tabpanel" id="profile8" class="tab-pane" aria-expanded="false">
<div class="pills-height">
<div class="ps-container ps-theme-default" data-ps-id="c8508f38-b2d0-d417-9f24-4b42e45f7672">

<div style="border: 1px dashed #c02c40; box-sizing: border-box; margin-bottom: 25px; padding: 10px;">

<div class="row">

<!-- <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<label>Observations :</label>
<textarea class="form-control" style="min-height: 200px;"></textarea>
</div>
</div> -->
<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-4">
<div class="field-set-box">
<label>Complaints:</label>
<!-- <textarea class="form-control" style="min-height: 200px;"></textarea> -->
<div class="scr">
  <c:forEach items="${complaints}" var="complain">
  	<c:choose>
  		<c:when test="${fn:contains(complain.value, 'checked')}">
  			<c:set value="${fn:split(complain.value, '_')}" var="chkValue"/>
  			<c:set value=" ${chkValue[0]}" var="checkedVal"/>
  			<input type="checkbox" checked="checked" id="complain" name="chkcomplain" value="${complain.key}"/> ${checkedVal} <br />
  		</c:when>
  		<c:otherwise>
  			<c:set value="${fn:split(complain.value, '_')}" var="chkValue"/>
  			<c:set value=" ${chkValue[0]}" var="checkedVal"/>
  			<input type="checkbox"  id="complain" name="chkcomplain" value="${complain.key}"/> ${checkedVal} <br />
  		</c:otherwise>
  	</c:choose>
  </c:forEach>
</div>
</div>
</div>
<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-4">
<div class="field-set-box">
<label>Medicine:</label>
<!-- <textarea class="form-control" style="min-height: 200px;"></textarea> -->
<div class="scr">
  <c:forEach items="${medicien}" var="medicien">
  <c:choose>
  <c:when test="${fn:contains(medicien.value, 'checked')}">
    <c:set value="${fn:split(medicien.value, '_')}" var="chkValue"/>
  			<c:set value=" ${chkValue[0]}" var="checkedVal"/>
  			<input type="checkbox" checked="checked"  id="complain" name="chkmedicien" value="${medicien.key}"/> ${checkedVal} <br />
  </c:when>
  <c:otherwise>
   <c:set value="${fn:split(medicien.value, '_')}" var="chkValue"/>
  			<c:set value=" ${chkValue[0]}" var="checkedVal"/>
  			<input type="checkbox"  id="complain" name="chkmedicien" value="${medicien.key}"/>${checkedVal} <br />
  </c:otherwise>
  </c:choose>
  
  </c:forEach>
</div>
</div>
</div>
<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-4">
<div class="field-set-box">
<label>Report:</label>
<!-- <textarea class="form-control" style="min-height: 200px;"></textarea> -->
<div class="scr">
  <c:forEach items="${report}" var="reportloop">
  <c:choose>
  <c:when test="${fn:contains(reportloop.value, 'checked')}">
     <c:set value="${fn:split(reportloop.value, '_')}" var="chkValue"/>
  			<c:set value=" ${chkValue[0]}" var="checkedVal"/>
  		 <input type="checkbox" checked="checked"  id="complain" name="ctkreport" value="${reportloop.key}"/>${checkedVal}<br />	
  </c:when>
  <c:otherwise>
   <c:set value="${fn:split(reportloop.value, '_')}" var="chkValue"/>
  			<c:set value=" ${chkValue[0]}" var="checkedVal"/>
  		<input type="checkbox" id="complain" name="ctkreport" value="${reportloop.key}"/>${checkedVal}<br />		
  </c:otherwise>
  </c:choose>
  </c:forEach>
</div>
</div>
</div>



<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<label>Remark :</label>
<div class="form-group">
<textarea class="form-control" name="txtremark">${clinicalDetail[0].remark}</textarea>

</div>
</div>
</div>
  
</div>
<input type="hidden" name="hdclinicalDetailid" value="${clinicalDetail[0].clinical_id}">
<div class="clear"></div>
</div>

<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;"><div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px;"><div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
</div>
</div>
<div role="tabpanel" id="settings8" class="tab-pane" aria-expanded="false">
<div class="pills-height">
<div class="ps-container ps-theme-default" data-ps-id="d841d3df-a669-4072-6c8f-d67b9684ce42">
<div style="border: 1px dashed #c02c40; box-sizing: border-box; margin-bottom: 25px; padding: 10px;">
<div class="row">

<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
<div class="field-set-box">
<label>Type Prescription :</label>
<textarea class="form-control" style="min-height: 200px;"></textarea>
</div>
</div>

<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
   
</div>
<!-- <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
</div> -->
</div>

<div class="clear"></div>

</div>

<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
<div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div>
</div>
<div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px;"><div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="tab-pane pre-code" id="inverse-tab-code" role="tabpanel">
<div class="always-visible ps-container ps-theme-default" data-plugin="custom-scroll" data-min="300" data-usebothwheelaxes="true" data-height="190" data-minscrollbarlength="true" data-wheelspeed="0.1" style="height: 190px;" data-ps-id="f4356bd4-9fe3-7a8f-2672-b60f89ffb2ff">
<div style="min-width: 300px; width: 100%;">
<pre>&lt;div class="nav-tab-pills-image"&gt;
    &lt;ul role="tablist" class="<b>nav nav-tabs</b>"&gt;
        &lt;li class="nav-item"&gt;
            &lt;a role="tab" href="<b>#home8</b>" data-toggle="tab" class="nav-link active"&gt;
                &lt;i class="icon icon_house_alt"&gt;&lt;/i&gt;Tab 1
            &lt;/a&gt;
        &lt;/li&gt;
    &lt;/ul&gt;
    &lt;div class="divider15"&gt;&lt;/div&gt;
    &lt;div class="tab-content"&gt;
        &lt;div role="tabpanel" id="<b>home8</b>" class="tab-pane active"&gt;

            &lt;div class="pills-height"&gt;
                &lt;div data-height="105" data-plugin="custom-scroll" style="height: 150px;" class="ps-container ps-theme-default ps-active-y" data-ps-id="5edeb2f7-9e1f-7ee7-3de9-f24b4c579c4e"&gt;
                    &lt;p&gt;Content here....
                    &lt;/p&gt;
                &lt;/div&gt;
            &lt;/div&gt;
        &lt;/div&gt;
    &lt;/div&gt;
&lt;/div&gt;
                                                    </pre>
</div>
<div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;"><div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps-scrollbar-y-rail" style="top: 0px; right: 0px;"><div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 0px;"></div></div></div>
</div>
</div>
</div>
<div class="clear"></div>
</div>
</div>
<div class="row">
<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
<button type="button" onclick="submitForm()" class="btn btn-primary sv btn-icon-hover fa fa-floppy-o">
<span>Save</span></button>
</div>
<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
<button class="btn btn-primary cn btn-icon-hover fa fa-ban">
<span>Cancel</span></button>
</div>
</div>
</form>
</section>

</div>		
</section>

<script
	src="${pageContext.servletContext.contextPath}/resources/hospital/js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var objectId = $('#txtobjectId').val();
	var childId = $('#txtChildId').val();
	var subChildId = $('#txtSubChildId').val();
	var otherSubChildId = $('#txtOtherSubChildId').val();
	getDocDetails();
});

function submitForm() {
	var vbool = valOnSubmit();
	if(vbool){
		$("#patientPriscriptionForm").submit();
	}
}
function viewPrecription(patientid) {
	$.ajax({
		type: "GET",
		url: "${pageContext.servletContext.contextPath}/domestic/doctor/ViewPrescription/"+patientid,
		success: function success(result){
			$("#prescrition").html("");
 			$("#prescrition").html(result);
 			$("#prescrition").dialog("open");     
	}
	});	
}
</script>
<%@include file="../includes/footer.jsp"%> 


