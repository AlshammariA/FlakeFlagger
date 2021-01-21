@Test public void should_fail_if_actual_does_not_contain_value(){
  AssertionInfo info=someInfo();
  String value="veryOld";
  String value2="veryOld2";
  try {
    maps.assertContainsValues(info,actual,value,value2);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainValues(actual,newLinkedHashSet(value,value2)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
