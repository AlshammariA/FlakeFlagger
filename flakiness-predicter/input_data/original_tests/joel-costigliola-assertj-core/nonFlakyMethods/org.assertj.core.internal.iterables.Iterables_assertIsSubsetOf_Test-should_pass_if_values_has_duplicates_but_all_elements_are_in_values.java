@Test public void should_pass_if_values_has_duplicates_but_all_elements_are_in_values(){
  actual=newArrayList("Yoda","C-3PO");
  iterables.assertIsSubsetOf(someInfo(),actual,newArrayList("Yoda","Yoda","C-3PO"));
}
