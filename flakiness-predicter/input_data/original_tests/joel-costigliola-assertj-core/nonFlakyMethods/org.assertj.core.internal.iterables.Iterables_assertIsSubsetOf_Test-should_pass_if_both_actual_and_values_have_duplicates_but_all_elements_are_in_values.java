@Test public void should_pass_if_both_actual_and_values_have_duplicates_but_all_elements_are_in_values(){
  actual=newArrayList("Yoda","Yoda","Yoda","C-3PO","Obi-Wan");
  iterables.assertIsSubsetOf(someInfo(),actual,newArrayList("Yoda","Yoda","C-3PO","C-3PO","Obi-Wan"));
}
