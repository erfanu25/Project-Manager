<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message code="projects" args="['List Of']"/>
        <span class="float-right">
            <div class="btn-group">
                <g:link controller="owner" action="projectList" class="btn btn-primary"><g:message code="reload"/></g:link>
            </div>
        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Sl No.</th>
                <th>Name</th>
                <th>Type</th>
                <th>Category</th>
                <th class="action-row"><g:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${project}" var="it" status="counter">
                <tr>
                    <td>${counter+1}</td>
                    <td>${it?.name}</td>
                    <td>${it?.type}</td>
                    <td>${it?.category}</td>
                    <td>
                        <div class="btn-group">
                            <g:link controller="owner" action="projectDetails" class="btn btn-secondary" id="${it.id}"><i class="fa fa-eye fa-lg"></i></g:link>
                            <g:link controller="owner" action="editProject" class="btn btn-secondary" id="${it.id}"><i class="fa fa-pencil fa-lg"></i></g:link>
                            <g:link controller="owner" action="deleteProject" id="${it.id}" class="btn btn-secondary delete-confirmation"><i class="fa fa-remove fa-lg"></i></g:link>
                        </div>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        <div class="paginate">
            <g:paginate total="${total ?: 0}" />
        </div>
    </div>
</div>