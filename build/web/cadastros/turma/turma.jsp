<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<jsp:include page="/header.jsp"/>
    <div class="text-center">
        <h1>Lista de Turmas</h1>
        <p><a class="text-muted" href="index.jsp">Menu</a> / Lista de Turmas</p>
        <hr>
    </div>
    <div class="container">
       <div class="row">
            <div class="col">
                <table class="table table-striped" id="datatable">
                    <thead>
                        <tr>
                            <th class="text-center">ID</th>
                            <th class="text-center">Sigla</th>
                            <th class="text-center">Periodo</th>
                            <th colspan="2" class="text-center">Editar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="turma" items="${turmas}">
                            <tr>
                                <td align="center">${turma.idTurma}</td>
                                <td align="center">${turma.siglaTurma}</td>
                                <td align="center">${turma.periodoTurma}</td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/TurmaExcluir?idTurma=${turma.idTurma}"><i class="fa-solid fa-trash text-danger"></i></a>
                                </td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/TurmaCarregar?idTurma=${turma.idTurma}"><i class="fa-solid fa-pen-to-square text-info"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div align="center">
        <a href="${pageContext.request.contextPath}/TurmaNovo" class="btn btn-primary">Novo</a>
        <a href="index.jsp" class="btn btn-danger">Voltar</a>
    </div>

    <script>
        $(document).ready(function() {
            console.log('entrei ready');
            $('#datatable').DataTable({
                "oLanguage": {
                    "sProcessing": "Processando...",
                    "sLenghtMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "Nenhum registro encontrado.",
                    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                    "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                    "sInfoFiltered": "",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "oPaginate": {
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Último"
                    }
                }
            });
        });
    </script>
    
<%@ include file="/footer.jsp" %>