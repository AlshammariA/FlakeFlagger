@Test public void should_fail_if_actual_does_not_contain_keys(){
  AssertionInfo info=someInfo();
  String key1="power";
  String key2="rangers";
  try {
    maps.assertContainsKeys(info,actual,key1,key2);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainKeys(actual,newLinkedHashSet(key1,key2)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
