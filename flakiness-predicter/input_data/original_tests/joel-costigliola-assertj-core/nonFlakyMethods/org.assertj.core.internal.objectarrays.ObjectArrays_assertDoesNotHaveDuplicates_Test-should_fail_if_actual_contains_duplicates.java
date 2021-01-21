@Test public void should_fail_if_actual_contains_duplicates(){
  AssertionInfo info=someInfo();
  actual=array("Luke","Yoda","Luke","Yoda");
  try {
    arrays.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet("Luke","Yoda")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
