@Test public void should_fail_with_my_exception_if_compared_with_other_object(){
  try {
    objects.assertEqual(someInfo(),new MyObject(),"Yoda");
  }
 catch (  MyObject.DifferentClassesException e) {
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
