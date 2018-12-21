<meta name="layout" content="manager"/>
<div class="card">
    <div class="card-header bg-info text-white">
        <g:message message="Assign Task to Member"/>
    </div>
    <div class="card-body">
        <g:form controller="manager" action="addTask">
            <div class="dropdown">
                <label><g:message  message="Member"/></label>
                <UIHelper:projectMemberList name="users" />
            </div>
            <div class="form-group">
                <label for="comment"><g:message message="Task Name"/> *</label>
                <g:textField   name="name"/>
            </div>
            <div class="form-group">
                <label for="comment"><g:message message="Task Details"/> *</label>
                <textarea class="form-control" rows="5" id="comment" name="description"></textarea>
            </div>
            <div class="form-group">
                <label for="comment"><g:message message="From Date"/> *</label>
                <g:datePicker name="fromDate" precision="day" default="${new Date()}"/>
            </div>
            <div class="form-group">
                <label for="comment"><g:message message="To Date"/> *</label>
                <g:datePicker name="toDate" precision="day" default="${new Date()}"/>
            </div>
            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="login" value="${g.message(code: "save")}"/>
                <g:link controller="manager" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>