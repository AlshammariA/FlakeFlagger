@Test public void should_fail_if_objects_are_equal(){
  AssertionInfo info=someInfo();
  try {
    objects.assertNotEqual(info,"Yoda","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual("Yoda","Yoda"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
