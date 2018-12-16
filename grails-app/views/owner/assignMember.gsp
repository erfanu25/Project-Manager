<meta name="layout" content="main"/>
<div class="card">
    <div class="card-header">
        <g:message message="Assign Member on Project"/>
    </div>
    <div class="card-body">
        <g:form controller="owner" action="provideMember">
            <div class="dropdown">
                <label><g:message  message="Projects"/></label>
                <UIHelper:projectListForMember name="project" />
            </div>

            <div class="form-group">
                <label><g:message message="Members"/> *</label>
                <UIHelper:memberList name="member"/>
            </div>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="login" value="${g.message(code: "save")}"/>
                <g:link controller="dashboard" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>