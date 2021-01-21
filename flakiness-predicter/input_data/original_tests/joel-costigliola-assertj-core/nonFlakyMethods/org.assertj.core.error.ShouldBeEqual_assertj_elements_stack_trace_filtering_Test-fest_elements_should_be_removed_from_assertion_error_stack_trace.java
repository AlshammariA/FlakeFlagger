@Test public void fest_elements_should_be_removed_from_assertion_error_stack_trace(){
  Fail.setRemoveAssertJRelatedElementsFromStackTrace(true);
  try {
    assertThat("Xavi").isEqualTo("Xabi");
  }
 catch (  AssertionError assertionError) {
    assertThat(hasStackTraceElementRelatedToAssertJ(assertionError)).isFalse();
  }
}
