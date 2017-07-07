<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
									<td><button type="button" class="dlt" data-toggle="modal" data-target="#bordermodal${comp.complaintsid}"><i class="fa fa-trash" aria-hidden="true"></i></button>
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
														<div>Are You sure Delete Complaints
															${comp.complaintsname}?</div>
														<button type="button" class="btn btn-danger"
															data-dismiss="modal" onclick="#">Cancel</button>
														<button type="button" class="btn btn-success"
															onclick="deleteComplaints(${comp.complaintsid})">Ok</button>
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

