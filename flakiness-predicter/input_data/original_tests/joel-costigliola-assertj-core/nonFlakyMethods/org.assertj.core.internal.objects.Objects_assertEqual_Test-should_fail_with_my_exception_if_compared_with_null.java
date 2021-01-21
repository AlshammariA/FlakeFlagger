@Test public void should_fail_with_my_exception_if_compared_with_null(){
  try {
    objects.assertEqual(someInfo(),new MyObject(),null);
  }
 catch (  MyObject.NullEqualsException e) {
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
