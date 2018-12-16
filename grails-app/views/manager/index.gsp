<meta name="layout" content="manager"/>

<div class="card">
    <div class="card-header">
        <g:message message="Manager Panel"/>
        <span class="float-right">
            <div class="btn-group">
                <g:link action="index" controller="manager" class="btn btn-primary">Reload</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <div class="card" style="width: 74rem;">
            <div class="card-body">
                <p class="card-title"><b>Project Name : </b><g:message message="${project.name}"/></p>
                <p class="card-title"><b>Project Manager : </b><g:message message="${project.manager.name}"/></p>
                <p class="card-title"><b>Total Member : </b><g:message message="${project.users.size()}"/></p>
                <p class="card-title"><b>Started From : </b><g:message message="${project.dateCreated}"/></p>
            </div>
        </div>

    </div>


</div>
