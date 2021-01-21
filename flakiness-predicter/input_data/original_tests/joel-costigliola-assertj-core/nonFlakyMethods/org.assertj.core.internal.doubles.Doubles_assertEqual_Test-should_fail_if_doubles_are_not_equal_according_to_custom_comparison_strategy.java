@Test public void should_fail_if_doubles_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    doublesWithAbsValueComparisonStrategy.assertEqual(info,6d,8d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6d,8d,absValueComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
