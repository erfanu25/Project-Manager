<meta name="layout" content="member"/>

<div class="card">
    <div class="card-header bg-info text-white">
        <g:message message="Task Update List"/>
        <span class="float-right">

        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Sl No.</th>
                <th>Task</th>
                <th>Date</th>
                <th class="action-row"><g:message code="Action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${taskUpdate}" var="member" status="counter">
                <tr>
                    <td>${counter+1}</td>
                    <td>${member?.description}</td>
                    <td>${member?.dateCreated}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="member" action="removeDailyTask" class="btn btn-secondary" id="${member.id}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"><i class="fa fa-remove fa-lg"></i></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>