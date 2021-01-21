@Test public void should_fail_if_cause_is_not_instance_of_expected_type() throws Exception {
  AssertionInfo info=someInfo();
  Class<NullPointerException> expectedCauseType=NullPointerException.class;
  try {
    throwables.assertHasCauseInstanceOf(info,throwableWithCause,expectedCauseType);
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldHaveCauseInstance(throwableWithCause,expectedCauseType));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
