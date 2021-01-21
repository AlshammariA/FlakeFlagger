@Test public void should_fail_if_doubles_are_equal(){
  AssertionInfo info=someInfo();
  try {
    doubles.assertNotEqual(info,6d,6d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(6d,6d));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
