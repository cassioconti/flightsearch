<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.cassioconti.flightsearch.core.ResponseReader"%>
<%@ page import="com.cassioconti.flightsearch.core.Index"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
  <h1>Flight search</h1>
  <%
  Index index = new Index();
  ResponseReader responseReader = index.Run();
  %>
  <h3>Best price <%=responseReader.getBestPrice()%></h3>
  <c:forEach items="<%=responseReader.getFlights()%>" var="item" varStatus="status">
    <table>
      <tr>
        <th>From</th>
        <th>To</th>
        <th>Leave</th>
        <th>Arrives</th>
        <th>Price</th>
      </tr>
      <c:forEach items="${item.segments}" var="subitem" varStatus="status">
        <tr>
          <td>${subitem.origin}</td>
          <td>${subitem.destination}</td>
          <td>${subitem.departureTime}</td>
          <td>${subitem.arrivalTime}</td>
          <td>${item.saleTotal}</td>
        </tr>
      </c:forEach>
    </table>
    <br />
  </c:forEach>
</body>
</html>