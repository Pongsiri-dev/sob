<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>แบบท้สอบ</title>

<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>

</head>
<head>
<style type="text/css">
	#loading{
		display:none
	}
	
	
	body{
		margin: 5% 2% 5% 5%;
	}
</style>
<title>User list</title>
</head>
<body>
	<h1>ค้นหาข้อมูล</h1>
	<sub>******************************************************************************************</sub>
	<br />
	<br />
	<form id="frm_details" method="post" name="frm_details">
		ค้นหาจาก <select id="srchBy" name="srchBy">
			<option value="all">--- กรุณาเลือกวิธีค้นหา ---</option>
			<option value="id">ค้าหาจาก ID</option>
			<option value="username">ค้นหาจากชื่อผู้ใช้งาน</option>
		</select> <br /><br />
		 Filter: <input type="text" name="keyword" id="keyword"
			size="50" value="${keyword}" required /> &nbsp; <input type="submit"
			id="submit" value="Search" />
	</form>
	<br />
	<br />
	<div id="loading">กำลังค้นหาข้อมูล กรุณารอสักครู่ ......</div>
	<br />
	<br />

	<div>
		<p>แสดงข้อมูล</p>
		<pre id="ajaxGetUserServletResponse">
		${users}
		</pre>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$("#frm_details").on("submit", function(event) {
			event.preventDefault();
			var formData = {
				'keyword' : $('input[name=keyword]').val(),
				'srchBy' : $('#srchBy').val()
			};
			
			$("#loading").css("display", "block");
			$("#loading").css("background-color", "#E9E3CA");
			$.ajax({
				url : "/section/search",
				type : "post",
				data : formData,
				success : function(res) {
					$("#loading").css("display", "none");
					$('#ajaxGetUserServletResponse').text(res);
				}
			});
		});
	});
</script>
</html>