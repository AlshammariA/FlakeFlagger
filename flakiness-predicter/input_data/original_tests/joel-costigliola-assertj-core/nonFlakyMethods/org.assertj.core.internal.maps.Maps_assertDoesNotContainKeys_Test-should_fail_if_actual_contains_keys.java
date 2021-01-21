@Test public void should_fail_if_actual_contains_keys(){
  AssertionInfo info=someInfo();
  String key1="name";
  String key2="color";
  try {
    maps.assertDoesNotContainKeys(info,actual,key1,key2);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainKeys(actual,newLinkedHashSet(key1,key2)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
