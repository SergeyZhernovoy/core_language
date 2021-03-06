package annotation.simple_example;

/**
 * @author Sergey Zhernovoy
 *         create on 06.07.2017.
 */
public @interface Review {

    ReviewStatus status() default ReviewStatus.PENDING;

    String comments() default "";

    public enum ReviewStatus {PENDING,FAILED, PASSED, PASSEDWITHCHANGES}

}
