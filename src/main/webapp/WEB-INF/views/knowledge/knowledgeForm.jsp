<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="<c:url value="/resources/javascript/livesearch/jquery.autocomplete.js" />"></script>

<script type="text/javascript">
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
		plugins : "pre,autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave,visualblocks",

		// Theme options
		theme_advanced_buttons1 : "newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft,visualblocks,|,pre",
		//theme_advanced_buttons4 : "pre",
		
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,

		// Example content CSS (should be your site CSS)
		//content_css : "css/content.css",

		// Style formats
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
			{title : 'Example 1', inline : 'span', classes : 'example1'},
			{title : 'Example 2', inline : 'span', classes : 'example2'},
			{title : 'Table styles'},
			{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
		],


	});
</script>
<!-- /TinyMCE -->
  <script type="text/javascript">
    jQuery(function($)
    {
      $('#file_input').multifile();
    });
  </script>
 <!-- 
<script type="text/javascript">
   jQuery(function($)    {
     $('#tags_autocomplete').autocomplete({
	    delimiter:/[,;，；]\s*/,
        lookup: '${tags}'.split(',')
      });
	});
</script>
 --> 
 
 <script type="text/javascript">
 var url = "${pageContext.request.contextPath}/tag/json";
 jQuery(function($)    {
     $('#tags_autocomplete').autocomplete({
    	    serviceUrl:url,
    	    delimiter:/[,;，；]\s*/
    	
    	});
	});
</script>

 
 <style type="text/css"> 
.autocomplete-suggestions { border: 1px solid #999; background: #FFF; cursor: default; overflow: auto; }
.autocomplete-suggestion { padding: 2px 5px; white-space: nowrap; overflow: hidden; }
.autocomplete-selected { background: #F0F0F0; }
.autocomplete-suggestions strong { font-weight: normal; color: #3399FF; }
 </style> 
 <!-- 
	<div class="header">
			<c:if test="${not empty message}">
				<div id="message" class="success"><pre><c:out escapeXml="true" value="${message}"/></pre></div>
			</c:if>
		</div>
-->
<form:form modelAttribute="knowledgeNode" enctype="multipart/form-data">
<div>
	    <div>
			 Title:<form:input path="name"  style="width: 85%"/>

		</div>
		 <div>
			 Tags: <input type="text" name="tags" id="tags_autocomplete" style="width: 85%;" autocomplete="off" value="${tags}"/>
			  <div id="suggestions-container" style="position: relative; width: 400px; margin: 10px;"></div>
		</div>
		    <div>
			 Importance:<input type="range" min="0" max="5" value="${knowledgeNode.importance}" step="1" id="star" name="importance">
            <div class="rateit" data-rateit-backingfld="#star"></div>
            </div>
		   <div>
			 URL: <form:input path="url"  style="width: 85%" />
		</div>
		<div>
			 Description: <form:textarea  path="description" rows="15" cols="80" style="width: 90%" />
		</div>
		<div>
		     Files: <input id="file_input" type="file" name="files[]">
		</div>
		<input type="submit" name="save" value="Save" />
		<input type="submit" name="_cancel" value="Cancel" />
	</div>
</form:form>
