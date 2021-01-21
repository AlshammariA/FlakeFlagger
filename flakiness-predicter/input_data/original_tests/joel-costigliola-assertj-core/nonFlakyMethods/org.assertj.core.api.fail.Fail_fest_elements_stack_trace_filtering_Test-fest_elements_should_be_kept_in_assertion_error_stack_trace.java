@Test public void fest_elements_should_be_kept_in_assertion_error_stack_trace(){
  Fail.setRemoveAssertJRelatedElementsFromStackTrace(false);
  try {
    assertThat(5).isLessThan(0);
  }
 catch (  AssertionError assertionError) {
    assertThat(hasStackTraceElementRelatedToAssertJ(assertionError)).isTrue();
  }
}
