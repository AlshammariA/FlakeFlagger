@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    comparables.assertGreaterThan(info,"Yoda","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater("Yoda","Yoda"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
