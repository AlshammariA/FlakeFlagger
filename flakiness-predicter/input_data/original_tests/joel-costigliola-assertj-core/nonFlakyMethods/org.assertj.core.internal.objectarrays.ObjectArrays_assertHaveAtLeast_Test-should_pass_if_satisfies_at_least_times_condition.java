@Test public void should_pass_if_satisfies_at_least_times_condition(){
  actual=array("Yoda","Luke","Leia");
  arrays.assertHaveAtLeast(someInfo(),actual,2,jediPower);
  verify(conditions).assertIsNotNull(jediPower);
}
