@Test public void should_pass_if_actual_and_set_are_both_empty(){
  actual=new String[0];
  arrays.assertIsSubsetOf(someInfo(),actual,newArrayList());
}
