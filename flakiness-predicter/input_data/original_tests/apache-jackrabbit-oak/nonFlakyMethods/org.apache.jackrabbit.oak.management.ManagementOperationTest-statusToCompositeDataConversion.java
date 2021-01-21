@Test public void statusToCompositeDataConversion(){
  checkConversion(Status.unavailable(42,"forty two"));
  checkConversion(Status.none(43,"forty three"));
  checkConversion(Status.initiated(44,"forty four"));
  checkConversion(Status.running(45,"forty five"));
  checkConversion(Status.succeeded(46,"forty six"));
  checkConversion(Status.failed(47,"forty seven"));
}
