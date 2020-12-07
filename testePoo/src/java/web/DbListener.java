/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

/**
 *
 * @author rodrigo.matos
 */

import br.edu.fatecpg.avaliacaoPoo.Disciplina;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import java.sql.*;
import javax.servlet.*;


public class DbListener {
    
    public static final String URL = "jdbc:sqlite:C:\\Users\\rodrigo.matos\\OneDrive - Fatec Centro Paula Souza\\P2_Bim2\\sqlite-jdbc-3.30.1";
    
    public static String exceptionMessage = null;
    
    
    public void contextInitialized(ServletContextEvent sce){
        try{
            Class.forName("org.sqlite.JDBC");
            
            Connection con = DriverManager.getConnection(URL);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("create table if not exists disciplinas("
                    + "id integer primary key autoincrement not null, "
                    + "nm varchar(50) not null, "
                    + "emt varchar(10000), "
                    + "ciclo integer not null, "
                    + "nt float)");
            
            if(Disciplina.getList().isEmpty()){
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Gestão de Projetos', 'Definição de projeto segundo "
                        + "concepção difundida pelas melhores práticas de gestão de projetos. Histórico do desenvolvimento do conjunto "
                        + "de conhecimentos de gestão de projetos. Comparação ente o gerenciamento por projetos com o gerenciamento "
                        + "tradicional. O ciclo de vida de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. "
                        + "As nove de conhecimento para a gestão de projetos e seus processos : Integração, Escopo, Tempo, Custo, "
                        + "Qualidade, Recursos Humanos, Comunicações, Riscos e Aquisições', 5, 0)");
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Laboratório de Banco de Dados', 'Tecnologias emergentes "
                        + "de mercado que serão aplicadas em laboratório', 5, 0)");
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Laboratório de Engenharia de Software', "
                        + "'Desenvolvimento de um software utilizando os conhecimentos adquiridos ao longo do curso. "
                        + "A elaboração deve abordar as disciplinas de requisitos, análise e projeto, implementação, "
                        + "implantação e gerência de projetos. O processo de desenvolvimento, assim como a técnica fica "
                        + "a critério de acordo entre professor e aluno', 5, 0)");
                
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Programação para Dispositivos Móveis', 'Ambientes "
                        + "de programação para dispositivos móveis. Emuladores. Interface gráfica, serviços baseados em localização, "
                        + "armazenamento de dados persistentes, serviços de telefonia e comunicação entre processos. Desenvolvimento"
                        + " de aplicações com J2ME', 5, 0)");
                
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Redes de Computadores', 'Comunicação de Dados. Topologia e Características Físicas de Redes. Redes Locais de Longa Distância. Redes de Alta Velocidade. Protocolos e Serviços de Comunicação. Camadas de Sistemas Abertos. Sistemas Operacionais de Redes. Interconexão de redes. Avaliação de Desempenho. Estrutura e Funcionamento da Internet', 5, 0)");
                
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Segurança da Informação', 'Requisitos de segurança de aplicações, de base de dados e de comunicações. Segurança de dispositivos móveis. Políticas de segurança. Criptografia. Firewalls. Vulnerabilidades e principais tecnologias de segurança', 5, 0)");
                
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Inglês V', 'Aprofundamento da compreensão e produção oral e escrita por meio funções sociais e estruturas mais complexas da língua. Ênfase na oralidade, atendendo às especificidades acadêmico-profissionais da área e abordando aspectos sócio-culturais da língua inglesa', 5, 0)");
                
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Trabalho de Graduação I', 'O estudante "
                        + "elaborará, sob a orientação de docente, um Trabalho de Graduação, e o apresentará perante uma "
                        + "banca examinadora. As disciplinas de Projetos deverão subsidiar o trabalho de graduação, com"
                        + " temas e propostas de projetos, casos, etc', 5, 0)");
                
                stmt.executeUpdate("insert into disciplinas values ($next_id, 'Programação Orientada a Objetos', 'Conceitos "
                        + "e evolução da tecnologia de orientação a objetos. Limitações e diferenças entre o paradigma da programação "
                        + "estruturada em relação à orientação a objetos. Conceito de objeto, classe, métodos, atributos, herança, polimorfismo,"
                        + " agregação, associação, dependência, encapsulamento, mensagem e suas respectivas notações na "
                        + "linguagem padrão de representação da orientação a objetos. Implementação de algoritmos orientado "
                        + "a objetos utilizando linguagens de programação. Aplicação e uso das estruturas fundamentais da "
                        + "orientação a objetos', 4, 0)");
                
                stmt.close();
                con.close();
                
            }
        }
        
        catch(Exception ex){
            exceptionMessage = ex.getMessage();
        }
        
        
    }
    
    
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
