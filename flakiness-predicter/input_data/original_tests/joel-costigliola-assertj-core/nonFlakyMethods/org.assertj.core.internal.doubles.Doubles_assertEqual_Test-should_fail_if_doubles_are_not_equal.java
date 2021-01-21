@Test public void should_fail_if_doubles_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    doubles.assertEqual(info,6d,8d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(6d,8d,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
