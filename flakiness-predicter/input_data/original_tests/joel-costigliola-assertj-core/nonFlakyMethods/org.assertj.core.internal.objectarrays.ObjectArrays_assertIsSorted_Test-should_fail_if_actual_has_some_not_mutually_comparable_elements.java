@Test public void should_fail_if_actual_has_some_not_mutually_comparable_elements(){
  AssertionInfo info=someInfo();
  Object[] actual=new Object[]{"bar",new Integer(5),"foo"};
  try {
    arrays.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveMutuallyComparableElements(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
