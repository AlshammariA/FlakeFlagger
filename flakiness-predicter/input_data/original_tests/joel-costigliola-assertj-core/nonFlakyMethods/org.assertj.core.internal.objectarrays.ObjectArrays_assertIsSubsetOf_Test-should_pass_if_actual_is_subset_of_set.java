@Test public void should_pass_if_actual_is_subset_of_set(){
  actual=array("Yoda","Luke");
  arrays.assertIsSubsetOf(someInfo(),actual,newArrayList("Luke","Yoda","Obi-Wan"));
}
