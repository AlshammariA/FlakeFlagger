@Test public void should_fail_if_actual_has_no_cause() throws Exception {
  AssertionInfo info=someInfo();
  Class<NullPointerException> expectedCauseType=NullPointerException.class;
  try {
    throwables.assertHasCauseInstanceOf(info,actual,expectedCauseType);
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldHaveCauseInstance(actual,expectedCauseType));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
