<meta name="layout" content="member"/>

<div class="card">
    <div class="card-header">
        <g:message message="Member Panel"/>
        <span class="float-right">
            <div class="btn-group">
                <g:link action="index" controller="member" class="btn btn-primary">Reload</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <div class="card" style="width: 74rem;">
            <div class="card-body">
                <p class="card-title"><b>Name : </b><g:message message="${user.name}"/></p>
                <p class="card-title"><b>Project Name : </b><g:message message="${project.name}"/></p>
                <p class="card-title"><b>Project Manager : </b><g:message message="${project.manager.name}"/></p>
                <p class="card-title"><b>Total Member : </b><g:message message="${project.users.size()}"/></p>
                <p class="card-title"><b>Started From : </b><g:message message="${project.dateCreated}"/></p>
            </div>
        </div>

    </div>


</div>
