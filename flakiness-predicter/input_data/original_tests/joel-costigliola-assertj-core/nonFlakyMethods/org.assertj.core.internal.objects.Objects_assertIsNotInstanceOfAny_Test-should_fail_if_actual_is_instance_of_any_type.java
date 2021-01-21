@Test public void should_fail_if_actual_is_instance_of_any_type(){
  AssertionInfo info=someInfo();
  Class<?>[] types={String.class,Person.class};
  try {
    objects.assertIsNotInstanceOfAny(info,actual,types);
    fail();
  }
 catch (  AssertionError err) {
  }
  verify(failures).failure(info,shouldNotBeInstanceOfAny(actual,types));
}
