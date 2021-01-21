@Test public void should_fail_if_actual_contains_duplicates_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=array("LUKE","Yoda","Luke","Yoda");
  try {
    arraysWithCustomComparisonStrategy.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet("Luke","Yoda"),caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
