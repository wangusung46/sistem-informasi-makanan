<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Halaman Login</title>

    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">


    <style>
        body {
            display: flex;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }
    </style>


</head>

<body>

    <main class="form-signin container d-flex justify-content-center">
        <form class="col col-sm-5">
            <div class="text-center">
                <!-- <img class="mb-4 " src="assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
                <h1 class="h1 text-primary mb-5 fw-bold">Sign in</h1>
            </div>
            <h1 class="h3 mb-3 fw-normal">Welcome to</h1>
            <p class="mt-3 mb-3 text-muted col-7">Enter your Email address for sign in</a></p>

            <div class="form-floating mb-2">
                <input type="text" class="form-control username">
                <label for="floatingInput">username</label>
            </div>
            <div class="form-floating mb-2">
                <input type="password" class="form-control pwd">
                <label for="floatingPassword">Password</label>
            </div>
            <button class="w-100 mt-4 btn btn-lg btn-primary bg-gardient login" type="button">Sign In</button>

            <div class="text-center mt-3 text-muted">
                Don't have an account? <a class="text-decoration-none" href="singup.html">Signup</a>
            </div>
            <!-- <p class="mt-3 text-center mb-3 text-muted">&copy; 2022 </p> -->
        </form>
    </main>
    <!-- <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.0/axios.min.js"></script>
    <!-- <script src="assets/dist/js/bootstrap.bundle.min.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script>
        $(function() {
            $(document).on('click', '.login', function(e) {
                e.preventDefault();
                const a = [];
                const data = {
                    'password': $('.pwd').val(),
                    'username': $('.username').val(),
                }

                const rawData = new URLSearchParams(Object.keys(data).map(key => [key, data[key]]));
                axios
                    .post('http://localhost:8083/login', rawData.toString())
                    .then(function(response) {
                        // a.push(response)
                        localStorage.setItem('session', JSON.stringify(response));
                        var get = JSON.parse(localStorage.getItem("session"));


                        if (response.data.id == "ROLE_ADMIN") {

                            window.location.href = "Managing_staf";
                            alert("ROLE_ADMIN");
                        } else if (response.data.id == "ROLE_DRIVER") {

                            alert("ROLE_DRIVER");
                            // alert(get[0].email);
                        } else {
                            
                            alert("ROLE_CUSTOMER");
                            // alert(get[0].email);

                        }
                        console.log(response.data.id);
                        // console.log(response);
                    })
                    .catch(function(error) {
                        console.log(error);
                    });






            });
        });
    </script>
</body>

</html>