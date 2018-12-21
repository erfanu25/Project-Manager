<meta name="layout" content="manager"/>

<div class="card">
    <div class="card-header bg-info text-white">
        <g:message message="Team Members"/>
    </div>
    <div class="card-body">

        <div class="card" style="width: 48rem;">
            <div class="card-body">
                <p class="card-title"><b>Project Title : </b><g:message message="${project.name}"/></p>
                <p class="card-title"><b>Project Manager : </b><g:message message="${manager?.name}"/></p>
                <p class="card-title"><b>Project Type : </b><g:message message="${project.type}"/></p>
                <p class="card-title"><b>Project Category : </b><g:message message="${project.category}"/></p>
                <p class="card-title"><b>Started From : </b><g:message message="${project.dateCreated}"/></p>
                <p class="card-title"><b>Total Member: </b><g:message message="${count}"/></p>
            </div>
        </div>
        <br>
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
            <g:each in="${member}" var="user" status="counter">
                <tr>
                    <td>${counter+1}</td>
                    <td>${user?.name}</td>
                    <td>${user?.designation}</td>
                    <td>${user?.email}</td>
                    <td>${user?.role}</td>
                    <td>
                        <div class="btn-group">
                            <g:if test="${user?.role != 'Manager'}">
                                <g:link controller="manager" action="removeProjectMember" id="${user.id}" class="btn btn-secondary delete-confirmation"><i class="fa fa-remove fa-lg"></i></g:link>
                            </g:if>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>