<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Login</h1>
            <pre>${errorMessage}</pre>
            <form method="POST" action="/login">
                Name: <input type="text" name="username" /> Password:
                <input type="password" name="password" />
                <input type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>
