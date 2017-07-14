<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function deleteFinding(findingid) {
	 $.ajax({
		type: "POST",
		url: contextPath+"/domestic/complaints/deleteFinding/"+findingid,
		success: function success(result){
			  $("#masterCompaintsdiv").html("");
 			$("#masterCompaintsdiv").html(result);
	}
	}); 
	
}
</script>

<div id="masterCompaintsdiv">

	<section id="content-wrapper">
	
		<div class="site-content-title">
			<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">Finding</h2></div>
			<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>
		</div>
		
		<div class="content">
			<div class="row">
				<div class="col-sm-12">
									<div class="basic_table table-responsive">
                     
                     <input type="submit" value="Add" data-dismiss="modal" data-toggle="modal" data-target="#Complain">
                     <div class="modal fade" id="Complain" role="dialog"  style="z-index: 90">
												<div class="modal-dialog modal-md">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal">&times;</button>
														</div>
														<div class="modal-body">
															<div class="row">
																<div class="col-xs-12">
																	<label class="lbl-1">Finding Name </label> 
																	
												         	<input type="text" class="form-control dateBoxappointment"
															name="txtfinding"  id="txtfinding"
															title="Finding Name" onblur="validateEmptyDt(this)" value="">
																</div>
															</div>
														</div>
														<div class="modal-footer">
															<button  type="button" class="btn btn-default" data-dismiss="modal" onclick="submitFinding()">Submit</button> 
				
														</div>
													</div>
												</div>
											</div>
                     
					


							<div id="tblmedicine">
							<%@include file="../admin/FindingTable.jsp"%>
							
							</div>

				</div>
				</div>
			</div>
		</div>
	</section>
</div>
<script>
function submitFinding(){
	var finding = $("#txtfinding").val();
	$.ajax({
		type: "POST",
		url: contextPath+"/domestic/user/addFinding/"+finding,
		success: function success(result){
			$("#tblmedicine").html("");
			$("#tblmedicine").html(result);
			 
	}
	}); 
}
</script>


