@Test public void should_pass_if_actual_contains_both_partial_and_complete_subsequence(){
  actual=newArrayList("Yoda","Luke","Yoda","Obi-Wan");
  iterables.assertContainsSubsequence(someInfo(),actual,array("Yoda","Obi-Wan"));
}
