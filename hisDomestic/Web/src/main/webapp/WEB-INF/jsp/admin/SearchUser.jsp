

<script>
function searchUser() {
	 
	var search = $("#txtsearch").val();
			 $.ajax({
				type: "GET",
				url: contextPath+"/domestic/patient/searchUser/"+search,
				success: function success(result){
					$("#searchUser").html("");
		 			$("#searchUser").html(result);
				}
			}); 
	   
	    
	
}
</script>


		<div id="content-wrapper">
		
			<div class="site-content-title">
				<div class="col-sm-6 col-xs-12"><h2 class="float-xs-left content-title-main pull-left">User</h2></div>
				<div class="col-sm-6 col-xs-12"><span class="small pull-right cm-field-up">All (*) marked Fields are mandatory</span></div>
			</div>
			
			<div class="content">
			
			<div class="row">
		<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12">
			<div class="field-set-box">
				<label>Search</label>
				<div class="form-group">
					<input class="form-control" value="" type="text" id="txtsearch" name="txtsearch">					
				</div>
			</div>
		</div>
		<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12">
			<button class="srch-bttn" onclick="return searchUser()">
				<i class="fa fa-search" aria-hidden="true"></i>
				<span>Search</span>
			</button>
		</div>									
	</div>
	</div>
			
			<div id="searchUser">
			</div>


