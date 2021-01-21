@Test public void should_fail_if_actual_does_not_contain_key(){
  AssertionInfo info=someInfo();
  String key="name";
  try {
    maps.assertDoesNotContainKey(info,actual,key);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainKey(actual,key));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
