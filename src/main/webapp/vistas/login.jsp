<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <!-- Incluir Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="../styles/styles.css">
    </head>
    
    <body>

        <div class="formulario container-fluid align-items-center">
            <div class="row justify-content-center">
                
                <div class="card" style="background-color: rgb(48, 48, 48); color: gainsboro">
                        <div class="card-body">
                            <h2 class="card-title text-center">Iniciar Sesión</h2>
                            <form action="LoginServlet" method="post" class="mt-4">
                                <div class="form-group mt-2">
                                    <label for="username">Nombre de Usuario</label>
                                    <input type="text" class="form-control" id="username" name="username" required>
                                </div>
                                <div class="form-group mt-2">
                                    <label for="password">Contraseña</label>
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-light btn-block">Iniciar Sesión</button>
                                <a href="../" class="btn btn-light">Volver</a>
                            </form>
                        </div>
                    </div>
                
            </div>
        </div>

        <!-- Incluir Bootstrap Javascript y sus dependencias -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>

