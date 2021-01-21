@Test public void should_fail_if_floats_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    floats.assertEqual(info,6f,8f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6f,8f,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
