
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="main-bg">

	<header class="main-print-header"> </header>
	<!--main-print-header-->

	<div class="main-line">
		<div class="rx-rx">Rx :</div>
		<div class="p-date">
			<label><b>Date:</b></label> ${currentDate}</b>
		</div>
	</div>

	<div class="main-line">
		<div class="sr-no"></div>
		<div class="prescription">
			<!-- <lable> First Name:</lable> -->
			${patient[0][1]} ${patient[0][2]}</br>
		</div>
		<br>
		<br>
		<div class="sr-no"></div>
		<div class="prescription">
		<label>History:</label>
			<p>${clinicalDetail[0].history}</p>
		</div>
		<br>
		<br>
		<div class="sr-no"></div>
		<div class="prescription">
			<label>Complains:</label>
			<c:forEach items="${clinicalCompliants}" var="complain">
                         ${complain[2]},
			</c:forEach>
		</div>
		<br>
		<br>
		<div class="sr-no"></div>
		<div class="prescription">
			<label>Findings:</label>

			<c:forEach items="${clinicalFinding}" var="finging">
  ${finging[2]} ->  ${finging[4]}<br>
				
			</c:forEach>
		</div>
		<br>
		<br>
		<div class="sr-no"></div>
		<div class="prescription">
		<label>Reports:</label>
			<c:forEach items="${clinicalReport}" var="report">
                     ${report[2]},
			</c:forEach>
		</div>
		<br>
		<br>
		<div class="sr-no"></div>
		<div class="prescription">
            <label>Medicine:</label>
			<c:forEach items="${clinicalMedical}" var="medicien">
  ${medicien[4]}<br>
  ${medicien[2]} <br>
				<br>

			</c:forEach>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable>Comment:</lable>
			${clinicalDetail[0].remark}
		</div>



	</div>

</div>


