@Test public void should_fail_if_object_is_null(){
  AssertionInfo info=someInfo();
  try {
    objects.assertNotNull(info,null);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeNull());
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
