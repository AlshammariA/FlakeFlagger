@Test public void should_fail_if_objects_are_not_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    objectsWithCustomComparisonStrategy.assertEqual(info,"Luke","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual("Luke","Yoda",customComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
