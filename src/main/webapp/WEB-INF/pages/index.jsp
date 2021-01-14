<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html lang="en">
<head>
    <style>
        .content {
            margin: 0 auto;
            display: flex;

            flex-direction: row;
        }

        .section {
            margin: 0 auto;
            padding: 10px;

            display: flex;
            flex-direction: column;

            width: 100%;
        }

        .card {
            display: flex;
            flex-direction: row;

            width: 100%;
            height: 350px;
            margin: 10px;

            word-wrap: inherit;

            background: #84a4cb;
        }

        img {
            width: 250px;
            height: 300px;

            padding: 15px;

            margin-left: 15px;
            margin-right: 10px;
        }

        p {
            color: black;
        }

        h3 {
            color: black;
            font-weight: bold;
        }

        a {
            text-decoration: none;
            text-decoration-line: none;
        }

        .card-content {
            margin-top: 30px;
            margin-left: 50px;
        }

        .price {
            color: black;

            font-weight: bold;
            font-size: 2em;
        }

    </style>
</head>
<body>

    <div class="content">
        <div class="section">

            <c:forEach items="${flats}" var="flat">
                <a href="">

                    <div class="card">
                        <div class="img">
                            <img src="${flat.getImgByIndex(0)}">
                        </div>

                        <div class="card-content">
                            <p>Цена: <span class="price">${flat.getPrice()}</span></p>

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