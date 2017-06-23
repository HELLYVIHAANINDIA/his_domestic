<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function deleteComplaints(complaintsId) {
	 $.ajax({
		type: "POST",
		url: contextPath+"/domestic/complaints/deleteComplaints/"+complaintsId,
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
			<h2 class="float-xs-left content-title-main">Complaints</h2>
		</div>
		<div class="row">

			<div class="col-xs-12">
				<div class="basic_table table-responsive">

					<table class="table table-bordered">
						<thead>
							<tr>

								<th>Sr No</th>
								<th>Complaints Name</th>
								<th></th>

							</tr>
						</thead>
						<tbody>


							<c:forEach items="${complaints}" var="comp" varStatus="cnt">
								<tr>
									<td>${cnt.count}</td>
									<td>${comp.complaintsname}</td>
									<td><button type="button" data-toggle="modal"
											data-target="#bordermodal${comp.complaintsid}">Delete</button>
										<div class="modal fade border-modal"
											id="bordermodal${comp.complaintsid}" tabindex="-1"
											role="dialog" aria-labelledby="bordermodal"
											aria-hidden="true">
											<div class="modal-dialog" role="document">
												<div class="modal-content">
													<div class="modal-body">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>

														<h3>User</h3>
														<div>Are You sure Delete Complaints Name
															${comp.complaintsname}?</div>
														<button type="button" class="btn btn-danger"
															data-dismiss="modal" onclick="#">Cancel</button>
														<button type="button" class="btn btn-success"
															onclick="deleteComplaints(${comp.complaintsid})">Ok</button>
													</div>
												</div>
											</div>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>

		</div>

	</section>
</div>
<%@include file="../includes/footer.jsp"%> 

