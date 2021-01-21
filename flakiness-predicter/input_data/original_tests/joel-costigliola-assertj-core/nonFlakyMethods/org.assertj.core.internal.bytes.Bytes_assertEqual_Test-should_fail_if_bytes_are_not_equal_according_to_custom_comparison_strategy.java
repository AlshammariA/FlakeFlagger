@Test public void should_fail_if_bytes_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bytesWithAbsValueComparisonStrategy.assertEqual(info,(byte)6,(byte)8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual((byte)6,(byte)8,absValueComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
