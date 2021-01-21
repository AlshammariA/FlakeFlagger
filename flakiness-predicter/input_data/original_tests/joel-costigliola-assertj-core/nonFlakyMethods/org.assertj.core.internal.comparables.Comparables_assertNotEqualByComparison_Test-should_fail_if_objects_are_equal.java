@Test public void should_fail_if_objects_are_equal(){
  AssertionInfo info=someInfo();
  try {
    comparables.assertNotEqualByComparison(info,"Yoda","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual("Yoda","Yoda"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
