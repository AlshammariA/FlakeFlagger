@Test public void should_fail_if_actual_contains_given_values(){
  AssertionInfo info=someInfo();
  MapEntry<String,String>[] expected=array(entry("name","Yoda"),entry("job","Jedi"));
  try {
    maps.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet(entry("name","Yoda"))));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
