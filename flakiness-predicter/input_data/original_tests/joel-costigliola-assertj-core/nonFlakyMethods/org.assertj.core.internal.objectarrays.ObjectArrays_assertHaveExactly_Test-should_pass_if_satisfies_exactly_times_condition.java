@Test public void should_pass_if_satisfies_exactly_times_condition(){
  actual=array("Yoda","Luke","Leia");
  arrays.assertHaveExactly(someInfo(),actual,2,jediPower);
  verify(conditions).assertIsNotNull(jediPower);
}
