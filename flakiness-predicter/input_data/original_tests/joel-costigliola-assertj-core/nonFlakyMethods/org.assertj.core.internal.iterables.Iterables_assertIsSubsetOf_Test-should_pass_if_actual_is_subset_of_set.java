@Test public void should_pass_if_actual_is_subset_of_set(){
  actual=newArrayList("Yoda","Luke");
  iterables.assertIsSubsetOf(someInfo(),actual,newArrayList("Luke","Yoda","Obi-Wan"));
}
