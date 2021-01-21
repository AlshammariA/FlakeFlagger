@Test public void should_fail_if_actual_does_not_start_with_prefix(){
  AssertionInfo info=someInfo();
  try {
    strings.assertStartsWith(info,"Yoda","Luke");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldStartWith("Yoda","Luke"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
