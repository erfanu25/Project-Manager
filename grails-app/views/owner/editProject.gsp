<meta name="layout" content="main"/>
<div class="card">
    <div class="card-header bg-info text-white">
        <g:message code="Project" args="['Update']"/>
    </div>
    <div class="card-body">
        <g:form controller="owner" action="projectUpdate">
            <g:hiddenField name="id" value="${project.id}"/>
            <g:render template="projectform"/>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="submit" value="${g.message(code: "update")}"/>
                <g:link controller="owner" action="projectList" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>