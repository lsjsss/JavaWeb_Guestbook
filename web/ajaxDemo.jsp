<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax</title>
</head>
<script type="text/javascript">
	var xhr = false;
	//创建XMLHttpRequest对象
	function createXHR(){
		try{
			xhr = new XMLHttpRequest();
		}catch(e){
			try{
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				xhr = false;
			}
		}
		if(!xhr){
			alert("初始化XMLHttpRequest对象失败！")
		}
	}
	function ajaxProcess(obj){
		createXHR();
		var zipCode = obj.value;
		var url = "ajaxdemo.do?zipCode="+zipCode;
		xhr.open("GET",url,true);
		xhr.onreadystatechange=function(){
			if(xhr.readyState = 4 && xhr.status == 200){
				var responseData = xhr.responseText.split(",");
				document.getElementById("province").value = responseData[0];
				document.getElementById("city").value = responseData[1];
			}
		};
		xhr.send(null);
	}
</script>
<body>
	<h2>获取区号对应的省市信息</h2>
	<p>
		区号：<input name="zipCode" id="zipCode" type="text" onblur="ajaxProcess(this)">
	</p>
	<p>
		省：<input name="province" id="province" type="text" />
	</p>
	<p>
		市：<input name="city" id="city" type="text" />
	</p>
</body>
</html>