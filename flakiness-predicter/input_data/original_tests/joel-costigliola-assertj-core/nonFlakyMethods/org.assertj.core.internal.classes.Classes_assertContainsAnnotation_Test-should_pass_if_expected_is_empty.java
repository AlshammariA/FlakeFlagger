@SuppressWarnings("unchecked") @Test public void should_pass_if_expected_is_empty(){
  actual=AssertionInfo.class;
  classes.assertContainsAnnotations(someInfo(),actual);
}
