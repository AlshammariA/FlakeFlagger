@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    bytes.assertLessThan(info,(byte)6,(byte)6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess((byte)6,(byte)6));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
