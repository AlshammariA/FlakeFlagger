@Test public void should_fail_if_actual_is_instance_of_type(){
  AssertionInfo info=someInfo();
  try {
    objects.assertIsNotInstanceOf(info,actual,Person.class);
    fail();
  }
 catch (  AssertionError err) {
  }
  verify(failures).failure(info,shouldNotBeInstance(actual,Person.class));
}
