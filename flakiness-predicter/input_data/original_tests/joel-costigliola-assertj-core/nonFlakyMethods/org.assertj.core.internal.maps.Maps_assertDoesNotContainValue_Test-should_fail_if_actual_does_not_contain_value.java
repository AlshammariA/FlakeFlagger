@Test public void should_fail_if_actual_does_not_contain_value(){
  AssertionInfo info=someInfo();
  String value="Yoda";
  try {
    maps.assertDoesNotContainValue(info,actual,value);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainValue(actual,value));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
