@Test public void should_fail_if_actual_is_empty(){
  AssertionInfo info=someInfo();
  try {
    maps.assertNotEmpty(info,emptyMap());
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEmpty());
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
