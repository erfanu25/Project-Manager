<meta name="layout" content="main"/>

<div class="card">
    <div class="card-header">
        Member Registration
    </div>

    <div class="card-body">
        <g:form controller="owner" action="regMember">

            <div class="form-group">
                <label>Member Name *</label>
                <g:textField name="name" class="form-control" value="${member?.name}" placeholder="Please Enter Name"/>
                <UIHelper:renderErrorMessage fieldName="name" model="${member}" errorMessage="please.enter.valid.name"/>
            </div>

            <div class="form-group">
                <label>Designation</label>
                <g:textField name="designation" class="form-control" value="${member?.designation}"
                             placeholder="Please Enter Employee Designation"/>

            </div>

            <div class="form-group">
                <label>Contact Number *</label>
                <g:textField name="number" class="form-control" value="${member?.number}"
                             placeholder="Please Enter Contact Number"/>
                <UIHelper:renderErrorMessage fieldName="number" model="${member}" errorMessage="please.enter.valid.number"/>
            </div>

            <div class="form-group">
                <label>Email address *</label>
                <g:textField name="email" class="form-control" value="${member?.email}"
                             placeholder="Please Enter Email"/>
                <UIHelper:renderErrorMessage fieldName="email" model="${member}" errorMessage="please.enter.valid.email"/>
            </div>

            <div class="dropdown">
                <label for="role">
                    Type
                </label>
                <g:select name="role" from="${projectmanager.MemberType.values()}"/>
            </div>

            <div class="form-group">
                <label>Password *</label>
                <g:passwordField name="password" class="form-control password-field" placeholder="Please Enter Password"/>

            </div>

            <div class="form-group">
                <label>Retype your Password*</label>
                <g:passwordField name="rePassword" class="form-control password-field"
                             placeholder="Please Retype Password"/>

            </div>

            <div class="form-action-panel">
                <g:submitButton name="registration" value="Registration" class="btn btn-primary"/>
                <g:link controller="owner" action="panel" class="btn btn-primary"><g:message
                        code="back.to.home"/></g:link>
            </div>
        </g:form>
    </div>
</div>