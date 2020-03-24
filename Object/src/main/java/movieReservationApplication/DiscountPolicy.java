package movieReservationApplication;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
