package graspMovieReservation;

public interface DiscountCondition {

    public boolean isSatisfiedBy(Screening screening);
}
