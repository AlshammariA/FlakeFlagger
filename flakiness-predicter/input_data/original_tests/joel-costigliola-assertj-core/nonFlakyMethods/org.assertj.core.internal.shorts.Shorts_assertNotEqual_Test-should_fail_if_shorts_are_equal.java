@Test public void should_fail_if_shorts_are_equal(){
  AssertionInfo info=someInfo();
  try {
    shorts.assertNotEqual(info,(short)6,(short)6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual((short)6,(short)6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
