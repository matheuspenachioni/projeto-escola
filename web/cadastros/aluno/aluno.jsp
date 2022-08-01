<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<jsp:include page="/header.jsp"/>
    <div class="text-center">
        <h1>Lista de Alunos</h1>
        <p><a class="text-muted" href="index.jsp">Menu</a> / Lista de Alunos</p>
        <hr>
    </div>
    <div class="container">
       <div class="row">
            <div class="col">
                <table class="table table-striped" id="datatable">
                    <thead>
                        <tr>
                            <th class="text-center">ID</th>
                            <th class="text-center">Nome</th>
                            <th class="text-center">Telefone</th>
                            <th class="text-center">Turma</th>
                            <th class="text-center">Período</th>
                            <th colspan="2" class="text-center">Editar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="aluno" items="${alunos}">
                            <tr>
                                <td align="center">${aluno.idAluno}</td>
                                <td align="center">${aluno.nomeAluno}</td>
                                <td align="center">${aluno.telefoneAluno}</td>
                                <td align="center">${aluno.turma.siglaTurma}</td>
                                <td align="center">${aluno.turma.periodoTurma}</td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/AlunoExcluir?idTurma=${aluno.idAluno}"><i class="fa-solid fa-trash text-danger"></i></a>
                                </td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/AlunoCarregar?idAluno=${aluno.idAluno}"><i class="fa-solid fa-pen-to-square text-info"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div align="center">
        <a href="${pageContext.request.contextPath}/AlunoNovo" class="btn btn-primary">Novo</a>
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