<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<table class="table table-bordered">
						<thead>
							<tr>

								<th>Sr No</th>
								<th>Medicine Name</th>
								<th></th>

							</tr>
						</thead>
						<tbody>


							<c:forEach items="${medicine}" var="medi" varStatus="cnt">
								<tr>
									<td>${cnt.count}</td>
									<td>${medi.medicine_name}</td>
									<td><button type="button" class="dlt" data-toggle="modal" data-target="#bordermodal${medi.medicine_id}"><i class="fa fa-trash" aria-hidden="true"></i></button>
										<div class="modal fade border-modal"
											id="bordermodal${medi.medicine_id}" tabindex="-1"
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
														<div>Are You sure Delete Medicine
															${medi.medicine_name}?</div>
														<button type="button" class="btn btn-danger"
															data-dismiss="modal" onclick="#">Cancel</button>
														<button type="button" class="btn btn-success"
															onclick="deleteMedicine(${medi.medicine_id})">Ok</button>
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

