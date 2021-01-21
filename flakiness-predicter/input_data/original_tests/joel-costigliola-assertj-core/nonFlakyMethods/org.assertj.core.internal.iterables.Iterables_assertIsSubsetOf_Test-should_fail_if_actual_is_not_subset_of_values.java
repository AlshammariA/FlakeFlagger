@Test public void should_fail_if_actual_is_not_subset_of_values(){
  AssertionInfo info=someInfo();
  actual=newArrayList("Yoda");
  List<String> values=newArrayList("C-3PO","Leila");
  List<String> extra=newArrayList("Yoda");
  try {
    iterables.assertIsSubsetOf(info,actual,values);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSubsetOf(actual,values,extra));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
