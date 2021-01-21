@Test public void should_fail_if_actual_is_not_instance_of_any_type(){
  AssertionInfo info=someInfo();
  Class<?>[] types={String.class,File.class};
  try {
    objects.assertIsInstanceOfAny(info,actual,types);
    fail();
  }
 catch (  AssertionError err) {
  }
  verify(failures).failure(info,shouldBeInstanceOfAny(actual,types));
}
