<meta name="layout" content="main"/>
<div class="card">
    <div class="card-header bg-info text-white">
        <g:message code="Member" args="['Update']"/>
    </div>
    <div class="card-body">
        <g:form controller="owner" action="memberUpdate">
            <g:hiddenField name="id" value="${member.id}"/>
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="login" value="${g.message(code: "update")}"/>
                <g:link controller="owner" action="showMember" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>