@Test public void should_fail_if_integers_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    integers.assertEqual(info,6,8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6,8,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
