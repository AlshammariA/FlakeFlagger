@Test public void should_fail_if_bytes_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    bytes.assertEqual(info,(byte)6,(byte)8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual((byte)6,(byte)8,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
