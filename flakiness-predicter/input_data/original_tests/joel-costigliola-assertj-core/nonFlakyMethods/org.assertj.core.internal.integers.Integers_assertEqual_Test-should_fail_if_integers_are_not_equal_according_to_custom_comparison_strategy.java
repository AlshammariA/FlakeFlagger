@Test public void should_fail_if_integers_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    integersWithAbsValueComparisonStrategy.assertEqual(info,6,-8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6,-8,absValueComparisonStrategy,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
