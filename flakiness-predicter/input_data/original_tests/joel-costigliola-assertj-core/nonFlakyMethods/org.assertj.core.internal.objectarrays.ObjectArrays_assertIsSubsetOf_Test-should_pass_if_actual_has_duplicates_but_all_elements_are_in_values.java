@Test public void should_pass_if_actual_has_duplicates_but_all_elements_are_in_values(){
  actual=array("Yoda","Yoda");
  arrays.assertIsSubsetOf(someInfo(),actual,newArrayList("Yoda"));
}
