@Test public void should_pass_if_satisfies_exactly_times_condition(){
  actual=newArrayList("Yoda","Luke","Leia");
  iterables.assertHaveExactly(someInfo(),actual,2,jediPower);
  verify(conditions).assertIsNotNull(jediPower);
}
