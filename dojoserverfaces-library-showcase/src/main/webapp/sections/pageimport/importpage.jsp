<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<!--
    	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
    	Available via Academic Free License >= 2.1 OR the modified BSD license.
    	see: http://dojotoolkit.org/license for details
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GlassFish JSP Page</title>
<style type="text/css">
#bodyHello {
	width: 1000px;
	heigh: 500px;
	font-size: 2em;
	color: red
}
</style>

</head>
<body>
<script type="text/javascript">
	document.getElementById('bodyHello').innerHTML = 'Hello World script from Body';
</script>
<div id="bodyHello"></div>
<br />
<div id="headHello"></div>
<script type="text/javascript">
	document.getElementById('headHello').innerHTML = 'Hello World script from head';
</script>
</body>
</html>