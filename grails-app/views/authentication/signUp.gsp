<meta name="layout" content="public"/>

<div class="card">
    <div class="card-header">
        Registration
    </div>
    <div class="card-body">
        <g:form controller="authentication" action="register">
            <div class="form-group">
                <label>Company Name *</label>
                <g:textField name="companyName" class="form-control" value="${company?.companyName}" placeholder="Please Enter Company Name"/>
                <UIHelper:renderErrorMessage fieldName="companyName" model="${company}" errorMessage="please.enter.valid.name"/>

            </div>
            <div class="form-group">
                <label>Address</label>
                <g:textField name="address" class="form-control" value="${company?.address}"  placeholder="Please Enter Company Address"/>
                <UIHelper:renderErrorMessage fieldName="address" model="${company}" errorMessage="please.enter.valid.address"/>
            </div>
            <div class="form-group">
                <label>Your Name</label>
                <g:textField name="ownerName" class="form-control"  placeholder="Please Your Name"/>
            </div>
            <div class="form-group">
                <label>Contact Number *</label>
                <g:textField name="number" class="form-control" value="${company?.number}" placeholder="Please Enter Contact Number"/>
                <UIHelper:renderErrorMessage fieldName="number" model="${company}" errorMessage="please.enter.valid.number"/>
            </div>
            <div class="form-group">
                <label>Email address *</label>
                <g:textField name="email" class="form-control" value="${company?.email}" placeholder="Please Enter Email"/>
                <UIHelper:renderErrorMessage fieldName="email" model="${company}" errorMessage="please.enter.valid.email"/>
            </div>

            <div class="form-group">
                <label>Password *</label>
                <g:passwordField name="password" class="form-control password-field"  placeholder="Please Enter Password"/>
            </div>

            <div class="form-group">
                <label>Retype your Password*</label>
                <g:passwordField name="rePassword" class="form-control password-field" placeholder="Please Retype Password"/>

            </div>

            <div class="form-action-panel">
                <g:submitButton name="registration" value="Registration" class="btn btn-primary"/>
                <g:link controller="authentication" action="panel" class="btn btn-primary"><g:message code="back.to.home"/></g:link>
            </div>
        </g:form>
    </div>
</div>