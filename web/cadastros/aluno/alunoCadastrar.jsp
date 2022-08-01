<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<jsp:include page="/header.jsp"/>

<div class="text-center">
        <h1>Cadastro de Alunos</h1>
        <p><a class="text-muted" href="index.jsp">Menu</a> / Cadastro de Aluno</p>
        <hr>
        <p>${mensagem}</p>
        <hr>
    </div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <form name="cadastraraluno" action="AlunoCadastrar" method="POST" class="row g-3">
                    <div class="mb-3">
                        <label for="f1" class="form-label">ID</label>
                        <input type="number" name="idaluno" class="form-control" id="f1" value="${aluno.idAluno}" readonly/>
                    </div>
                    <div class="mb-3">
                        <label for="f2" class="form-label">Nome</label>
                        <input type="text" name="nomealuno" class="form-control" id="f2" value="${aluno.nomeAluno}"/>
                    </div>
                    <div class="mb-3">
                        <label for="f4" class="form-label">Turma</label>
                        <select name="idturma" class="form-select" id="f4">
                            <option>Selecione...</option>
                            <c:forEach var="turma" items="turmas">
                                <option value="${turma.idTurma}" ${turma.idTurma == aluno.turma.idTurma ? 'selected' : ''}>
                                    ${turma.siglaTurma}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="f3" class="form-label">Telefone</label>
                        <input type="text" name="telefonealuno" class="form-control" id="f3" value="${aluno.telefoneAluno}"/>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary" id="cadastrar">Cadastrar</button>
                        <button type="reset" class="btn btn-danger" id="limpar">Limpar</button>
                    </div>       
                </form>
            </div>
        </div>
    </div>

<%@ include file="/footer.jsp" %>