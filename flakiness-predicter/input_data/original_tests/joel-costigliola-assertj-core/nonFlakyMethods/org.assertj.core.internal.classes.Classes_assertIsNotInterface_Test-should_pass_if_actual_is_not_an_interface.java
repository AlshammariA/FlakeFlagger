@Test public void should_pass_if_actual_is_not_an_interface(){
  actual=Classes_assertIsNotInterface_Test.class;
  classes.assertIsNotInterface(someInfo(),actual);
}
