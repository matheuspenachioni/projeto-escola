<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<jsp:include page="/header.jsp"/>

    <div class="text-center">
        <h1>Cadastro de Turmas</h1>
        <p><a class="text-muted" href="index.jsp">Menu</a> / Cadastro de Turmas</p>
        <hr>
        <p>${mensagem}</p>
        <hr>
    </div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <form name="cadastrarturma" action="TurmaCadastrar" method="POST" class="row g-3">
                    <div class="mb-3">
                        <label for="f1" class="form-label">ID</label>
                        <input type="number" name="idturma" class="form-control" id="f1" value="${turma.idTurma}" readonly/>
                    </div>
                    <div class="mb-3">
                        <label for="f2" class="form-label">Sigla</label>
                        <input type="text" name="siglaturma" class="form-control" id="f2" value="${turma.siglaTurma}"/>
                    </div>
                    <div class="mb-3">
                        <label for="f3" class="form-label">Período</label>
                        <input type="text" name="periodoturma" class="form-control" id="f3" value="${turma.periodoTurma}"/>
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