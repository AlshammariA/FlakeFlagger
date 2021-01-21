@Test public void should_fail_if_sequence_is_bigger_than_actual_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Yoda","LUKE","Leia","Obi-Wan","Han","C-3PO","R2-D2","Anakin"};
  try {
    arraysWithCustomComparisonStrategy.assertEndsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldEndWith(actual,sequence,caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
