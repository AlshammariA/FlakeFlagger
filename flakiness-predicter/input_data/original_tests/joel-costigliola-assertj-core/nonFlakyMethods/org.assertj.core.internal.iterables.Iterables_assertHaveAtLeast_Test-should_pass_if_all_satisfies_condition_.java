@Test public void should_pass_if_all_satisfies_condition_(){
  actual=newArrayList("Yoda","Luke","Obiwan");
  iterables.assertHaveAtLeast(someInfo(),actual,2,jediPower);
  verify(conditions).assertIsNotNull(jediPower);
}
