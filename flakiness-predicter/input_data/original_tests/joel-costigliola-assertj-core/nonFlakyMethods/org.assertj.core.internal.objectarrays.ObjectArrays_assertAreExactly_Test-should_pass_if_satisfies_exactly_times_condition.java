@Test public void should_pass_if_satisfies_exactly_times_condition(){
  actual=array("Yoda","Luke","Leia");
  arrays.assertAreExactly(someInfo(),actual,2,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
