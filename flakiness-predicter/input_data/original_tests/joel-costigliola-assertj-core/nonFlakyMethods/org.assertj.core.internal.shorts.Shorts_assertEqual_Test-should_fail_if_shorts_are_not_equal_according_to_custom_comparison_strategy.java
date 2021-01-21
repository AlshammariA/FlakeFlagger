@Test public void should_fail_if_shorts_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    shortsWithAbsValueComparisonStrategy.assertEqual(info,(short)6,(short)8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual((short)6,(short)8,absValueComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
