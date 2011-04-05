<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GlassFish JSP Page</title>
<style type="text/css">
#hello {
	width: 1000px;
	heigh: 500px;
	font-size: 2em;
	color: red
}
</style>
<script type="text/javascript">
	alert('script from head');
</script>
</head>
<body>
<script type="text/javascript">
	alert('script from Body');
</script>
<div id="hello">Hello World!</div>
<input type="hidden" id="ttttt" value="ddddddddddddddd">
</body>
</html>