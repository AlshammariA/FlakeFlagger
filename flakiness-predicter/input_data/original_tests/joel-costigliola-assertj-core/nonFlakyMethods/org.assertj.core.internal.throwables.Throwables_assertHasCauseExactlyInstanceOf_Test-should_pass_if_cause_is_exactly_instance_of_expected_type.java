@Test public void should_pass_if_cause_is_exactly_instance_of_expected_type() throws Exception {
  throwables.assertHasCauseExactlyInstanceOf(someInfo(),throwableWithCause,IllegalArgumentException.class);
}
