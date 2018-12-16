<meta name="layout" content="member"/>

<div class="card">
    <div class="card-header">
        <g:message message="Task Assigned To Me"/>
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
                    <td>${member?.fromDate}</td>
                    <td>${member?.toDate}</td>
                    <td>${member?.status}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="member" action="updateTaskStatus" class="btn btn-secondary" id="${member.id}"><i class="fa fa-check fa-lg"></i></g:link>
                            <g:link controller="member" action="unableTaskStatus" class="btn btn-secondary" id="${member.id}"><i class="fa fa-remove fa-lg"></i></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>