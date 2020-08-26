import com.google.gson.Gson;
import models.Sessions;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
//        Sql2oSessionsDao sessionsDao;
//        Sql2oStudentDao studentsDao;
//        Sql2oTechnical_mentorDao technical_mentorDao;
        Connection conn;
        Gson gson = new Gson();

        //ben change this to match the db you have created
        String connectionString = "jdbc:h2:~/class-scheduler.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

//        sessionsDao = new Sql2oSessionsDao(sql2o);
//        studentsDao = new Sql2oStudentsDao(sql2o);
//        technical_mentorDao = new Sql2oTechnical_mentorDao(sql2o);
        conn = sql2o.open();

        //create new session
        post("/sessions/new", "application/json", (request, response) -> {
            Sessions sessions = gson.fromJson(request.body(), Sessions.class);
//            sessionsDao.add(sessions);
            response.status(201);
            response.type("application/json");
            return gson.toJson(sessions);
        });

        //get all sessions
//        get("/session", "application/json", (request, response) -> {
//            response.type("application/json");
//            return gson.toJson(sessionsDao .getAll());
//        });

        //get a session by id
//        get("/session/:id", "application/json",(request, response) -> {
//            response.type("application/json");
//            int sessionId = Integer.parseInt(request.params("id"));
//            response.type("application/json");
//            return gson.toJson(sessionsDao.findById(sessionId));
//        });

        //having trouble creating this 2 below
        //edit an existing session
//        put("/sessions/:id", "application/json",(request, response) -> {
//
//        });

        //delete an existing session
//        delete("/sessions/:id", "application/json",(request, response) -> {
//
//        });

        //filters
        after((request, response) -> {
            response.type("application/json");
        });
    }
}
