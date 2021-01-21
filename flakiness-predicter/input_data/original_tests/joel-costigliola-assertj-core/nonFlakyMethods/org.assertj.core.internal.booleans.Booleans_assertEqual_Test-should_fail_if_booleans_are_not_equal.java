@Test public void should_fail_if_booleans_are_not_equal(){
  AssertionInfo info=someInfo();
  boolean expected=false;
  try {
    booleans.assertEqual(info,TRUE,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(TRUE,expected,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
