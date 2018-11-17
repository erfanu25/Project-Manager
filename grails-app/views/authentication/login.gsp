<meta name="layout" content="public"/>
<div id="global-wrapper">
    <div id="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 mx-auto">
                    <h1 class="text-center login-title">Log in</h1>
                    <div class="account-wall">

                        <g:form controller="authentication" action="doLogin" class="form-signin">
                            <p>Email</p>
                            <g:textField name="email" class="form-control" placeholder="Email" required="required" />
                            <br>
                            <p>Password</p>
                            <g:passwordField name="password" class="form-control" placeholder="Password" required="required" />
                            <br>
                            <g:submitButton class="btn btn-lg btn-primary btn-block" name="login" value="Log In"/>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>