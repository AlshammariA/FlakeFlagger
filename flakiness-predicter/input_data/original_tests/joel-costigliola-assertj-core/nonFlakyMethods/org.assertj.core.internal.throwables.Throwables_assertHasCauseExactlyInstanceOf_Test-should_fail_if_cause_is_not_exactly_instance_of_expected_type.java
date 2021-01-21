@Test public void should_fail_if_cause_is_not_exactly_instance_of_expected_type() throws Exception {
  AssertionInfo info=someInfo();
  Class<RuntimeException> expectedCauseType=RuntimeException.class;
  try {
    throwables.assertHasCauseExactlyInstanceOf(info,throwableWithCause,expectedCauseType);
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldHaveCauseExactlyInstance(throwableWithCause,expectedCauseType));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
