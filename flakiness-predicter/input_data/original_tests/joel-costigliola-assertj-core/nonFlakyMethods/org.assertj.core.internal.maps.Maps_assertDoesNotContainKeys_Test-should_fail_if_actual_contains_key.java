@Test public void should_fail_if_actual_contains_key(){
  AssertionInfo info=someInfo();
  String key="name";
  try {
    maps.assertDoesNotContainKeys(info,actual,key);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainKeys(actual,newLinkedHashSet(key)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
