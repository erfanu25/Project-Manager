

    <div class="form-group">
        <label>Project Name *</label>
        <g:textField name="name" class="form-control" value="${project?.name}" placeholder="Please Enter Project Name"/>
    </div>


    <div class="dropdown">
        <label for="type">
            Type
        </label>
        <g:select name="type" from="${projectmanager.ProjectType.values()}"/>
    </div>

    <div class="dropdown">
        <label for="category">
            Category
        </label>
        <g:select name="category" from="${projectmanager.ProjectCategory.values()}"/>
    </div>



