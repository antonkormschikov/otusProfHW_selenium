package exeptions;

public class NoFoundCourseExeption extends RuntimeException {
  public NoFoundCourseExeption(String courseName){
    super(String.format("Course %s not found exeption",courseName));
  }
}
