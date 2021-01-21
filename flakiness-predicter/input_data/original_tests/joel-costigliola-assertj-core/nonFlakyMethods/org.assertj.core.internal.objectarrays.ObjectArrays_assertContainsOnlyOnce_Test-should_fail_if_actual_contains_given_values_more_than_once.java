@Test public void should_fail_if_actual_contains_given_values_more_than_once(){
  AssertionInfo info=someInfo();
  actual=array("Luke","Yoda","Han","Luke","Yoda","Han","Yoda","Luke");
  String[] expected={"Luke","Yoda","Leia"};
  try {
    arrays.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("Leia"),newLinkedHashSet("Luke","Yoda")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
