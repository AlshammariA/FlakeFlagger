@Test public void should_fail_if_actual_has_no_parent() throws Exception {
  AssertionInfo info=someInfo();
  File withoutParent=new File("without-parent");
  try {
    files.assertHasParent(info,withoutParent,expectedParent);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveParent(withoutParent,expectedParent));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
