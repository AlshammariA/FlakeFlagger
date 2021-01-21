@Test public void should_fail_if_actual_has_elements(){
  AssertionInfo info=someInfo();
  Map<?,?> actual=mapOf(entry("name","Yoda"));
  try {
    maps.assertEmpty(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEmpty(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
