<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" charset="utf-8">
$(document).ready(
 function(){
$('#highlight').dataTable(
{
"sPaginationType": "full_numbers"
}
);
 }
);

</script>

<fieldset><legend>My knowledge</legend>
  <table class="display" id="highlight">
        <thead>
          <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Tags</th>
            <th>Created</th>
            <th>Operation</th>
            </tr>
        </thead>
        <tbody>
       
        <c:forEach var="node" items="${knowledgeNodes}">
            <tr>
                <td>${node.id}</td>
                <td>${node.name}</td>
                <td><c:forEach var="knowledgeTag" items="${node.knowledgeTags}" varStatus="status">${knowledgeTag.tag.tag} <c:if test="${!status.last}">,</c:if>&nbsp;</c:forEach></td>
                <td>${node.created}</td>
                <td>
                <a href="<c:url value="/knowledge/node/${node.id}/view" />">
                <img src="<c:url value="/resources/images/crud/view.png"/>" title="View this node" />
                </a>
                <a href="<c:url value="/knowledge/node/${node.id}/edit" />">
                <img src="<c:url value="/resources/images/crud/edit.png"/>" title="Edit this node" />
                </a>
                </td>
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
</fieldset>
