@Test public void should_fail_if_integers_are_equal(){
  AssertionInfo info=someInfo();
  try {
    integers.assertNotEqual(info,6,6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(6,6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
