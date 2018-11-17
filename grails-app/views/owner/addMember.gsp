<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
       Member Registration
    </div>
    <div class="card-body">
        <g:form controller="owner" action="regMember">
            <g:render template="form"/>
            <div class="form-action-panel">
                <g:submitButton name="registration" value="Registration" class="btn btn-primary"/>
                <g:link controller="owner" action="panel" class="btn btn-primary"><g:message code="back.to.home"/></g:link>
            </div>
        </g:form>
    </div>
</div>