@Test public void should_fail_if_longs_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    longs.assertEqual(info,6L,8L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6L,8L,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
