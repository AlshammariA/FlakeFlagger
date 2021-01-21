@Test public void should_fail_if_actual_has_elements(){
  AssertionInfo info=someInfo();
  Collection<String> actual=newArrayList("Yoda");
  try {
    iterables.assertNullOrEmpty(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeNullOrEmpty(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
