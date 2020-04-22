<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>

<script type="text/javascript">
	$(function(){
		$.post("queryCamp",function(data){
			var str = "";
			for(var i in data){
				str+="<option value='"+data[i].cid+"'>"+data[i].cname+"</option>"
			}
			$("#cid").append(str);
			
			$("#cid").val("${hero.cid}");
		})
		
	})
</script>

</head>
<body>

	英雄名称：<input type="text" name="hanem" value="${hero.hname }"><br>
	价格：<input type="text" name="price" value="${hero.price }"><br>
	阵营；<select name="cid" id="cid">
				<option>请选择</option>
			</select>
	状态：<select name="status">
				<option>请选择</option>
				<option value="0" <c:if test="${map.status==0 }">selected="selected"</c:if>>未拥有</option>
				<option value="1" <c:if test="${map.status==1 }">selected="selected"</c:if>>已拥有</option>
			</select>

</body>
</html>