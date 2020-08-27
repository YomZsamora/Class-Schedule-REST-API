//package models;
//
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class TechnicalMentorTest {
//    @Test
//    public void mentorInstantiatesCorrectly() {
//        TechnicalMentor technical_mentor = new TechnicalMentor("Samora", "F87dafxvdhfa987");
//        assertEquals(true, technical_mentor instanceof TechnicalMentor);
//    }
//
//    @Test
//    public void getName() {
//        TechnicalMentor technical_mentor = new TechnicalMentor("Samora", "F87dafxvdhfa987");
//        assertEquals("Samora", technical_mentor.getName());
//    }
//
//    @Test
//    public void setName() {
//        TechnicalMentor technical_mentor = new TechnicalMentor("Samora", "F87dafxvdhfa987");
//        technical_mentor.setName("Samora");
//        assertEquals("Samora", technical_mentor.getName());
//    }
//
//    @Test
//    public void getUid() {
//        TechnicalMentor technical_mentor = new TechnicalMentor("Samora", "F87dafxvdhfa987");
//        assertEquals("F87dafxvdhfa987", technical_mentor.getUid());
//    }
//
//    @Test
//    public void setUid() {
//        TechnicalMentor technical_mentor = new TechnicalMentor("Samora", "F87dafxvdhfa987");
//        technical_mentor.setUId("F87dafxvdhfa987");
//        assertEquals("F87dafxvdhfa987", technical_mentor.getUid());
//    }
//
//    @Test
//    public void setId() {
//        TechnicalMentor technical_mentor = new TechnicalMentor("Samora", "F87dafxvdhfa987");
//        technical_mentor.setId(1);
//        assertEquals(1, technical_mentor.getId());
//    }
//}