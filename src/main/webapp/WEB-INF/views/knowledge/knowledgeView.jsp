<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<div>
	    <div>Title:${knowledgeNode.name}</div>
	    <div>Tags:${tags}</div>
	    <div> Importance:
	    <div class="rateit" data-rateit-value="${knowledgeNode.importance}" data-rateit-ispreset="true" data-rateit-readonly="true"></div>
	    </div>
	    <div>creator:${knowledgeNode.user.login}</div>
	    <div>create date:${knowledgeNode.created}</div>
	    <div>URL:${knowledgeNode.url}</div>
		<div>Description: <br/>
		     ${knowledgeNode.description}
		</div>
		<c:forEach var="doc" items="${knowledgeNode.documents}">
		   <div><a href="<c:url value="/doc/${doc.fileName}/${doc.orgName}/download"/>">${doc.orgName}</a></div>
		 </c:forEach>
	</div>

