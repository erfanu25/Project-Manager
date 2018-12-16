<meta name="layout" content="manager"/>

<div class="card">
    <div class="card-header">
        <g:message message="Daily Task Update"/>
        <span class="float-right">

        </span>
    </div>
    <div class="card-body">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Sl No.</th>
                <th>Member Name</th>
                <th>Task</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${taskUpdate}" var="member" status="counter">
                <tr>
                    <td>${counter+1}</td>
                    <td>${member?.users?.name}</td>
                    <td>${member?.description}</td>
                    <td>${member?.dateCreated}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>