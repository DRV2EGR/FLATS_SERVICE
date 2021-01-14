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

        .img {
            width: 300px;
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
                            <p>${flat.getPrice()}</p>

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

</body>
</html>