@Test public void should_fail_if_floats_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    floatsWithAbsValueComparisonStrategy.assertEqual(info,6f,-8f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6f,-8f,absValueComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
