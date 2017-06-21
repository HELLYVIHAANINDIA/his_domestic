<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="viewUploadedFile">
	<table class="table">
	<thead>
			<tr>
				<th style="display:none;">Doc Id</th>
				<th>Sr.No.</th>
				<th>Document Name</th>
				<th>Description</th>
				<th>Type</th>
				<th>Date</th>
 				<th>Action</th>
			</tr>
	</thead>
	<tbody id="DocLst">
			<c:choose>
				<c:when test="${not empty lstDocuments}">
					<c:forEach items="${lstDocuments}" var="item" varStatus="indx">
						<tr>
							<td style="display: none;">${item["officerDocId"]}</td>
							<td>${indx.count}</td>
							<td>${item["fileName"]}</td>
							<td>${item["description"]}</td>
							<td>${item["fileType"]}</td>
							<td>${item["createdAt"]}</td>
							<td>
							<c:choose>
							
							<c:when test="${documentEndDateOver ne true and documentStartDateStart ne true}">
								<c:choose>
									<c:when test="${objectId eq 6 or objectId eq 7}">
										<a href="${pageContext.servletContext.contextPath}/ajax/downloadbriefcasefile/${item["officerDocId"]}/${objectId}/${objectId}">Download</a>
									</c:when>
									<c:when test="${objectId eq 3 or objectId eq 1 or objectId eq 4}">
										<a href="${pageContext.servletContext.contextPath}/ajax/downloadbriefcasefile/${item["officerDocId"]}/1">Download</a>
									</c:when>
									<c:otherwise>
										<a href="${pageContext.servletContext.contextPath}/ajax/downloadbriefcasefile/${item["officerDocId"]}">Download</a>
									</c:otherwise>
								</c:choose>
							 
							 </c:when>
							 
							 <c:otherwise>
							 <c:choose>
							 <c:when test="${documentEndDateOver eq true }">
							 Document download time is over.
							 </c:when>
							  <c:when test="${documentStartDateStart eq true }">
							 Document download time is not start yet.
							 </c:when>
							 </c:choose>
							 	
							 </c:otherwise>
							 </c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><td colspan="7">No record found.</td></tr>
				</c:otherwise>
		</c:choose>
		</tbody>	
</table>
</div>
