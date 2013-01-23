<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page
	import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>

<c:if test="${not empty param.login_error}">
	<div class="error">
		Your login attempt was not successful, try again.<br />
		<br /> Reason:
		<%= ((AuthenticationException) session.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
	</div>
</c:if>
<form id="loginform" name="f"
	action="<c:url value="/login/login/authenticate" />" method="post">
	<div align="center">
		<table style="width: 800px;">
			<tr>
				<td align="center">
					<fieldset class="login">
						<table>
							<tr>
								<th align="right">Login:
									<input value="hongtao" type="text" style="width: 12em"
									name="j_username" id="j_username"
									<c:if test="${not empty param.login_error}">value="<%= session.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY) %>"</c:if> />
									<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "j_username",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { promptMessage : "Your username", required : true }}));
				</script> </th>

							</tr>
							<tr>
								<th align="right">Password:
									<input value="hongtao" type="password" name="j_password"
									id="j_password" style="width: 12em" /> <script
										type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "j_password",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { promptMessage : "Your password", required : true}}));
				</script> </th>
							</tr>
						</table>
						<button id="submit" type="submit">Login</button>
						<script type="text/javascript">
		    Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
		</script>
					</fieldset>
				</td>
			</tr>

		</table>
	</div>
</form>


