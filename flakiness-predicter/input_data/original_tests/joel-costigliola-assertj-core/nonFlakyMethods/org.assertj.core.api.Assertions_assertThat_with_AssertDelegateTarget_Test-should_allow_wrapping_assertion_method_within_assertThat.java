@Test public void should_allow_wrapping_assertion_method_within_assertThat(){
  MyAssertDelegateTarget assertion=new MyAssertDelegateTarget(true);
  assertThat(assertion).isCompletelyTrue();
  Object result=assertThat(assertion);
  assertThat(result).isSameAs(assertion);
}
