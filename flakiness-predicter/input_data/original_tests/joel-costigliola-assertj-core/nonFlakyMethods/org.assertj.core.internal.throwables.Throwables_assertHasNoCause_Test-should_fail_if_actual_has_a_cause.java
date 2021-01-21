@Test public void should_fail_if_actual_has_a_cause(){
  AssertionInfo info=someInfo();
  Throwable throwableWithCause=new Throwable(new NullPointerException());
  try {
    throwables.assertHasNoCause(info,throwableWithCause);
    fail("AssertionError expected");
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldHaveNoCause(throwableWithCause));
  }
}
