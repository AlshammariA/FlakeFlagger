@Test public void should_fail_if_bytes_are_equal(){
  AssertionInfo info=someInfo();
  try {
    booleans.assertNotEqual(info,TRUE,true);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(TRUE,true));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
