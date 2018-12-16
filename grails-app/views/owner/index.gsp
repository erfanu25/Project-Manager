<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        <g:message message="Admin Panel"/>
        <span class="float-right">
            <div class="btn-group">
                <g:link action="index" controller="owner" class="btn btn-primary">Reload</g:link>
            </div>
        </span>
    </div>

    <div class="card-body">
        <div class="card" style="width: 74rem;">
            <div class="card-body">
                <p class="card-title"><b>Total Project : </b><g:message message="${project.size()}"/></p>
                <p class="card-title"><b>Total Employee : </b><g:message message="${total}"/></p>
            </div>
        </div>
<br>
            <div class="card-group row">
                <g:each in="${project}" var="it">
                    <div class="card-columns column col-4">
                        <div class="card" style="width: 24rem;">
                            <g:link controller="owner" action="projectDetails" class="btn btn-light " id="${it.id}">
                            <div class="card-body" style="width: 22rem;">
                                <p class="card-title"><b>Project Title : </b><g:message message="${it.name}"/></p>

                                <p class="card-title"><b>Project Manager : </b><g:message message="${it.manager?.name}"/></p>

                                <p class="card-title"><b>Project Type : </b><g:message message="${it.type}"/></p>

                                <p class="card-title"><b>Project Category : </b><g:message message="${it.category}"/></p>

                                <p class="card-title"><b>Total Member : </b><g:message message="${it.users.size()}"/></p>
                            </div>
                            </g:link>
                        </div>
                    </div>
                </g:each>
            </div>
        </div>


</div>
