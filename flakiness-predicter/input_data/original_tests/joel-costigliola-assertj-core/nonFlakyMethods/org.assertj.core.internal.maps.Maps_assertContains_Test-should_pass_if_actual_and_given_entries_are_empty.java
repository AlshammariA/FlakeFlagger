@SuppressWarnings("unchecked") @Test public void should_pass_if_actual_and_given_entries_are_empty(){
  actual=new HashMap<>();
  maps.assertContains(someInfo(),actual,new MapEntry[0]);
}
