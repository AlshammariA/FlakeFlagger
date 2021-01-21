@Test public void should_fail_if_floats_are_equal(){
  AssertionInfo info=someInfo();
  try {
    floats.assertNotEqual(info,6f,6f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(6f,6f));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
