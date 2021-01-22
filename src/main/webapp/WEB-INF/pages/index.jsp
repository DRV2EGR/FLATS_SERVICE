<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/index.css" >



    <style>
        .profile-ico {
            border-radius: 100%;
        }
    </style>

    <!-- CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <!-- jQuery and JS bundle w/ Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar w/ text</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                </ul>
                <span class="navbar-text" style="margin-left: calc(100% - 400px);">
                    <sec:authorize access="!isAuthenticated()">
                        <img src="https://html5css.ru/w3images/avatar6.png" class="profile-ico">
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <img src="" class="profile-ico">
                    </sec:authorize>
                </span>
            </div>
        </div>
    </nav>


    <div class="my-content">
        <div class="my-section">

            <c:forEach items="${flats}" var="flat">
                <a href="">

                    <div class="my-card">
                        <div class="my-img">
                            <img src="${flat.getImgByIndex(0)}">
                        </div>

                        <div class="my-card-content">
                            <p>Цена: <span class="my-price">${flat.getPrice()}</span></p>

                            <p>${flat.getAdress()}</p>

                            <p>Комнат: ${flat.getNumOfRooms()}</p>
                            <p>Владелец: ${flat.getOwner().getName()} ${flat.getOwner().getSecondName()} <br> ${flat.getOwner().getPhone()}</p>

                            <input type="button" value="Посмотреть">
                        </div>
                    </div>
                </a>
            </c:forEach>

        </div>
    </div>

    <script>
        function moneyFormat(n) {

            return parseFloat(n).toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1 ").replace('.', ',');
        }


        let prices = document.getElementsByClassName("price");

        for (i = 0; i < prices.length; ++i) {
            prices[i].textContent = moneyFormat(prices[i].textContent);
        }
    </script>
</body>
</html>