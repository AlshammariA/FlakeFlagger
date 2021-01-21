@Test public void should_fail_if_actual_does_not_contain_key(){
  AssertionInfo info=someInfo();
  String key="power";
  try {
    maps.assertContainsKeys(info,actual,key);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainKeys(actual,newLinkedHashSet(key)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
