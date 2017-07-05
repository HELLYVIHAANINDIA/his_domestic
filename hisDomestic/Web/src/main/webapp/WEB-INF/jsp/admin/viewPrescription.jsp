  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="main-bg">

	<header class="main-print-header"> </header>
	<!--main-print-header-->

	<div class="main-line">
		<div class="rx-rx">Rx :</div>
		<div class="p-date">06/06/2017</div>
	</div>

	<div class="main-line">
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> Patient cr No:</lable>
			${patient[0][0]}</br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> First Name:</lable>
			${patient[0][1]}</br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> Last Name: <lable> ${patient[0][2]}<br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> Age:</lable>
			${patient[0][3]} <br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> Gender:</lable>
			${patient[0][4]} <br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> Mob No:</lable>
			${patient[0][5]}-${patient[0][6]}<br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> Consulting No:</lable>
			${patient[0][7]}<br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable> Consulting Note:</lable>
			${clinicalDetail[0].history}<br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable>Comments:</lable>
			${clinicalDetail[0].comments}<br>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable>Complaints:</lable>
			<c:forEach items="${clinicalCompliants}" var="complain">
     ${complain[2]}<br>
			</c:forEach>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable>Medicine:</lable>
			<lable>Medicine:</lable>
			<c:forEach items="${clinicalMedical}" var="medicien">
  ${medicien[2]}<br>
			</c:forEach>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable>Report:</lable>
			<c:forEach items="${clinicalReport}" var="report">
  ${report[2]}<br>
			</c:forEach>
		</div>
		<div class="sr-no"></div>
		<div class="prescription">
			<lable>Remark:</lable>
			${clinicalDetail[0].remark}
		</div>


	</div>
	<!--main-line-->

</div>
<!--main-bg-->

