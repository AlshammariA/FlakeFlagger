@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    comparables.assertLessThan(info,"Yoda","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess("Yoda","Yoda"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
