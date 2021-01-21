@Test public void should_fail_if_characters_are_equal(){
  AssertionInfo info=someInfo();
  try {
    characters.assertNotEqual(info,'b','b');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual('b','b'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
