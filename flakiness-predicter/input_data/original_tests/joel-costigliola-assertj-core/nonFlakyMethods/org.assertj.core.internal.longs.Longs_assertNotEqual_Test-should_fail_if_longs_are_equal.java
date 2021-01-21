@Test public void should_fail_if_longs_are_equal(){
  AssertionInfo info=someInfo();
  try {
    longs.assertNotEqual(info,6L,6L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(6L,6L));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
