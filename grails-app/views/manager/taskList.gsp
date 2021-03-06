<meta name="layout" content="manager"/>

<div class="card">
    <div class="card-header bg-info text-white">
        <g:message message="Task List"/>
        <span class="float-right">

        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Sl No.</th>
                <th>Task Name</th>
                <th>Description</th>
                <th>Assigned To</th>
                <th>From </th>
                <th>To</th>
                <th class="action-row"><g:message code="Status"/></th>
                <th class="action-row"><g:message code="Action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${task}" var="member" status="counter">
                <tr>
                    <td>${counter+1}</td>
                    <td>${member?.name}</td>
                    <td>${member?.description}</td>
                    <td>${member?.users?.name}</td>
                    <td><g:formatDate format="yyyy-MM-dd" date="${member?.fromDate}"/></td>
                    <td><g:formatDate format="yyyy-MM-dd" date="${member?.toDate}"/></td>
                    <td>${member?.status}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="manager" action="removeTask" class="btn btn-secondary" id="${member.id}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"><i class="fa fa-remove fa-lg"></i></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>