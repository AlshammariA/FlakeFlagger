@Test public void should_pass_if_satisfies_exactly_times_condition(){
  actual=newArrayList("Yoda","Luke","Leia");
  iterables.assertAreExactly(someInfo(),actual,2,jedi);
  verify(conditions).assertIsNotNull(jedi);
}
