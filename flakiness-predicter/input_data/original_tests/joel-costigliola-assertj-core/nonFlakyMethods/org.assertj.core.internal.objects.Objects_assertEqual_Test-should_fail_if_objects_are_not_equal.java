@Test public void should_fail_if_objects_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    objects.assertEqual(info,"Luke","Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual("Luke","Yoda",info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
