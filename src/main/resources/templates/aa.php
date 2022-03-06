<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Bottom navbar example · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/navbar-bottom/">



    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <header class="p-3 bg-dark text-white ">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <h1 class="h4 mt-1 mx-5 fw-bold text-secondary">LOGO/BRAND</h1>
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="./index.html" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="./transacition.html" class="nav-link px-2 text-info">Transacition</a></li>
                    <li><a href="./profile.html" class="nav-link px-2 text-white">Profile</a></li>
                </ul>
            </div>
        </div>
    </header>
    <main>
        <div class="container py-4">
            <h1 class="mt-3 h4 px-3 text-muted">Transacition</h1>
            <div class="list-group list-group-flush status">


            </div>
        </div>
    </main>

    <!-- Modal -->
    <div class="modal fade" id="review" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-fullscreen">
            <div class="modal-content">
                <header class="p-3 bg-dark text-white ">
                    <div class="container">
                        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                            <h1 class="h4 mt-1 mx-5 fw-bold text-secondary">LOGO/BRAND</h1>
                            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                                <li><a href="./index.html" class="nav-link px-2 text-white">Home</a></li>
                                <li><a href="./profile.html" class="nav-link px-2 text-white">Profile</a></li>
                                <li><a href="./transacition.html" class="nav-link px-2 text-white">Transacition</a></li>
                            </ul>
                        </div>
                    </div>
                </header>
                <main>
                    <div class="container py-4">
                        <h2>Product Detail</h2>
                        <div class="row">
                            <div class="col-md-4">
                                <img src="../assets/d6.jpg" class="card-img-top" alt="" height="300px">
                            </div>
                            <div class="col-md-6">
                                <div class="card-body detail">
                                </div>
                                <div class="from"></div>

                            </div>
                        </div>
                        <h1 class="mt-3 h4 px-3 text-muted">Ulasan</h1>
                        <div class="list-group list-group-flush rw-list">



                        </div>
                    </div>
                </main>
            </div>
        </div>
    </div>

    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../assets/axios.min.js"></script>
    <script src="../assets/jquery-3.6.0.min.js"></script>


    <script>
        $(function() {

            $(document).ready(function() {
                var get = JSON.parse(localStorage.getItem("session"));
                var token = get.data.access_token;
                var email = get.data.email;
                axios
                    .get('http://localhost:8083/customer/transactions', {
                        headers: {
                            "Access-Control-Allow-Origin": "*",
                            "Content-type": "Application/json",
                            "Authorization": `Bearer ${token}`
                        }
                    })
                    .then(function(response) {
                        console.log(response)
                        $.each(response.data.payload, function(key, values) {



                            if (values.emailUser == email) {
                                $('.status').append(`

                                                   <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
                    <img src="../assets/brand/bootstrap-logo.svg" alt="twbs" width="32" height="32"
                        class="rounded-circle flex-shrink-0">
                    <div class="d-flex gap-2 w-100 justify-content-between">
                        <div>
                            <h6 class="mb-0">${values.nameItem}</h6>
                            <p class="mb-0 opacity-75">Amount Rm${values.total} </p>
                        </div>
                        <small class="fw-bold h6 text-nowrap">
                            <span>
                               <p> ON ${values.status}</p>
                               <button class="btn btn-sm btn-warning bg-gardient px-4 review" value="${values.id}">Review</button>
                                </span>
                        </small>
                    </div>
                </a>`);
                            } else {
                                "<h3>Anda Belum Punya Transacition</h3>"
                            }



                        });

                    })

                    .catch(function(error) {
                        console.log(error)
                        // alert('ERROR');
                    });
            });


            $(document).on('click', '.review', function(e) {
                e.preventDefault();
                var id = $(this).val();
                $('#review').modal('show');
                var get = JSON.parse(localStorage.getItem("session"));
                var token = get.data.access_token;
                var email = get.data.email;
                axios
                    .get('http://localhost:8083/customer/transactions', {
                        headers: {
                            "Access-Control-Allow-Origin": "*",
                            "Content-type": "Application/json",
                            "Authorization": `Bearer ${token}`
                        }
                    })
                    .then(function(response) {
                        console.log(response)
                        //  var row = 0;
                        //  var c = response.data.payload.length
                        $.each(response.data.payload, function(key, values) {
                            // console.log(c);
                            if (values.id == id) {
                                //    console.log(c);
                                $('.detail').append(`
                                <h1 class="card-title">OMPUS</h1>
                                <p class="text-muted">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Atque, officiis!</p>
            
                                <h1 class="h6 fw-bold mt-3">Rating</h1>
                                <h1 class="h6 fw-bold"><span><img src="../assets/star.svg" style="width: 20px;" alt=""
                                            srcset=""></span> ${values.rate}
                                    <span class="text-muted">(120)</span>
                                </h1>
                                
                                `);

                                if (values.status == 'COMPLETE') {
                                    $('.from').append(`

                                  <div class="col-12 car-body p-3">
                                        <label for="inputEmail4" class="form-label">Riview</label>
                                        <input type="hidden" class="form-control idrw" value="${values.id}">
                                            <select id="inputState" class="form-select mb-3 rate">
                                            <option value="5">5</option>
                                            <option value="4">4</option>
                                            <option value="3">3</option>
                                            <option value="2">2</option>
                                            <option value="1">1</option>
                                        </select>
                                        <input type="text" class="form-control setrw" value="">
                                    </div>

                                    <button class="w-100  btn m-3  btn-warning bg-gardient btn-rw" type="button">Riview</button>
                                `);

                                }


                            } else {
                                "<h3>Anda Belum Punya Transacition</h3>"
                            }
                            $('.rw-list').append(`
                            <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3"
                                aria-current="true">
                                <img src="../assets/brand/bootstrap-logo.svg" alt="twbs" width="32" height="32"
                                    class="rounded-circle flex-shrink-0">
                                <div class="d-flex gap-2 w-100 justify-content-between">
                                    <div>
                                        <h6 class="mb-0">Username</h6>
                                        <p class="mb-0 opacity-75">Some placeholder content in a paragraph.</p>
                                    </div>
                                    <small class="opacity-50 text-nowrap">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                    </small>
                                </div>
                            </a>
                                       `);




                        });

                    })

                    .catch(function(error) {
                        console.log(error)
                        // alert('ERROR');
                    });

            });
            // =============================================================================================================
            // EVENT CREATE
            // =============================================================================================================
            $(document).ready(function() {
                var get = JSON.parse(localStorage.getItem("session"));
                var token = get.data.access_token;


                axios
                    .get('http://localhost:8083/customer/transactions/total-rating', {
                        headers: {
                            "Access-Control-Allow-Origin": "*",
                            "Content-type": "Application/json",
                            "Authorization": `Bearer ${token}`
                        }
                    })
                    .then(function(response) {
                        console.log(response)
                        $.each(response.data.payload, function(key, values) {

                            $('.rw-list').append(`
                            <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3"
                                aria-current="true">
                                <img src="../assets/brand/bootstrap-logo.svg" alt="twbs" width="32" height="32"
                                    class="rounded-circle flex-shrink-0">
                                <div class="d-flex gap-2 w-100 justify-content-between">
                                    <div>
                                        <h6 class="mb-0">Username</h6>
                                        <p class="mb-0 opacity-75">Some placeholder content in a paragraph.</p>
                                    </div>
                                    <small class="opacity-50 text-nowrap">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                        <img src="../assets/star.svg" style="width: 20px;" alt="" srcset="">
                                    </small>
                                </div>
                            </a>
                                       `);




                        });
                        //   location.reload();
                    })
                    .catch(function(error) {
                        console.log(error)
                    });
            });


            // =============================================================================================================
            // EVENT CREATE
            // =============================================================================================================
            $(document).on('click', '.btn-rw', function(e) {
                e.preventDefault();
                var get = JSON.parse(localStorage.getItem("session"));
                var token = get.data.access_token;
                var data = {
                    "idTransaction": $('.idrw').val(),
                    "rate": $('.rate').val(),
                    "review": $('.setrw').val(),
                };
                console.log(data);
                axios
                    .post('http://localhost:8083/customer/transactions/save/rating', data, {
                        headers: {
                            "Access-Control-Allow-Origin": "*",
                            "Content-type": "Application/json",
                            "Authorization": `Bearer ${token}`
                        }
                    })
                    .then(function(response) {
                        // console.log(response)
                        alert('success')
                        location.reload();
                    })
                    .catch(function(error) {
                        alert('ERROR')
                        console.log(error)
                    });
            });
        });
    </script>
</body>

</html>