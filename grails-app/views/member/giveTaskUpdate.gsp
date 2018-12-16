<meta name="layout" content="member"/>
<div class="card">
    <div class="card-header">
        <g:message message="Daily Task Update"/>
    </div>
    <div class="card-body">
        <g:form controller="member" action="addTaskUpdate">

            <div class="form-group">
                <label for="comment"><g:message message="Task Details"/> *</label>
                <textarea class="form-control" rows="5" id="comment" name="description"></textarea>
            </div>

            <div class="form-action-panel">
                <g:submitButton class="btn btn-primary" name="submit" value="${g.message(code: "save")}"/>
                <g:link controller="member" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
            </div>
        </g:form>
    </div>
</div>