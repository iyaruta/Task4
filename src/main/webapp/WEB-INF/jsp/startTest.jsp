<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="table">
    <thead>
    <tr>
      <th>#</th>
    </tr>
    </thead>
  <tbody>
  <c:forEach items="${test}" var="testes" varStatus="status">
    <tr>
      <th> scope="id">${status.index + 1}</th>

      <td>${testes.question}</td>
    </tr>
  </c:forEach>
  </tbody>
  <p>How much color rainbow </p>
  <p>
    <button type="button" class="btn btn-default btn-lg">a</button>
    <a type="text"> answer </a>
  </p>
  <p>
    <button type="button" class="btn btn-default btn-xs">b</button>
    <a type="text"> answer </a>
  </p>
  <p>
    <button type="button" class="btn btn-default btn-sm">c</button>
    <a type="text"> answer </a>
  </p>
  <p>
    <button type="button" class="btn btn-default btn-xs">d</button>
    <a type="text"> answer </a>
  </p>

  <p>
    <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
  </p>
</div>




