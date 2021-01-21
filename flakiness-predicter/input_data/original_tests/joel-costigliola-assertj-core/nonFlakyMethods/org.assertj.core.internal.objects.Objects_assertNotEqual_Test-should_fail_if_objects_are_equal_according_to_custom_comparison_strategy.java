@Test public void should_fail_if_objects_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    objectsWithCustomComparisonStrategy.assertNotEqual(info,"YoDA","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual("YoDA","Yoda",customComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
