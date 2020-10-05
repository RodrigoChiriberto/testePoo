<%-- 
    
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.fatecpg.avaliacaoPoo.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String error = "";
    int i = -1;
    
    if (request.getParameter("alterarNota") != null){
        try {
                i = Integer.parseInt(request.getParameter("index"));
                Disciplina disc = Disciplina.getList().get(i);
                disc.setNota(Float.parseFloat(request.getParameter("novaNota")));
                Disciplina.getList().set(i, disc);
                
            } catch (Exception e) {
                error = e.getMessage();
            }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/css/style.css" />
        <link rel="stylesheet" href="<%= request.getContextPath() %>/styles/css/bootstrap.css" />
        <title>Minhas Disciplinas</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <div class="step">
            <h2>Minhas disciplinas</h2>
            <br>
            <table class="table table-hover table-stripped" style="background-color: #FFFFFF">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Ementa</th>
                        <th>Semestre n°</th>
                        <th>Nota</th>
                        <th>Alterar nota?</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Disciplina disc: Disciplina.getList()) {%>
                    
                        
                    
                        <tr>

                            <td><%= disc.getName() %></td>
                            <td><%= disc.getEmenta()%></td>
                            <td><%= disc.getCiclo()%></td>
                            <td><%= disc.getNota()%></td>
                            <td style="width: 100px">
                                <form method="get">
                                    <input class="form-control" type="number" min="0" max="10" step="0.1" placeholder="0.0" name="novaNota" />
                                    <% int index = Disciplina.getList().indexOf(disc); %>
                                    <input type="submit" class="btn-block" name="alterarNota" value="Alterar" />
                                    <input type="hidden" name="index" value="<%= index %>" />
                                    
                                </form>
                            </td>
                        </tr>
                    <%}%>        
                    
                    
                </tbody>
            </table>
        </div>
        
    </body>
</html>
