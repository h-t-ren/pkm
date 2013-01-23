<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>PKM</title>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-latest.js" />"></script>	
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-ui-latest.js" />"></script>	
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.layout-latest.js" />"></script>	
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.dataTables.js" />"></script>	
<!-- TinyMCE -->
<script type="text/javascript" src="<c:url value="/resources/javascript/tiny_mce/tiny_mce.js" />"></script>	

<link rel="stylesheet" href="<c:url value="/resources/styles/blueprint/screen.css" />" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="<c:url value="/resources/styles/blueprint/print.css" />" type="text/css" media="print" />
<!--[if lt IE 8]>
 <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection" />
<![endif]-->
<link rel="stylesheet" href="<c:url value="/resources/styles/enrima-web.css" />" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value="/resources/styles/table.css" />" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="<c:url value="/resources/styles/layout-default-latest.css" />" type="text/css" media="screen" />
<link rel="stylesheet" href="<c:url value="/resources/messages/messages.css" />" type="text/css" media="screen, projection" />




<style type="text/css">
   html, body { width: 100%; height: 100%; margin: 0; }
</style>
<SCRIPT type="text/javascript">
	var myLayout;

	$(document).ready(function () {

		// this layout could be created with NO OPTIONS - but showing some here just as a sample...
		// myLayout = $('body').layout(); -- syntax with No Options

		myLayout = $('body').layout({

		//	reference only - these options are NOT required because 'true' is the default
			closable:					true	// pane can open & close
		,	resizable:					true	// when open, pane can be resized 
		,	slidable:					true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
		,	livePaneResizing:			true

		//	some resizing/toggling settings
		,	north__slidable:			false	// OVERRIDE the pane-default of 'slidable=true'
		,	north__spacing_closed:		2		// big resizer-bar when open (zero height)
		,	south__resizable:			false	// OVERRIDE the pane-default of 'resizable=true'
		,	south__spacing_open:		2		// no resizer-bar when open (zero height)
		,	south__spacing_closed:		21		// big resizer-bar when open (zero height)

		//	some pane-size settings
		,	west__minSize:				400
		,	center__minWidth:			500

		//	some pane animation settings
		,	west__animatePaneSizing:	false
		,	west__fxSpeed_size:			"fast"	// 'fast' animation when resizing west-pane
		,	west__fxSpeed_open:			1000	// 1-second animation when opening west-pane
		,	west__fxSettings_open:		{ easing: "easeOutBounce" } // 'bounce' effect when opening
		,	west__fxName_close:			"none"	// NO animation when closing west-pane

		});
		myLayout.sizePane("west", 440);
		myLayout.sizePane("south", 16);

 	});

</SCRIPT>



</head>


<body>


  <div class="ui-layout-north" id="header_toolbar">
  <%@ include file="header.jsp" %>
  </div>
  
   <div class="ui-layout-west">
      <tiles:insertAttribute name="submenu" />
  </div>
  <div  class="ui-layout-center">
     <tiles:insertAttribute name="body" />
  </div>

 <div class="ui-layout-south" id="footer_copyrights">
 Copyright &copy; 2012-<script type="text/javascript"> var d = new Date();document.write(d.getFullYear());</script> &nbsp; Hongtao Ren
  </div>

</body>



</html>