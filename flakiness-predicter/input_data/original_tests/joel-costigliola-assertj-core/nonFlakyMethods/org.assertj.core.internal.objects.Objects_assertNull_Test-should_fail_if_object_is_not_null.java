@Test public void should_fail_if_object_is_not_null(){
  AssertionInfo info=someInfo();
  Object actual=new Object();
  try {
    objects.assertNull(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(actual,null,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
