@Test public void should_pass_if_satisfies_at_least_times_condition(){
  actual=array("Yoda","Luke","Leia");
  arrays.assertAreAtLeast(someInfo(),actual,2,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
