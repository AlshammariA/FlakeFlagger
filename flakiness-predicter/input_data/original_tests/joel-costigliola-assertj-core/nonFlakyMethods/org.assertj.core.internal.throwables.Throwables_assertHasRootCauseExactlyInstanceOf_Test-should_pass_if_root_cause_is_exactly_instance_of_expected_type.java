@Test public void should_pass_if_root_cause_is_exactly_instance_of_expected_type() throws Exception {
  throwables.assertHasRootCauseExactlyInstanceOf(someInfo(),throwableWithCause,IllegalArgumentException.class);
}
