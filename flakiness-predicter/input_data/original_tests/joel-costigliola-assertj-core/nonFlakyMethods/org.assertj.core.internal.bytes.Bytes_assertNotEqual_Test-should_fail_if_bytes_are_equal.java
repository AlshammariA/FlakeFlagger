@Test public void should_fail_if_bytes_are_equal(){
  AssertionInfo info=someInfo();
  try {
    bytes.assertNotEqual(info,(byte)6,(byte)6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual((byte)6,(byte)6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
