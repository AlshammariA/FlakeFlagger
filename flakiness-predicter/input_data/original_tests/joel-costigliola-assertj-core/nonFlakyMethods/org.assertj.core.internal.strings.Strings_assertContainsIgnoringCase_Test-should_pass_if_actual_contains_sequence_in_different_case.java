@Test public void should_pass_if_actual_contains_sequence_in_different_case(){
  strings.assertContainsIgnoringCase(someInfo(),"Yoda","yo");
}
