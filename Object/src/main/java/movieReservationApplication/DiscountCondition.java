package movieReservationApplication;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
