

    <div class="form-group">
        <label>Member Name *</label>
        <g:textField name="name" class="form-control" value="${member?.name}" laceholder="Please Enter Name"/>

    </div>
    <div class="form-group">
        <label>Designation</label>
        <g:textField name="designation" class="form-control" value="${member?.designation}" placeholder="Please Enter Company Address"/>

    </div>

    <div class="form-group">
        <label>Contact Number *</label>
        <g:textField name="number" class="form-control" value="${member?.number}" placeholder="Please Enter Contact Number"/>

    </div>
    <div class="form-group">
        <label>Email address *</label>
        <g:textField name="email" class="form-control" value="${member?.email}" placeholder="Please Enter Email"/>

    </div>
    <g:if test="${!member || member.role != 'Admin'}">
    <div class="dropdown">
        <label for="role">
            Type
        </label>
        <g:select name="role" from="${projectmanager.MemberType.values()}"/>
    </div>
    </g:if>
    <g:if test="${!member}">
    <div class="form-group">
        <label>Password *</label>
        <g:textField name="password" class="form-control password-field" placeholder="Please Enter Password"/>

    </div>

    <div class="form-group">
        <label>Retype your Password*</label>
        <g:textField name="rePassword" class="form-control password-field" placeholder="Please Retype Password"/>

    </div>

    </g:if>




