<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<div>
	    <div>Title:${knowledgeNode.name}</div>
	    <div>creator:${knowledgeNode.user.login}</div>
	    <div>create date:${knowledgeNode.created}</div>
		<div>Description: <br/>${knowledgeNode.description}</div>
		<div>URL:${knowledgeNode.url}</div>

	</div>

