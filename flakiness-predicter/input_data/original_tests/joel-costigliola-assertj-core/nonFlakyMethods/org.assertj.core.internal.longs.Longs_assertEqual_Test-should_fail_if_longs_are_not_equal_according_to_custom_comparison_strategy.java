@Test public void should_fail_if_longs_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    longsWithAbsValueComparisonStrategy.assertEqual(info,6L,8L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6L,8L,absValueComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
