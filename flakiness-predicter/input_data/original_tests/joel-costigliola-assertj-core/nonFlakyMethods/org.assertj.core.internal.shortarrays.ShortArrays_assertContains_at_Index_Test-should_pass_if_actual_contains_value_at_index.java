@Test public void should_pass_if_actual_contains_value_at_index(){
  arrays.assertContains(someInfo(),actual,(short)8,atIndex(1));
}
