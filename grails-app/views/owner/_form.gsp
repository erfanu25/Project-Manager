

    <div class="form-group">
        <label>Member Name *</label>
        <g:textField name="name" class="form-control" placeholder="Please Enter Company Name"/>

    </div>
    <div class="form-group">
        <label>Designation</label>
        <g:textField name="designation" class="form-control"  placeholder="Please Enter Company Address"/>

    </div>
    <div class="form-group">
        <label>Address</label>
        <g:textField name="address" class="form-control" placeholder="Please Your Name"/>

    </div>
    <div class="form-group">
        <label>Contact Number *</label>
        <g:textField name="number" class="form-control" placeholder="Please Enter Contact Number"/>

    </div>
    <div class="form-group">
        <label>Email address *</label>
        <g:textField name="email" class="form-control" placeholder="Please Enter Email"/>

    </div>

    <div class="dropdown">
        <label for="role">
            Type
        </label>
        <g:select name="role" from="${projectmanager.MemberType.values()}"/>
    </div>

    <div class="form-group">
        <label>Password *</label>
        <g:textField name="password" class="form-control password-field" placeholder="Please Enter Password"/>

    </div>

    <div class="form-group">
        <label>Retype your Password*</label>
        <g:textField name="rePassword" class="form-control password-field" placeholder="Please Retype Password"/>

    </div>




