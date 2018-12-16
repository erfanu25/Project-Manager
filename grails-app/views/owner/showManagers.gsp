<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="Managers" args="['List Of']"/>
        <span class="float-right">
            <div class="btn-group">
                <g:link controller="owner" action="showManagers" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Sl No.</th>
                <th>Name</th>
                <th>Designation</th>
                <th>Email</th>
                <th>Role</th>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${user}" var="member" status="counter">
                <tr>
                    <td>${counter+1}</td>
                    <td>${member?.name}</td>
                    <td>${member?.designation}</td>
                    <td>${member?.email}</td>
                    <td>${member?.role}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="owner" action="editMember" class="btn btn-secondary" id="${member.id}"><i class="fa fa-pencil fa-lg"></i></g:link>
                <g:if test="${member.role != 'Admin'}">
                            <g:link controller="owner" action="deleteMember" id="${member.id}" class="btn btn-secondary delete-confirmation"><i class="fa fa-remove fa-lg"></i></g:link>
                </g:if>
                    </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>