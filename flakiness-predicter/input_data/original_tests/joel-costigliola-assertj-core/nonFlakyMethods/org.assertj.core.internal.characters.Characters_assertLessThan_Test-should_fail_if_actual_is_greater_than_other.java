@Test public void should_fail_if_actual_is_greater_than_other(){
  AssertionInfo info=someInfo();
  try {
    characters.assertLessThan(info,'b','a');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess('b','a'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
