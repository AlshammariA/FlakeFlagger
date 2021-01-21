@Test public void should_fail_if_actual_does_not_contain_all_iterable_values(){
  AssertionInfo info=someInfo();
  List<String> expected=newArrayList("Han","Luke");
  try {
    arrays.assertContainsAll(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContain(actual,expected.toArray(),newLinkedHashSet("Han")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
