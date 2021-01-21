@Test public void should_fail_if_actual_contains_one_element_of_given_iterable(){
  AssertionInfo info=someInfo();
  List<String> list=newArrayList("Vador","Yoda","Han");
  try {
    arrays.assertDoesNotContainAnyElementsOf(info,actual,list);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,list.toArray(),newLinkedHashSet("Yoda")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
