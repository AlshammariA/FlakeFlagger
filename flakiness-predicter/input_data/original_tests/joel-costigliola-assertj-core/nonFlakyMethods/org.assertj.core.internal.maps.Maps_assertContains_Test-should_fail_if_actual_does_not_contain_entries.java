@Test public void should_fail_if_actual_does_not_contain_entries(){
  AssertionInfo info=someInfo();
  MapEntry<String,String>[] expected=array(entry("name","Yoda"),entry("job","Jedi"));
  try {
    maps.assertContains(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContain(actual,expected,newLinkedHashSet(entry("job","Jedi"))));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
