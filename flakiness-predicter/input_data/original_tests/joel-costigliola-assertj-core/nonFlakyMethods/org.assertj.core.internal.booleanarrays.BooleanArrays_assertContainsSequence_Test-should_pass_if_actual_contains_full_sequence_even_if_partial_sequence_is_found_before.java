@Test public void should_pass_if_actual_contains_full_sequence_even_if_partial_sequence_is_found_before(){
  AssertionInfo info=someInfo();
  boolean[] sequence={false,true};
  arrays.assertContainsSequence(info,actual,sequence);
}
