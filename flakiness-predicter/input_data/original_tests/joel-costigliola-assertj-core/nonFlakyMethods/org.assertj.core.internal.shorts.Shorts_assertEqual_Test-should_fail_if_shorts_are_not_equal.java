@Test public void should_fail_if_shorts_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    shorts.assertEqual(info,(short)6,(short)8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual((short)6,(short)8,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
