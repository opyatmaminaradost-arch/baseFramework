package base;

import steps.*;

public abstract class BaseBookingTest extends BaseTest {

  protected final CreateBookingStep createBookingStep = new CreateBookingStep(requestSpec);
  protected final GetBookingByIdStep getBookingByIdStep = new GetBookingByIdStep(requestSpec);
  protected final GetBookingStep getBookingStep = new GetBookingStep(requestSpec);
 
}

