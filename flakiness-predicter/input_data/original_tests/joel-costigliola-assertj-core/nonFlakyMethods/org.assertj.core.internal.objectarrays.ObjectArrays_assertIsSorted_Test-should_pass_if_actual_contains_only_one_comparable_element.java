@Test public void should_pass_if_actual_contains_only_one_comparable_element(){
  actual=array("Obiwan");
  arrays.assertIsSorted(someInfo(),actual);
}
