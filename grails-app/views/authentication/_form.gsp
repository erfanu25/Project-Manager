

    <div class="form-group">
        <label>Company Name *</label>
        <g:textField name="companyName" class="form-control" value="${member?.companyName}" placeholder="Please Enter Company Name"/>
        <UIHelper:renderErrorMessage fieldName="companyName" model="${member}" errorMessage="please.enter.valid.name"/>

    </div>
    <div class="form-group">
        <label>Address</label>
        <g:textField name="address" class="form-control" value="${member?.address}"  placeholder="Please Enter Company Address"/>
        <UIHelper:renderErrorMessage fieldName="address" model="${member}" errorMessage="please.enter.valid.name"/>
    </div>
    <div class="form-group">
        <label>Your Name</label>
        <g:textField name="ownerName" class="form-control" value="${member?.ownerName}" placeholder="Please Your Name"/>
        <UIHelper:renderErrorMessage fieldName="ownerName" model="${member}" errorMessage="please.enter.valid.name"/>
    </div>
    <div class="form-group">
        <label>Contact Number *</label>
        <g:textField name="number" class="form-control" value="${member?.number}" placeholder="Please Enter Contact Number"/>
        <UIHelper:renderErrorMessage fieldName="number" model="${member}" errorMessage="please.enter.valid.name"/>
    </div>
    <div class="form-group">
        <label>Email address *</label>
        <g:textField name="email" class="form-control" value="${member?.email}" placeholder="Please Enter Email"/>
        <UIHelper:renderErrorMessage fieldName="email" model="${member}" errorMessage="please.enter.valid.name"/>
    </div>

    <div class="form-group">
        <label>Password *</label>
        <g:textField name="password" class="form-control password-field" value="${member?.password}" placeholder="Please Enter Password"/>
        <UIHelper:renderErrorMessage fieldName="password" model="${member}" errorMessage="please.enter.valid.name"/>
    </div>

    <div class="form-group">
        <label>Retype your Password*</label>
        <g:textField name="rePassword" class="form-control password-field" placeholder="Please Retype Password"/>

    </div>




