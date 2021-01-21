@Test public void should_fail_if_objects_are_same(){
  AssertionInfo info=someInfo();
  Object actual=new Person("Yoda");
  try {
    objects.assertNotSame(info,actual,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeSame(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
