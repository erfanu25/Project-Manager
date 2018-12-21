<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header bg-info text-white">
        Add New Project
    </div>
    <div class="card-body">
        <g:form controller="owner" action="saveProject">
            <g:render template="projectform"/>
            <div class="form-action-panel">
                <g:submitButton name="Create" value="Create" class="btn btn-primary"/>
                <g:link controller="owner" action="index" class="btn btn-primary"><g:message code="back.to.home"/></g:link>
            </div>
        </g:form>
    </div>
</div>