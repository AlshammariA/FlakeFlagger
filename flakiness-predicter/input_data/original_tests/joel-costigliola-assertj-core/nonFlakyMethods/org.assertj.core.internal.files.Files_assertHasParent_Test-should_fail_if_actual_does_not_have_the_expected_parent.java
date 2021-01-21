@Test public void should_fail_if_actual_does_not_have_the_expected_parent() throws Exception {
  AssertionInfo info=someInfo();
  File expectedParent=new File("./expected-parent");
  try {
    files.assertHasParent(info,actual,expectedParent);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveParent(actual,expectedParent));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
