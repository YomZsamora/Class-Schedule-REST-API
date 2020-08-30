import com.google.gson.Gson;
import dao.*;
import models.*;
import models.Module;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oSessionDao sessionDao;
        Sql2oStudentDao studentDao;
        Sql2oTechnicalMentorDao technicalMentorDao;
        Sql2oModuleDao moduleDao;
        Sql2oCommentDao commentDao;
        Sql2oCohortDao cohortDao;
        Connection conn;
        Gson gson = new Gson();

        //TODO ben change this to match the db you have created
        String connectionString = "jdbc:h2:~/class-schedule.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "gideon","33450715");

        sessionDao = new Sql2oSessionDao(sql2o);
        studentDao = new Sql2oStudentDao(sql2o);
        technicalMentorDao = new Sql2oTechnicalMentorDao(sql2o);
        moduleDao = new Sql2oModuleDao(sql2o);
        cohortDao = new Sql2oCohortDao(sql2o);
        commentDao = new Sql2oCommentDao(sql2o);

        conn = sql2o.open();

        //create new session
        post("/session/new", "application/json", (request, response) -> {
            Sessions sessions = gson.fromJson(request.body(), Sessions.class);
            sessionDao.add(sessions);
            response.status(201);
            response.type("application/json");
            return gson.toJson(sessions);
        });

        //get all sessions
        get("/sessions", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(sessionDao .getAll());
        });

        //get a session by id
        get("/session/:id", "application/json",(request, response) -> {
            response.type("application/json");
            int sessionId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(sessionDao.findById(sessionId));
        });

        //having trouble creating this 2 below
        //edit an existing session
//        put("/sessions/:id", "application/json",(request, response) -> {
//
//        });

        //delete an existing session
        delete("sessions/session/:id", "application/json",(request, response) -> {
            int sessionsId = Integer.parseInt(request.params("id"));
            Sessions sessionToDelete = sessionDao.findById(sessionsId);
            sessionDao.deleteById(sessionsId);
            return gson.toJson(sessionToDelete);
        });

        //STUDENTS
        //create new student
        post("/student/new", "application/json", (request, response) -> {
            Students students = gson.fromJson(request.body(), Students.class);
            studentDao.add(students);
            response.status(201);
            response.type("application/json");
            return gson.toJson(students);
        });

        //get all students
        get("/students", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(studentDao.getAll());
        });

        //get student by id
        get("/student/:id", "application/json",(request, response) -> {
            response.type("application/json");
            int studentId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(studentDao.findById(studentId));
        });

        //edit an existing student
//        put("/student/:id", "application/json",(request, response) -> {
//
//        });

        //delete an existing student
        delete("student/student/:id", "application/json",(request, response) -> {
            int studentId = Integer.parseInt(request.params("id"));
            Students studentToDelete = studentDao.findById(studentId);
            studentDao.deleteById(studentId);
            return gson.toJson(studentToDelete);
        });

        //MENTORS
        //create new mentor
        post("/mentor/new", "application/json", (request, response) -> {
            TechnicalMentor technicalMentor = gson.fromJson(request.body(), TechnicalMentor.class);
            technicalMentorDao.add(technicalMentor);
            response.status(201);
            response.type("application/json");
            return gson.toJson(technicalMentor);
        });

        //get all mentors
        get("/mentors", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(technicalMentorDao.getAll());
        });

        //get a mentor by id
        get("/mentor/:id", "application/json",(request, response) -> {
            response.type("application/json");
            int technicalMentorId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(technicalMentorDao.findById(technicalMentorId));
        });

        //having trouble creating this 2 below
        //edit an existing mentor
//        put("/mentor/:id", "application/json",(request, response) -> {
//
//        });

        //delete an existing mentor
        delete("mentor/mentor/:id", "application/json",(request, response) -> {
            int mentorId = Integer.parseInt(request.params("id"));
            TechnicalMentor mentorToDelete = technicalMentorDao.findById(mentorId);
            technicalMentorDao.deleteById(mentorId);
            return gson.toJson(mentorToDelete);
        });

        //MODULES
        //create new module
        post("/module/new", "application/json", (request, response) -> {
            Module module = gson.fromJson(request.body(), Module.class);
            moduleDao.add(module);
            response.status(201);
            response.type("application/json");
            return gson.toJson(module);
        });

        //get all module
        get("/modules", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(moduleDao .getAll());
        });

        //get a module by id
        get("/module/:id", "application/json",(request, response) -> {
            response.type("application/json");
            int moduleId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(moduleDao.findById(moduleId));
        });

        //having trouble creating this 2 below
        //edit an existing module
//        put("/module/:id", "application/json",(request, response) -> {
//
//        });

        //delete an existing module
        delete("module/module/:id", "application/json",(request, response) -> {
            int moduleId = Integer.parseInt(request.params("id"));
            Module moduleToDelete = moduleDao.findById(moduleId);
            moduleDao.deleteById(moduleId);
            return gson.toJson(moduleToDelete);
        });

        //COHORTS
        //create new cohort
        post("/cohort/new", "application/json", (request, response) -> {
            Cohort cohort = gson.fromJson(request.body(), Cohort.class);
            cohortDao.add(cohort);
            response.status(201);
            response.type("application/json");
            return gson.toJson(cohort);
        });

        //get all cohorts
        get("/cohorts", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(cohortDao .getAll());
        });

        //get a cohort by id
        get("/cohort/:id", "application/json",(request, response) -> {
            response.type("application/json");
            int cohortId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(cohortDao.findById(cohortId));
        });

        //having trouble creating this 2 below
        //edit an existing cohort
//        put("/cohort/:id", "application/json",(request, response) -> {
//
//        });

        //delete an existing cohort
        delete("cohort/cohort/:id", "application/json",(request, response) -> {
            int cohortId = Integer.parseInt(request.params("id"));
            Cohort cohortToDelete = cohortDao.findById(cohortId);
            cohortDao.deleteById(cohortId);
            return gson.toJson(cohortToDelete);
        });

        //COMMENTS
        //create new comment
        post("/comment/new", "application/json", (request, response) -> {
            Comments comments = gson.fromJson(request.body(), Comments.class);
            commentDao.add(comments);
            response.status(201);
            response.type("application/json");
            return gson.toJson(comments);
        });

        //get all comments
        get("/comments", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(commentDao .getAll());
        });

        //get a comment by id
        get("/comment/:id", "application/json",(request, response) -> {
            response.type("application/json");
            int commentId = Integer.parseInt(request.params("id"));
            response.type("application/json");
            return gson.toJson(commentDao.findById(commentId));
        });

        //having trouble creating this 2 below
        //edit an existing comment
//        put("/comment/:id", "application/json",(request, response) -> {
//
//        });

        //delete an existing comment
        delete("comment/comment/:id", "application/json",(request, response) -> {
            int commentId = Integer.parseInt(request.params("id"));
            Comments commentToDelete = commentDao.findById(commentId);
            commentDao.deleteById(commentId);
            return gson.toJson(commentToDelete);
        });

        //filters
        after((request, response) -> {
            response.type("application/json");
        });
    }
}
