@Test public void should_pass_if_actual_contains_full_sequence_even_if_partial_sequence_is_found_before(){
  actual=array("Yoda","Luke","Leia","Yoda","Luke","Obi-Wan");
  arrays.assertContainsSequence(someInfo(),actual,array("Yoda","Luke","Obi-Wan"));
}
